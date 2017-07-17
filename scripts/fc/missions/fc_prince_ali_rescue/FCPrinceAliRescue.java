package scripts.fc.missions.fc_prince_ali_rescue;

import java.util.Arrays;
import java.util.LinkedList;

import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.GetWig;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.OsmanFirstDialogue;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.StartQuest;

public class FCPrinceAliRescue extends QuestScriptManager
{
	public static final String QUEST_NAME = "Prince Ali Rescue";
	public static final int SETTING = 273;
	
	public FCPrinceAliRescue(FCMissionScript fcScript)
	{
		super(fcScript);
	}

	@Override
	public boolean canStart()
	{
		return true;
	}

	@Override
	public boolean hasReachedEndingCondition()
	{
		return PARSettings.QUEST_COMPLETE.isValid();
	}

	@Override
	public String getMissionName()
	{
		return "FC Prince Ali Rescue";
	}

	@Override
	public String getEndingMessage()
	{
		return getMissionName() + " has ended.";
	}

	@Override
	public String[] getMissionSpecificPaint()
	{
		return new String[]{};
	}

	@Override
	public void resetStatistics()
	{
	}

	@Override
	public Requirement[] getRequirements()
	{
		return new Requirement[]{};
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		return new LinkedList<>(Arrays.asList(new StartQuest(), new OsmanFirstDialogue(), new GetWig()));
	}
	
	public String toString()
	{
		return QUEST_NAME;
	}

}
