package karle.mark.all;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

public class Deposit extends Task{

	public Deposit(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28 && ctx.bank.opened();
	}

	@Override
	public void execute() {
		ctx.bank.depositInventory();
		Condition.sleep(2000);
	}

}
