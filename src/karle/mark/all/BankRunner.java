package karle.mark.all;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class BankRunner extends Task{
    public Area bank; 

	private int portals[] = {14916, 14918, 15638, 14914, 14913, 14917, 14915};
    private static int draynorCoords[] = {3092, 3096, 3241, 3245};
    private static int varrockCoords[] = {3250, 3254, 3422, 3420};
    private static int seersCoords[] = {2722,3490, 2727,3493};
    private int boundaryID = 1440;
    String city;
	public BankRunner(ClientContext ctx, String city) {
		super(ctx);
		/*this.city = city;
		if(city.equals("Varrock")){
			bank = new Area(new Tile(varrockCoords[0], varrockCoords[2]), new Tile(varrockCoords[1], varrockCoords[3]));
		}else if (city.equals("Draynor")){
			bank = new Area(new Tile(draynorCoords[0], draynorCoords[2]), new Tile(draynorCoords[1], draynorCoords[3]));
		}
		*/
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28 && !bank.contains(ctx.players.local()) && this.isActive();
	}

	@Override
	public void execute() {

		System.out.println("BankRunner");
		ctx.objects.select().id(boundaryID);
        if(ctx.objects.nearest().poll().inViewport()){
        	ctx.objects.select().id(portals);
    		GameObject portal = ctx.objects.nearest().poll();
    		if(portal.inViewport()){
    				portal.interact("Use");
    				Condition.sleep(1000);
    				portal.interact("Exit");
    		}else{
    			ctx.movement.step(portal);
    			ctx.camera.turnTo(portal);
    		}
    		Condition.sleep(5000);
        }
        else{Tile bankTile = null;
		if(city.equals("Varrock")){
			bankTile = new Tile(Random.nextInt(varrockCoords[0], varrockCoords[1]), Random.nextInt(varrockCoords[2], varrockCoords[3]));
		}else if (city.equals("Draynor")){
			bankTile = new Tile(Random.nextInt(draynorCoords[0], draynorCoords[1]), Random.nextInt(draynorCoords[2], draynorCoords[3]));
		}
        ctx.movement.step(bankTile);
        Condition.sleep(3000);
        }
	}
	public Area getBankArea(){
		return bank;
	}
}
