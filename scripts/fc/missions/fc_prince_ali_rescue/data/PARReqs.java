package scripts.fc.missions.fc_prince_ali_rescue.data;

import java.util.List;

import scripts.fc.framework.mission.Mission;
import scripts.fc.framework.requirement.item.ItemRequirement;
import scripts.fc.framework.requirement.item.ReqItem;
import scripts.fc.framework.requirement.item.SingleReqItem;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.missions.fc_prince_ali_rescue.FCPrinceAliRescue;

public class PARReqs extends ItemRequirement
{
	public static final int WOOL = 1759, WIG = 2421, DYE = 1765, YELLOW_WIG = 2419,
			REDBERRIES = 1951, ASHES = 592, POT_OF_FLOUR = 1933, BUCKET_OF_WATER = 1929,
			PASTE = 2424, SOFT_CLAY = 1761, KEY_PRINT = 2423, BRONZE_BAR = 2349, BRONZE_KEY = 2418,
			BEER = 1917, ROPE = 954, PINK_SKIRT = 1013;
	
	private static final int S = FCPrinceAliRescue.SETTING;
	
	public PARReqs(FCMissionScript script)
	{
		super(script);
	}

	@Override
	public ReqItem[] getReqItems()
	{
		return new ReqItem[]
		{
			//WOOL
			new SingleReqItem(WOOL, 3, true, true).when(PARSettings.GET_WIG.getBools())
		};
	}

	@Override
	public List<Mission> getReqMissions()
	{
		return null;
	}

}
