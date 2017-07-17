package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.LeelaDialogue;

public class LeelaFirstDialogue extends LeelaDialogue
{
	private static final long serialVersionUID = -1491480807435721012L;

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.LEELA_FIRST_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Talk to Leela for advice";
	}

}
