package scripts.fc.missions.fc_prince_ali_rescue.data;

import java.util.List;

import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.requirement.item.ItemRequirement;
import scripts.fc.framework.requirement.item.ReqItem;
import scripts.fc.framework.script.FCMissionScript;

public class PARReqs extends ItemRequirement
{
	public PARReqs(FCMissionScript script)
	{
		super(script);
	}

	@Override
	public ReqItem[] getReqItems()
	{
		return new ReqItem[]
		{
			
		};
	}

	@Override
	public List<Mission> getReqMissions()
	{
		return null;
	}

}
