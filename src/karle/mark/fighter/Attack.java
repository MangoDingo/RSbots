package karle.mark.fighter;

import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class Attack extends Task {

	public Attack(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return !ctx.players.local().inCombat()
				&& !ctx.npcs.select().id(Fighter.minotaurID).nearest().poll().inCombat()
				&& ctx.npcs.nearest().poll().inViewport();
	}

	@Override
	public void execute() {
		System.out.println("Attack");
		Npc minotaur = ctx.npcs.nearest().poll();
		minotaur.interact("Attack");
		Condition.sleep(1000);
	}

}
