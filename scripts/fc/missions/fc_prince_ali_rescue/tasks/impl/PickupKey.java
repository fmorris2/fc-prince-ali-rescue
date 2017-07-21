package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.LeelaDialogue;

public class PickupKey extends LeelaDialogue
{
	private static final long serialVersionUID = -4448504646250661589L;

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.PICKUP_KEY.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Pickup key";
	}

}
