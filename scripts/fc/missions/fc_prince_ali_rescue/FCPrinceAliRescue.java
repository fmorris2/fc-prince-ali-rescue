package scripts.fc.missions.fc_prince_ali_rescue;

import java.util.Arrays;
import java.util.LinkedList;

import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;

public class FCPrinceAliRescue extends QuestScriptManager
{

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
		return false;
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
		return new LinkedList<>(Arrays.asList());
	}
	
	public String toString()
	{
		return "Prince Ali Rescue";
	}

}
