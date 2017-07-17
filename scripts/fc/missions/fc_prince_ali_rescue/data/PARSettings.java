package scripts.fc.missions.fc_prince_ali_rescue.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import scripts.fc.framework.quest.InvBankBool;
import scripts.fc.framework.quest.InvBankBool.TYPE;
import scripts.fc.framework.quest.Order;
import scripts.fc.framework.quest.QuestBool;
import scripts.fc.framework.quest.QuestJournalBool;
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
			new QuestJournalBool(FCPrinceAliRescue.QUEST_NAME, "Talk to Leela near Draynor Village for advice.", false, true)
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
