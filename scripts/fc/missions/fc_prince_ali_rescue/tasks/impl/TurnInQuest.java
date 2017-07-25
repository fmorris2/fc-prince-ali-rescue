package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;

public class TurnInQuest extends Task
{
	private static final long serialVersionUID = -2391460475356758836L;

	@Override
	public boolean execute()
	{
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.TURN_IN_QUEST.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Turn in quest";
	}

}
