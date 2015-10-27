package karle.mark.flax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import karle.mark.all.BankOpener;
import karle.mark.all.Deposit;
import karle.mark.all.Task;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

@Script.Manifest(name="flax", description= "picks flax and makes bowstrings")
public class Flax extends PollingScript<ClientContext>{
	public static int groundFlaxID = 7134;
	public static int flaxID = 1779;
	public static int bowstringLadderUpID = 25938;
	public static int bowstringLadderDownID = 25939;
	public static int bowstringDoorOpenID = 25820;
	public static int bowstringDoorClosedId = 25819;
	public static int spinningWheelID = 25824;
	public static int bowstringID = 1777;
	public static Area bowstringArea = new Area(new Tile(2713,3472), new Tile(2716, 3471));
	public static Area flaxArea = new Area(new Tile(2737, 3449), new Tile(2748, 3438));
	
	protected List<Task> taskList = new ArrayList<Task>();
	@Override
	public void start(){
		taskList.addAll(Arrays.asList(new FlaxPicker(ctx), new BankOpener(ctx), new Deposit(ctx), new BowstringRunner(ctx), new Bowstringer(ctx)));
	}
	@Override
	public void poll() {
		for (Task task : taskList){
			if (task.activate()){
				task.execute();
			}
		}
	}
}
