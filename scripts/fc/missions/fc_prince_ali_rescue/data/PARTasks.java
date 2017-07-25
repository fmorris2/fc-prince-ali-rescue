package scripts.fc.missions.fc_prince_ali_rescue.data;

import scripts.fc.framework.task.Task;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.DyeWig;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.GetKeyPrint;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.GetPaste;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.GetWig;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.JoeFirstBeer;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.JoeSecondBeer;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.LassoKeli;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.LeelaFirstDialogue;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.LeelaSecondDialogue;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.OsmanFirstDialogue;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.OsmanSecondDialogue;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.PickupKey;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.RescuePrince;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.StartQuest;
import scripts.fc.missions.fc_prince_ali_rescue.tasks.impl.TurnInQuest;

public class PARTasks
{
	public final StartQuest START_QUEST = new StartQuest();
	public final OsmanFirstDialogue OSMAN_FIRST_DIALOGUE = new OsmanFirstDialogue();
	public final LeelaFirstDialogue LEELA_FIRST_DIALOGUE = new LeelaFirstDialogue();
	public final GetWig GET_WIG = new GetWig();
	public final DyeWig DYE_WIG = new DyeWig();
	public final GetPaste GET_PASTE = new GetPaste();
	public final GetKeyPrint GET_KEY_PRINT = new GetKeyPrint();
	public final OsmanSecondDialogue OSMAN_SECOND_DIALOGUE = new OsmanSecondDialogue();
	public final PickupKey PICKUP_KEY = new PickupKey();
	public final LeelaSecondDialogue LEELA_SECOND_DIALOGUE = new LeelaSecondDialogue();
	public final JoeFirstBeer JOE_FIRST_BEER = new JoeFirstBeer();
	public final JoeSecondBeer JOE_SECOND_BEER = new JoeSecondBeer();
	public final LassoKeli LASSO_KELI = new LassoKeli();
	public final RescuePrince RESCUE_PRINCE = new RescuePrince();
	public final TurnInQuest TURN_IN_QUEST = new TurnInQuest();
	
	public Task[] getTasks()
	{
		return new Task[]
		{
			START_QUEST, OSMAN_FIRST_DIALOGUE, LEELA_FIRST_DIALOGUE, GET_WIG, DYE_WIG, GET_PASTE, GET_KEY_PRINT,
			OSMAN_SECOND_DIALOGUE, PICKUP_KEY, LEELA_SECOND_DIALOGUE, JOE_FIRST_BEER, JOE_SECOND_BEER, LASSO_KELI,
			RESCUE_PRINCE, TURN_IN_QUEST
		};
	}
}
