package scripts.fc.missions.fc_prince_ali_rescue.tasks;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;

public abstract class LeelaDialogue extends Task
{
	private static final long serialVersionUID = 6183365549050290235L;
	private static final Positionable TILE = new RSTile(3112, 3261, 0);
	private static final int RADIUS = 10;

	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(TILE) > RADIUS)
			return Travel.webWalkTo(TILE, FCConditions.withinDistanceOfTile(TILE, RADIUS));
		
		if(new NpcDialogue("Talk-to", "Leela", 10, 0,1,2).execute())
		{
			PARSettings.LEELA_FIRST_DIALOGUE.resetJournalCaches();
			return true;
		}
		
		return false;
	}
}
