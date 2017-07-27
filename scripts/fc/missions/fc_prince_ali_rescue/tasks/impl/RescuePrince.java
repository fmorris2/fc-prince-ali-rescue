package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.PathFinding;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.JailTask;

public class RescuePrince extends JailTask implements ItemsRequiredTask
{
	private static final long serialVersionUID = 7136442358680624428L;
	private static final Positionable CELL_TILE = new RSTile(3123, 3243, 0);

	@Override
	protected boolean handle()
	{
		if(!inCell())
			return new ClickObject("Open", "Prison Door", 10).execute() && FCTiming.waitCondition(() -> inCell(), 3000);
		else
		{
			NpcDialogue dialogue = new NpcDialogue("Talk-to", "Prince Ali", 10);
			dialogue.setCheckPath(true);
			boolean success = dialogue.execute() || dialogue.wentThroughDialogue();
			if(success)
			{
				while(inCell())
					if(new ClickObject("Open", "Prison Door", 10).execute())
						FCTiming.waitCondition(() -> !inCell(), 3000);
			}
			
			return success;
		}
	}
	
	public static boolean inCell()
	{
		return Player.getPosition().distanceTo(CELL_TILE) < 10 && PathFinding.canReach(CELL_TILE, false);
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.RESCUE_PRINCE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Rescue prince";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		List<FCItem> reqs = new ArrayList<>(Arrays.asList(
				new FCItem(1, false, PARReqs.BRONZE_KEY), new FCItem(1, false, PARReqs.PINK_SKIRT),
				new FCItem(1, false, PARReqs.PASTE), new FCItem(1, false, PARReqs.YELLOW_WIG)
		));
		
		if(Inventory.getCount("Trout") == 0)
			reqs.add(new FCItem(2, false, false, PARReqs.TROUT));
		
		return reqs.toArray(new FCItem[reqs.size()]);
	}

}
