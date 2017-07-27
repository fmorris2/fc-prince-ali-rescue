package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tribot.api.Timing;
import org.tribot.api2007.Combat;
import org.tribot.api2007.Inventory;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.items.FCItem;
import scripts.fc.framework.data.Vars;
import scripts.fc.framework.task.FutureTaskPreparer;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARTasks;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.JailTask;

public class JoeFirstBeer extends JailTask implements ItemsRequiredTask, FutureTaskPreparer
{
	private static final long serialVersionUID = 7038814779289829460L;

	@Override
	protected boolean handle()
	{
		if(Combat.isUnderAttack())
			return false;
		
		int start = Inventory.getAll().length;
		NpcDialogue dialogue = new NpcDialogue("Talk-to", "Joe", 10, 0,0);
		dialogue.setIgnoreChatName(true);
		return dialogue.execute() 
				&& Timing.waitCondition(FCConditions.inventoryChanged(start), 1200);
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.JOE_FIRST_BEER.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Joe first beer";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		List<FCItem> reqs = new ArrayList<>(Arrays.asList(new FCItem(1, false, PARReqs.BEER)));
		if(Inventory.getCount("Trout") == 0)
			reqs.add(new FCItem(2, false, false, PARReqs.TROUT));
		
		return reqs.toArray(new FCItem[reqs.size()]);
	}

	@Override
	public ItemsRequiredTask[] getFutureTasks()
	{
		PARTasks tasks = Vars.get().get("tasks");
		return new ItemsRequiredTask[]{tasks.JOE_FIRST_BEER, tasks.JOE_SECOND_BEER, tasks.LASSO_KELI, tasks.RESCUE_PRINCE};
	}

}
