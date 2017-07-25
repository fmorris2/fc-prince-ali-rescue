package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.LeelaDialogue;

public class LeelaSecondDialogue extends LeelaDialogue implements ItemsRequiredTask
{
	private static final long serialVersionUID = -4410159210917845758L;

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.LEELA_SECOND_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Leela second dialogue";
	}
	
	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, PARReqs.PINK_SKIRT),
			new FCItem(1, false, PARReqs.PASTE),
			new FCItem(1, false, PARReqs.YELLOW_WIG),
			new FCItem(3, false, PARReqs.BEER),
			new FCItem(1, false, PARReqs.BRONZE_KEY),
			new FCItem(1, false, PARReqs.ROPE)
		};
	}

}
