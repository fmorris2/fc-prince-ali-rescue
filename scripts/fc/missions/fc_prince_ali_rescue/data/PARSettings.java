package scripts.fc.missions.fc_prince_ali_rescue.data;

import java.util.Arrays;

import scripts.fc.framework.quest.QuestState;

public enum PARSettings
{
	;
	
	private QuestState[] states;
	
	PARSettings(QuestState... states)
	{
		this.states = states;
	}
	
	public boolean isValid()
	{
		return Arrays.stream(states).allMatch(s -> s.validate());
	}
}
