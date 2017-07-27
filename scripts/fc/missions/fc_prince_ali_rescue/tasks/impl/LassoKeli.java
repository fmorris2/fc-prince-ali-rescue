package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tribot.api.General;
import org.tribot.api2007.Combat;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.NPCChat;

import scripts.fc.api.interaction.impl.npcs.ItemOnNpc;
import scripts.fc.api.interaction.impl.npcs.dialogue.DialogueThread;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.data.Vars;
import scripts.fc.framework.task.FutureTaskPreparer;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARTasks;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.JailTask;

public class LassoKeli extends JailTask implements ItemsRequiredTask, FutureTaskPreparer
{
	private static final long serialVersionUID = -2587544038624975097L;

	@Override
	protected boolean handle()
	{
		if(Combat.isUnderAttack())
			return false;
		
		if(!GetKeyPrint.isKeliInJail())
		{
			General.println("Needs to hop - Keli is not in jail");
			hop();
		}
		else if(isJailGuardInJail())
		{
			General.println("Needs to hop - Jail guard is in jail");
			hop();
		}
		else if(NPCChat.getSelectOptionInterface() == null && DialogueThread.areDialogueInterfacesUp())
		{	
			DialogueThread.doClickToContinue();
		}
		else if(new ItemOnNpc("Rope", "Lady Keli", 10).execute())
			return FCTiming.waitCondition(() -> Inventory.getCount("Rope") == 0, 2400);
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.LASSO_KELI.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Lasso Keli";
	}
	
	@Override
	public FCItem[] getRequiredItems()
	{
		List<FCItem> reqs = new ArrayList<>(Arrays.asList(new FCItem(1, false, PARReqs.ROPE)));
		if(Inventory.getCount("Trout") == 0)
			reqs.add(new FCItem(2, false, false, PARReqs.TROUT));
		
		return reqs.toArray(new FCItem[reqs.size()]);
	}
	
	@Override
	public ItemsRequiredTask[] getFutureTasks()
	{
		PARTasks tasks = Vars.get().get("tasks");
		return new ItemsRequiredTask[]{tasks.RESCUE_PRINCE};
	}
}
