package scripts.fc.missions.fc_prince_ali_rescue;

import java.util.Arrays;
import java.util.LinkedList;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.data.Vars;
import scripts.fc.framework.quest.QuestScriptManager;
import scripts.fc.framework.requirement.Requirement;
import scripts.fc.framework.script.FCMissionScript;
import scripts.fc.framework.task.Task;
import scripts.fc.framework.threads.FCFoodThread;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARTasks;

public class FCPrinceAliRescue extends QuestScriptManager
{
	public static final String QUEST_NAME = "Prince Ali Rescue";
	public static final int SETTING = 273;
	private final FCFoodThread FOOD_THREAD;
	
	public FCPrinceAliRescue(FCMissionScript fcScript)
	{
		super(fcScript);
		FOOD_THREAD = new FCFoodThread(50, 70, new FCItem(1, false, PARReqs.TROUT));
		FOOD_THREAD.start();
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
		return new Requirement[]{new PARReqs(missionScript)};
	}

	@Override
	public LinkedList<Task> getTaskList()
	{
		PARTasks tasks = new PARTasks();
		Vars.get().add("tasks", tasks);
		return new LinkedList<>(Arrays.asList(tasks.getTasks()));
	}
	
	public String toString()
	{
		return QUEST_NAME;
	}

	@Override
	public int getQuestPointReward() {
		return 3;
	}

}
