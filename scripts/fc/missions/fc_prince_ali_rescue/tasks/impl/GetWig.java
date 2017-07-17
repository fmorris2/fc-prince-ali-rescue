package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;

public class GetWig extends Task implements ItemsRequiredTask
{
	private static final long serialVersionUID = -2388030595176955841L;
	private static final Positionable TILE = new RSTile(3099, 3258, 0);
	private static final int RADIUS = 6;

	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(TILE) > RADIUS)
			return Travel.webWalkTo(TILE, FCConditions.withinDistanceOfTile(TILE, RADIUS));
		
		NpcDialogue dialogue = new NpcDialogue("Talk-to", "Ned", 10, 0,1,0);
		dialogue.setCheckPath(true);
		
		if(dialogue.execute())
		{
			PARSettings.GET_WIG.resetJournalCaches();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.GET_WIG.isValid();
	}

	@Override
	public String getStatus()
	{
		return "Get wig";
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(3, false, PARReqs.WOOL)
		};
	}
	
	

}
