package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.quest.BankBool;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.HassanDialogue;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.OsmanDialogue;

public class TurnInQuest extends HassanDialogue implements ItemsRequiredTask
{
	private static final long serialVersionUID = -2391460475356758836L;

	@Override
	public boolean execute()
	{
		if(RescuePrince.inCell())
			return new ClickObject("Open", "Prison Door", 10).execute()
					&& FCTiming.waitCondition(() -> !RescuePrince.inCell(), 3500);
		
		return super.execute();
	}
	
	@Override
	public boolean shouldExecute()
	{
		return PARSettings.TURN_IN_QUEST.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Turn in quest";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		if(!OsmanDialogue.isEastOfGate() && BankBool.bankObserver.containsItem(995, 10))
			return new FCItem[]{new FCItem(10, true, false, 995)};
		
		return new FCItem[]{};
	}

}
