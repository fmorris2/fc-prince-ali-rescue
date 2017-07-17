package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.HassanDialogue;

public class StartQuest extends HassanDialogue
{
	private static final long serialVersionUID = 1978600238644618469L;

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.START_QUEST.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Start quest";
	}

}
