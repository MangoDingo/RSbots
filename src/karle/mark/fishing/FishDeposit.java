package karle.mark.fishing;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;

import karle.mark.all.Task;

public class FishDeposit extends Task{
	public FishDeposit(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	private int rodID = 307;
	private int baitID = 313;
	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return ctx.inventory.select().count() == 28 && ctx.bank.opened();
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ctx.bank.depositInventory();
		Condition.sleep(1000);
		ctx.bank.withdraw(rodID, 1);
		Condition.sleep(1000);
		ctx.bank.withdraw(baitID, 1000);
		Condition.sleep(1000);
	}
	
}
