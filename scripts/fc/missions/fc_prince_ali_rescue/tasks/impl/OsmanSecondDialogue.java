package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.tribot.api.General;

import scripts.fc.api.items.FCItem;
import scripts.fc.framework.quest.BankBool;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.OsmanDialogue;

public class OsmanSecondDialogue extends OsmanDialogue implements ItemsRequiredTask
{
	private static final long serialVersionUID = -8183670160907393611L;

	@Override
	public boolean execute()
	{
		if(super.execute())
		{
			General.println("Reset journal caches");
			PARSettings.GET_KEY_PRINT.resetJournalCaches();
			return true;
		}
		
		return false;
	}
	@Override
	public boolean shouldExecute()
	{
		return PARSettings.OSMAN_SECOND_DIALOGUE.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Osman second dialogue";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		int amt = isEastOfGate() ? 10 : 20;
		List<FCItem> gold = new ArrayList<>(Arrays.asList(new FCItem(amt, true, false, 995)));
		
		FCItem[] reqs = new FCItem[]
		{
			new FCItem(1, false, PARReqs.BRONZE_BAR),
			new FCItem(1, false, PARReqs.KEY_PRINT)
		};
		
		if(BankBool.bankObserver.containsItem(995, amt))
		{
			gold.addAll(Arrays.asList(reqs));
			return gold.toArray(new FCItem[gold.size()]);
		}
		
		return reqs;
	}

}
