package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.OsmanDialogue;

public class OsmanFirstDialogue extends OsmanDialogue
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

}
