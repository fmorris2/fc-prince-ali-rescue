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

public class GetPaste extends Task implements ItemsRequiredTask
{
	private static final long serialVersionUID = 8132711396112602301L;
	private static final Positionable TILE = new RSTile(3086, 3258, 0);
	private static final int RADIUS = 5;

	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(TILE) > RADIUS)
			return Travel.webWalkTo(TILE, FCConditions.withinDistanceOfTile(TILE, RADIUS));
		
		NpcDialogue dialogue = new NpcDialogue("Talk-to", "Aggie", 10, 0,0);
		dialogue.setCheckPath(true);
		
		return dialogue.execute();
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.GET_PASTE.isValid();
	}
	
	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, PARReqs.REDBERRIES),
			new FCItem(1, false, PARReqs.ASHES),
			new FCItem(1, false, PARReqs.POT_OF_FLOUR),
			new FCItem(1, false, PARReqs.BUCKET_OF_WATER)
		};
	}

	@Override
	public String getStatus()
	{
		return "Get paste";
	}

}
