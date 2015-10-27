package karle.mark.flax;

import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class FlaxPicker extends Task{

	public FlaxPicker(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() != 28
				&& !ctx.objects.select().id(Flax.groundFlaxID).isEmpty();
	}

	@Override
	public void execute() {
		System.out.println("FlaxPicker");
		GameObject flax = ctx.objects.nearest().poll();
		if(flax.inViewport()){
			flax.interact("Pick");
			Condition.sleep(600);
		}
		else{
			ctx.movement.step(flax);
			ctx.camera.turnTo(flax);
			Condition.sleep(2000);
		}
	}

}
