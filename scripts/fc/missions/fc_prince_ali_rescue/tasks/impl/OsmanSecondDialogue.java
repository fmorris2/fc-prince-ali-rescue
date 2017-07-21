package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.OsmanDialogue;

public class OsmanSecondDialogue extends OsmanDialogue implements ItemsRequiredTask
{
	private static final long serialVersionUID = -8183670160907393611L;

	@Override
	public boolean execute()
	{
		if(super.execute())
		{
			PARSettings.GET_KEY_PRINT.resetJournalCaches();
			PARSettings.PICKUP_KEY.resetJournalCaches();
			return true;
		}
		
		return false;
	}
	@Override
	public boolean shouldExecute()
	{
		return PARSettings.OSMAN_SECOND_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Osman second dialogue";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, PARReqs.BRONZE_BAR),
			new FCItem(1, false, PARReqs.KEY_PRINT)
		};
	}

}
