package karle.mark.essence;

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

@Script.Manifest(name="miner", description= "mines rune essence")
public class EssenceMiner extends PollingScript<ClientContext>{	
	private List<Task> taskList = new ArrayList<Task>();
@Override
public void start(){
	BankRunner bank = new BankRunner(ctx, "Varrock");
	//taskList.addAll(Arrays.asList(new Miner(ctx), bank, new BankOpener(ctx, bank.getBankArea()), new Deposit(ctx), new EssenceRunner(ctx)));
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
