package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tribot.api2007.Inventory;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.JailTask;

public class RescuePrince extends JailTask implements ItemsRequiredTask
{
	private static final long serialVersionUID = 7136442358680624428L;

	@Override
	protected boolean handle()
	{
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.RESCUE_PRINCE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Rescue prince";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		List<FCItem> reqs = new ArrayList<>(Arrays.asList(
				new FCItem(1, false, PARReqs.BRONZE_KEY), new FCItem(1, false, PARReqs.PINK_SKIRT),
				new FCItem(1, false, PARReqs.PASTE), new FCItem(1, false, PARReqs.YELLOW_WIG)
		));
		
		if(Inventory.getCount("Trout") == 0)
			reqs.add(new FCItem(2, false, PARReqs.TROUT));
		
		return reqs.toArray(new FCItem[reqs.size()]);
	}

}
