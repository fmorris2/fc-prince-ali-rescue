package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import org.tribot.api.Timing;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.items.ItemOnItem;
import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;

public class DyeWig extends Task implements ItemsRequiredTask
{
	private static final long serialVersionUID = -5732258651562461413L;

	@Override
	public boolean execute()
	{
		return new ItemOnItem("Use", "Yellow dye", "Wig").execute() && Timing.waitCondition(FCConditions.inventoryNotContains("Yellow dye"), 1800);
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.DYE_WIG.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Dye wig";
	}
	
	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, PARReqs.WIG),
			new FCItem(1, false, PARReqs.DYE)
		};
	}
}
