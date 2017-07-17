package scripts.fc.missions.fc_prince_ali_rescue.tasks;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;

public abstract class HassanDialogue extends Task
{
	private static final long serialVersionUID = -4813570544883772376L;
	private static final Positionable TILE = new RSTile(3298, 3163, 0);
	private static final int RADIUS = 12;

	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(TILE) > RADIUS)
			return Travel.webWalkTo(TILE, FCConditions.withinDistanceOfTile(TILE, RADIUS));
		
		return new NpcDialogue("Talk-to", "Hassan", 10, 0).execute();
	}
}
