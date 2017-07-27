package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.data.Vars;
import scripts.fc.framework.quest.BankBool;
import scripts.fc.framework.task.FutureTaskPreparer;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARTasks;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.OsmanDialogue;

public class OsmanFirstDialogue extends OsmanDialogue implements FutureTaskPreparer
{
	private static final long serialVersionUID = -6275528462105839160L;

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.OSMAN_FIRST_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Osman first dialogue";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		if(BankBool.bankObserver.containsItem(995, 10))
			return new FCItem[]{new FCItem(10, true, false, 995)};
		
		return new FCItem[]{};
	}

	@Override
	public ItemsRequiredTask[] getFutureTasks()
	{
		PARTasks tasks = Vars.get().get("tasks");
		return new ItemsRequiredTask[]{tasks.GET_WIG, tasks.DYE_WIG, tasks.GET_PASTE};
	}
}
