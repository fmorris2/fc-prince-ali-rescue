package scripts.fc.missions.fc_prince_ali_rescue.data;

import scripts.fc.framework.quest.CombatLevelBool;
import scripts.fc.framework.quest.InvBankBool;
import scripts.fc.framework.quest.InvBankBool.TYPE;
import scripts.fc.framework.quest.Order;
import scripts.fc.framework.quest.QuestJournalBool;
import scripts.fc.framework.quest.QuestJournalBool.JOURNAL_STATUS;
import scripts.fc.framework.quest.SettingBool;
import scripts.fc.framework.requirement.item.ItemRequirement;
import scripts.fc.framework.requirement.item.ReqItem;
import scripts.fc.framework.requirement.item.SingleReqItem;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.missions.fc_prince_ali_rescue.FCPrinceAliRescue;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.GetKeyPrint;

public class PARReqs extends ItemRequirement
{
	public static final int WOOL = 1759, WIG = 2421, DYE = 1765, YELLOW_WIG = 2419,
			REDBERRIES = 1951, ASHES = 592, POT_OF_FLOUR = 1933, BUCKET_OF_WATER = 1929,
			PASTE = 2424, SOFT_CLAY = 1761, KEY_PRINT = 2423, BRONZE_BAR = 2349, BRONZE_KEY = 2418,
			BEER = 1917, ROPE = 954, PINK_SKIRT = 1013, TROUT = 333;
	
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
			new SingleReqItem(WOOL, 3, true, true).when
			(
				new SettingBool(S, 100, true, Order.BEFORE)
				.and(new InvBankBool(WIG, 1, TYPE.IN_ONE, false))
				.and(new InvBankBool(YELLOW_WIG, 1, TYPE.IN_ONE, false))
			),
			
			//DYE
			new SingleReqItem(DYE, 1, true, true).when
			(
				new SettingBool(S, 100, true, Order.BEFORE)
				.and(new InvBankBool(YELLOW_WIG, 1, TYPE.IN_ONE, false))
			),
			
			//PASTE REQUIREMENTS
			new SingleReqItem(REDBERRIES, 1, true, true).and
			(new SingleReqItem(ASHES, 1, true, true)).and
			(new SingleReqItem(POT_OF_FLOUR, 1, true, true)).and
			(new SingleReqItem(BUCKET_OF_WATER, 1, true, true))
			.when
			(
				new SettingBool(S, 100, true, Order.BEFORE)
				.and(new InvBankBool(PASTE, 1, TYPE.IN_ONE, false))
			),
			
			//TROUT
			new SingleReqItem(TROUT, 6, true, true)
			.when
			(
				new SettingBool(S, 100, true, Order.BEFORE)
				.and(new CombatLevelBool(GetKeyPrint.COMBAT_THRESH, false))
				.and(new InvBankBool(TROUT, 2, TYPE.IN_ONE, false))
			),
			
			//KEY PRINT REQUIREMENTS
			new SingleReqItem(SOFT_CLAY, 1, true, true)
			.when
			(
				new SettingBool(S, 100, true, Order.BEFORE)
				.and(new InvBankBool(KEY_PRINT, 1, TYPE.IN_ONE, false))
				.and(new InvBankBool(BRONZE_KEY, 1, TYPE.IN_ONE, false))
				.and(new QuestJournalBool(FCPrinceAliRescue.QUEST_NAME, "I have duplicated a key, I need to get it from Leela", 
					JOURNAL_STATUS.CONTAINS_STRING, false))
			),
			
			//BRONZE BAR REQUIREMENTS
			new SingleReqItem(BRONZE_BAR, 1, true, true).when
			(
				new SettingBool(S, 100, true, Order.BEFORE)
				.and(new InvBankBool(BRONZE_KEY, 1, TYPE.IN_ONE, false))
				.and(new QuestJournalBool(FCPrinceAliRescue.QUEST_NAME, "I have duplicated a key, I need to get it from Leela", 
					JOURNAL_STATUS.CONTAINS_STRING, false))
			),
			
			//BEER REQUIREMENTS			
			new SingleReqItem(BEER, 3, true, true).when
			(
				new SettingBool(S, 31, true, Order.BEFORE_EQUALS)
			),
			
			//ROPE REQUIREMENT
			new SingleReqItem(ROPE, 1, true, true).when
			(
				new SettingBool(S, 40, true, Order.BEFORE_EQUALS)
			),
			
			//PINK SKIRT REQUIREMENT
			new SingleReqItem(PINK_SKIRT, 1, true, true).when
			(
				new SettingBool(S, 50, true, Order.BEFORE_EQUALS)
			)	
		};
	}
}
