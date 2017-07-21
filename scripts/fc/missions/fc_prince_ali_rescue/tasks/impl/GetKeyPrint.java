package scripts.fc.missions.fc_prince_ali_rescue.tasks.impl;

import java.util.Arrays;

import org.tribot.api.General;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Combat;
import org.tribot.api2007.Options;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSCharacter;
import org.tribot.api2007.types.RSTile;
import org.tribot.api2007.util.DPathNavigator;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.npcs.dialogue.NpcDialogue;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.items.FCItem;
import scripts.fc.api.travel.Travel;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.ItemsRequiredTask;
import scripts.fc.framework.task.SpaceRequiredTask;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARReqs;
import scripts.fc.missions.fc_prince_ali_rescue.data.PARSettings;

public class GetKeyPrint extends Task implements ItemsRequiredTask, SpaceRequiredTask
{
	private static final long serialVersionUID = 5883609471833300426L;
	private static final Positionable TILE = new RSTile(3127, 3244, 0);
	private static final Positionable ESCAPE_TILE = new RSTile(3124, 3253, 0);
	private static final int RADIUS = 6;
	
	@Override
	public boolean execute()
	{
		if(Player.getPosition().distanceTo(TILE) > RADIUS)
			return Travel.webWalkTo(TILE, FCConditions.withinDistanceOfTile(TILE, RADIUS));
		
		if(Combat.isUnderAttack() || Player.getRSPlayer().isInCombat())
			return escapeCombat();
		
		NpcDialogue dialogue = new NpcDialogue("Talk-to", "Lady Keli", 10, 0,1,0,1,0,0);
		dialogue.setCheckPath(true);
		
		return dialogue.execute();
	}
	
	private boolean escapeCombat()
	{
		General.println("Escaping combat...");
		Options.setRunOn(true);
		DPathNavigator dPath = new DPathNavigator();
		dPath.setStoppingCondition(FCConditions.withinDistanceOfTile(ESCAPE_TILE, 2));
		if(dPath.traverse(ESCAPE_TILE))
		{
			General.println("Successfully walked to escape tile");
			if(!FCTiming.waitCondition(() -> Combat.getAttackingEntities().length > 0, 6000))
			{
				General.println("Successfully avoided combat");
				return true;
			}
			
			RSCharacter enemy = Arrays.stream(Combat.getAttackingEntities()).findFirst().orElse(null);
			if(enemy == null)
				return false;
			
			dPath.setStoppingCondition(FCConditions.IN_BUILDING_CONDITION);
			General.println("Waiting for enemy to get close & running back into building");
			if(FCTiming.waitCondition(() -> Player.getPosition().distanceTo(enemy) <= 2, 6000)
					&& dPath.traverse(TILE))
			{
				General.println("Closing door!");
				return new ClickObject("Close", "Door", 3).execute();	
			}
		}
		return false;	
	}

	@Override
	public boolean shouldExecute()
	{
		return PARSettings.GET_KEY_PRINT.isValid();
	}
	
	@Override
	public int getSpaceRequired()
	{
		return 27;
	}

	@Override
	public FCItem[] getRequiredItems()
	{
		return new FCItem[]
		{
			new FCItem(1, false, PARReqs.SOFT_CLAY)
		};
	}

	@Override
	public String getStatus()
	{
		return "Get key print";
	}

}
