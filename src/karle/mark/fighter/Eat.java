package karle.mark.fighter;

import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class Eat extends Task {

	public Eat(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return ctx.players.local().health() < 10 && ctx.inventory.select().count() != 0;
	}

	@Override
	public void execute() {
		ctx.inventory.select().first().poll().interact("Eat");
		Condition.sleep(5000);

	}

}
