package scripts.fc.missions.fc_prince_ali_rescue.tasks;

import java.util.Arrays;

import org.tribot.api.Clicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Combat;
import org.tribot.api2007.Game;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.Walking;
import org.tribot.api2007.WorldHopper;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObjectDefinition;
import org.tribot.api2007.types.RSTile;

import scripts.fc.api.generic.FCConditions;
import scripts.fc.api.interaction.impl.objects.ClickObject;
import scripts.fc.api.travel.Travel;
import scripts.fc.api.worldhopping.FCInGameHopper;
import scripts.fc.api.wrappers.FCTiming;
import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.GetKeyPrint;
import scripts.webwalker_logic.shared.helpers.BankHelper;

public abstract class JailTask extends Task
{
	private static final long serialVersionUID = -4895093643892694459L;
	
	private static final Positionable DOOR_TILE = new RSTile(3128, 3246, 0);
	private static final int RADIUS = 10;
	private static final int HP_RATIO = General.random(30, 50);
	
	public boolean execute()
	{
		if(Combat.getHPRatio() < HP_RATIO && Inventory.getCount("Trout") > 0)
			return
			eat();
		if(Player.getPosition().distanceTo(DOOR_TILE) > RADIUS || !isInBuilding())
		{
			if(Travel.webWalkTo(DOOR_TILE) && Timing.waitCondition(FCConditions.positionEquals(DOOR_TILE), 1800))
				return true;
			else
				return Walking.walkScreenPath(Walking.generateStraightScreenPath(DOOR_TILE)) 
						&& Timing.waitCondition(FCConditions.withinDistanceOfTile(DOOR_TILE, 3), 4000);
		}
		else if(Player.getRSPlayer().getCombatLevel() < GetKeyPrint.COMBAT_THRESH && isDoorOpen())
			return closeDoor() && FCTiming.waitCondition(() -> !Combat.isUnderAttack(), 5000);
		else if(Combat.isUnderAttack()) //under attack in jail
		{
			General.println("Escaping to bank and then hopping...");
			if(Travel.walkToBank())
			{
				while(!hop())
					General.sleep(5000);
			}
		}
		else
			return handle();
		
		return false;
	}
	

	protected boolean hop()
	{
		General.println("Attempting to hop worlds...");
		return FCInGameHopper.hop(WorldHopper.getRandomWorld(WorldHopper.isMembers(WorldHopper.getWorld())));
	}
	
	private boolean eat()
	{
		General.println("Eating...");
		RSItem[] trout = Inventory.find("Trout");
		int invCount = Inventory.getAll().length;
		if(trout.length > 0 && Clicking.click(trout[0]))
			return Timing.waitCondition(FCConditions.inventoryChanged(invCount), 1200);
		
		return false;
	}
	
	private boolean closeDoor()
	{
		General.println("Attempting to close door...");
		return new ClickObject("Close", "Door", 5).execute() && FCTiming.waitCondition(() -> !isDoorOpen(), 1200);
	}
	
	private boolean isDoorOpen()
	{
		return Arrays.stream(Objects.find(5, "Door")).anyMatch(d -> 
		{
			RSObjectDefinition def = d.getDefinition();
			String[] actions = def == null ? null : def.getActions();
			if(actions == null)
				return false;
			
			return Arrays.stream(actions).anyMatch(a -> a.equals("Close"));
		});
	}
	
	private boolean isInBuilding()
	{
		RSTile localTile = Player.getPosition().toLocalTile();
		return BankHelper.isInBuilding(localTile, Game.getSceneFlags());
	}
	
	protected abstract boolean handle();
}
