package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tribot.api.General;
import org.tribot.api2007.Combat;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.NPCs;

import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.utils.Utils;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.SpaceRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.JailTask;

public class GetKeyPrint extends JailTask implements ItemsRequiredTask, SpaceRequiredTask
{
	public static final int COMBAT_THRESH = 53;
	
	private static final long serialVersionUID = 5883609471833300426L;
	
	public boolean handle()
	{
		if(Combat.isUnderAttack())
			return false;
		
		return handleInJail();
	}
	
	private boolean handleInJail()
	{
		General.println("In jail & safe");
		if(!Combat.isUnderAttack() && (!isKeliInJail() || isJailGuardInJail()))
		{
			General.println("Needs to hop - Either Keli is not in jail or Jail guard is in jail");
			hop();
		}
		else
		{
			General.println("Talking to keli");
			NpcDialogue dialogue = new NpcDialogue("Talk-to", "Lady Keli", 10, 0,1,0,1,0,0);
			dialogue.setCheckPath(true);
			return dialogue.execute();
		}
		
		return false;
	}
	
	public static boolean isKeliInJail()
	{
		return Arrays.stream(NPCs.find("Lady Keli")).anyMatch(n -> Utils.isInBuilding(n));
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.GET_KEY_PRINT.isValid();
	}
	
	@Override
	public int getSpaceRequired()
	{
		return 25;
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		List<FCItem> reqs = new ArrayList<>(Arrays.asList(new FCItem(1, false, PARReqs.SOFT_CLAY)));
		if(Inventory.getCount("Trout") == 0)
			reqs.add(new FCItem(2, false, false, PARReqs.TROUT));
		
		return reqs.toArray(new FCItem[reqs.size()]);
	}

	@Override
	public String getStatus()
	{
		return "Get key print";
	}

}
