package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tribot.api.Timing;
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

public class JoeSecondBeer extends JailTask implements ItemsRequiredTask, FutureTaskPreparer
{
	private static final long serialVersionUID = -4877156348145447970L;

	@Override
	protected boolean handle()
	{
		int start = Inventory.getAll().length;
		NpcDialogue dialogue = new NpcDialogue("Talk-to", "Joe", 10, 0,0);
		dialogue.setIgnoreChatName(true);
		return dialogue.execute() 
				&& Timing.waitCondition(FCConditions.inventoryChanged(start), 1200);
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.JOE_LAST_BEERS.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Joe second beer";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		List<FCItem> reqs = new ArrayList<>(Arrays.asList(new FCItem(2, false, PARReqs.BEER)));
		if(Inventory.getCount("Trout") == 0)
			reqs.add(new FCItem(2, false, PARReqs.TROUT));
		
		return reqs.toArray(new FCItem[reqs.size()]);
	}
	
	@Override
	public ItemsRequiredTask[] getFutureTasks()
	{
		PARTasks tasks = Vars.get().get("tasks");
		return new ItemsRequiredTask[]{tasks.LASSO_KELI, tasks.RESCUE_PRINCE};
	}

}
