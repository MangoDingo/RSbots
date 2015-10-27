package karle.mark.fighter;

import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

public class BoneDigger extends Task {

	public BoneDigger(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28 
				&&!ctx.inventory.id(Fighter.boneID).isEmpty()
				&& !ctx.players.local().inCombat();
	}

	@Override
	public void execute() {
		System.out.println("BoneDigger");
		while (!ctx.inventory.select().id(Fighter.boneID).isEmpty()){
			Item bone = ctx.inventory.id(Fighter.boneID).poll();
			bone.interact("Bury");
			Condition.sleep(3000);
		}
	}
}
