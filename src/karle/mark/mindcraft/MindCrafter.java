package karle.mark.mindcraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import karle.mark.all.BankOpener;
import karle.mark.all.Deposit;
import karle.mark.all.Task;
import karle.mark.flax.BowstringRunner;
import karle.mark.flax.Bowstringer;
import karle.mark.flax.FlaxPicker;

import org.powerbot.script.Area;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

@Script.Manifest(name="mindcrafter", description= "picks flax and makes bowstrings")
public class MindCrafter extends PollingScript<ClientContext>{
	
	protected List<Task> taskList = new ArrayList<Task>();
	@Override
	public void start(){
		taskList.addAll(Arrays.asList(new MindAltarOpener(ctx), new MindAltarCraft(ctx), new BankOpener(ctx), new Deposit(ctx)));
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
