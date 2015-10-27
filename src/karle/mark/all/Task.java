package karle.mark.all;
import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;
public abstract class Task extends ClientAccessor {
	private static boolean active = true;
	public Task(ClientContext ctx) {
		super(ctx);
		
	}
	public abstract boolean activate();
	public abstract void execute();
	public boolean isActive(){
		return active;
	}
	public static void deactivate(){
		active = false;
	}
	public static void setActive(){
		active = true;
	}
}
