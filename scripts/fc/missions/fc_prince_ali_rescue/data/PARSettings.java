package scripts.fc.missions.fc_prince_ali_rescue.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scripts.fc.framework.quest.InvBankBool;
import scripts.fc.framework.quest.InvBankBool.TYPE;
import scripts.fc.framework.quest.Order;
import scripts.fc.framework.quest.QuestBool;
import scripts.fc.framework.quest.QuestJournalBool;
import scripts.fc.framework.quest.QuestJournalBool.JOURNAL_STATUS;
import scripts.fc.framework.quest.QuestState;
import scripts.fc.framework.quest.SettingBool;
import scripts.fc.missions.fc_prince_ali_rescue.FCPrinceAliRescue;

public enum PARSettings
{
	START_QUEST
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 0, true, Order.EQUALS)
		)
	),
	
	OSMAN_FIRST_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 10, true, Order.EQUALS)
		)
	),
	
	LEELA_FIRST_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 20, true, Order.EQUALS),
			new QuestJournalBool(FCPrinceAliRescue.QUEST_NAME, "Talk to Leela near Draynor Village for advice.", JOURNAL_STATUS.CONTAINS_STRING, true)
		)
	),
	
	GET_WIG
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 20, true, Order.AFTER_EQUALS)
			.and(new SettingBool(FCPrinceAliRescue.SETTING, 100, true, Order.BEFORE))
			.and(new InvBankBool(PARReqs.WIG, 1, TYPE.IN_ONE, false))
			.and(new InvBankBool(PARReqs.YELLOW_WIG, 1, TYPE.IN_ONE, false))
		)
	),
	
	DYE_WIG
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 20, true, Order.AFTER_EQUALS)
			.and(new SettingBool(FCPrinceAliRescue.SETTING, 100, true, Order.BEFORE))
			.and(new InvBankBool(PARReqs.WIG, 1, TYPE.IN_ONE, true))
			.and(new InvBankBool(PARReqs.YELLOW_WIG, 1, TYPE.IN_ONE, false))
		)
	),
	
	GET_PASTE
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 20, true, Order.AFTER_EQUALS)
			.and(new SettingBool(FCPrinceAliRescue.SETTING, 100, true, Order.BEFORE))
			.and(new InvBankBool(PARReqs.PASTE, 1, TYPE.IN_ONE, false))
		)
	),
	
	GET_KEY_PRINT
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 20, true, Order.AFTER_EQUALS)
			.and(new SettingBool(FCPrinceAliRescue.SETTING, 100, true, Order.BEFORE))
			.and(new InvBankBool(PARReqs.KEY_PRINT, 1, TYPE.IN_ONE, false))
			.and(new InvBankBool(PARReqs.BRONZE_KEY, 1, TYPE.IN_ONE, false))
			.and(new QuestJournalBool(FCPrinceAliRescue.QUEST_NAME, "I have duplicated a key, I need to get it from Leela", 
					JOURNAL_STATUS.CONTAINS_STRING, false))
		)
	),
	
	OSMAN_SECOND_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 20, true, Order.AFTER_EQUALS)
			.and(new SettingBool(FCPrinceAliRescue.SETTING, 100, true, Order.BEFORE))
			.and(new InvBankBool(PARReqs.KEY_PRINT, 1, TYPE.IN_ONE, true))
			.and(new QuestJournalBool(FCPrinceAliRescue.QUEST_NAME, "I have duplicated a key, I need to get it from Leela", 
					JOURNAL_STATUS.CONTAINS_STRING, false))
		)
	),
	
	PICKUP_KEY
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 20, true, Order.AFTER_EQUALS)
			.and(new SettingBool(FCPrinceAliRescue.SETTING, 100, true, Order.BEFORE))
			.and(new InvBankBool(PARReqs.BRONZE_KEY, 1, TYPE.IN_ONE, false))
			.and(new QuestJournalBool(FCPrinceAliRescue.QUEST_NAME, "I have duplicated a key, I need to get it from Leela", 
					JOURNAL_STATUS.CONTAINS_STRING, true))
		)
	),
	
	LEELA_SECOND_DIALOGUE
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 20, true, Order.EQUALS)
			.and(new InvBankBool(PARReqs.BRONZE_KEY, 1, TYPE.IN_ONE, true))
			.and(new InvBankBool(PARReqs.PINK_SKIRT, 1, TYPE.IN_ONE, true))
			.and(new InvBankBool(PARReqs.YELLOW_WIG, 1, TYPE.IN_ONE, true))
			.and(new InvBankBool(PARReqs.PASTE, 1, TYPE.IN_ONE, true))
			.and(new InvBankBool(PARReqs.ROPE, 1, TYPE.IN_ONE, true))
		)
	),
	
	JOE_FIRST_BEER
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 30, true, Order.EQUALS)
		)
	),
	
	JOE_LAST_BEERS
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 31, true, Order.EQUALS)
		)
	),
	
	LASSO_KELI
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 40, true, Order.EQUALS)
		)
	),
	
	RESCUE_PRINCE
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 50, true, Order.EQUALS)
		)
	),
	
	TURN_IN_QUEST
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 100, true, Order.EQUALS)
		)
	),
	
	QUEST_COMPLETE
	(
		new QuestState
		(
			new SettingBool(FCPrinceAliRescue.SETTING, 110, true, Order.AFTER_EQUALS)
		)
	);
	
	private QuestState[] states;
	
	PARSettings(QuestState... states)
	{
		this.states = states;
	}
	
	public boolean isValid()
	{
		return Arrays.stream(states).allMatch(s -> s.validate());
	}
	
	public void resetJournalCaches()
	{
		Arrays.stream(getBools())
			.filter(b -> b instanceof QuestJournalBool)
			.forEach(qjb -> ((QuestJournalBool)(qjb)).resetCache()
		);
	}
	
	public QuestBool[] getBools()
	{
		List<QuestBool> bools = new ArrayList<>();
		Arrays.stream(states).forEach(s -> Arrays.stream(s.getBools()).forEach(b -> bools.add(b)));
		return bools.toArray(new QuestBool[bools.size()]);
	}
	
	public QuestState[] getStates()
	{
		return states;
	}
}
