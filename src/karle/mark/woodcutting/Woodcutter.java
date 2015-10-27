package karle.mark.woodcutting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import karle.mark.all.BankOpener;
import karle.mark.all.BankRunner;
import karle.mark.all.Deposit;
import karle.mark.all.Task;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
@Script.Manifest(name="chopper", description= "cuts trees and drops them")
public class Woodcutter extends PollingScript<ClientContext>{
	private List<Task> taskList = new ArrayList<Task>();
	@Override
	public void start(){
		BankRunner bank = new BankRunner(ctx, "Draynor");
	//	taskList.addAll(Arrays.asList(new Chop(ctx), bank, new BankOpener(ctx, bank.getBankArea()), new Deposit(ctx)));
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
