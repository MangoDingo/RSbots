package karle.mark.fighter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import karle.mark.all.Task;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

@Script.Manifest(name="fighter", description= "fights minotaurs and takes their bones")
public class Fighter extends PollingScript<ClientContext>{	
	protected static int tunaID = 361;
	protected static int minotaurID = 2481;
	protected static int boneID = 526;
	
	private List<Task> taskList = new ArrayList<Task>();
@Override
public void start(){
	taskList.addAll(Arrays.asList(new Attack(ctx)));
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
