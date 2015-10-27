package karle.mark.all;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class BankOpener extends Task{
	private int boothID[] = {11744, 11748, 25808};
	public BankOpener(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28 //&&
				//bank.contains(ctx.players.local())
				&& !ctx.bank.opened() && isActive();
	}

	@Override
	public void execute() {
		System.out.println("BankOpener");
		GameObject booth = ctx.objects.select().id(boothID).nearest().poll();
		if(booth.inViewport()){
			booth.interact("Bank");
		}else{

            ctx.movement.step(booth);
            ctx.camera.turnTo(booth);
		}
		Condition.sleep(2000);
	}

}
