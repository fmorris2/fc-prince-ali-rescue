package scripts.fc.missions.fc_prince_ali_rescue.tasks;

import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.travel.Travel;
import scripts.fc.framework.task.Task;

public abstract class OsmanDialogue extends Task
{
	private static final long serialVersionUID = 3914100896565542142L;
	private static final Positionable TILE = new RSTile(3286, 3181, 0);
	private static final int RADIUS = 5;
	
	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(TILE) > RADIUS)
			return Travel.webWalkTo(TILE, FCConditions.withinDistanceOfTile(TILE, RADIUS));
		
		NpcDialogue dialogue = new NpcDialogue("Talk-to", "Osman", 10, 0,1,2);
		return new NpcDialogue("Talk-to", "Osman", 10, 0,1,2).execute() || dialogue.wentThroughDialogue();
	}

}
