package karle.mark.all;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;


public class Drop extends Task{
	private int dropId;
	public Drop(ClientContext ctx, int dropId) {
		super(ctx);
		this.dropId = dropId;
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28;
	}

	@Override
	public void execute() {
		for (Item i : ctx.inventory.id(dropId)){
			i.interact("Drop");
		}
	}

}
