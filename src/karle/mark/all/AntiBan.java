package karle.mark.all;


import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;



public class AntiBan extends Task {

    public AntiBan(ClientContext ctx) {
        super(ctx);
    }
    private final int FREQUENCY = 90;
    private int freqRNG = FREQUENCY;

    @Override
    public boolean activate() {
        long runtime = ctx.controller.script().getRuntime()/1000 ;
        return runtime%(freqRNG) == 0 &&
                ctx.inventory.select().count() != 28;
    }

    @Override
    @SuppressWarnings( "deprecation" )
    public void execute() {
        Random rng = new Random();
        freqRNG = rng.nextInt((int)(0.7*FREQUENCY), (int)(1.3*FREQUENCY));
        System.out.println("Conducting Anti-Ban");
        int antiban = rng.nextInt(1,6);
        switch (antiban) {
            case 1: ctx.keyboard.send("{VK_LEFT down}");
                    Condition.sleep(rng.nextInt(200, 800));
                    ctx.keyboard.send("{VK_LEFT up}");
                break;
            case 2: ctx.keyboard.send("{VK_RIGHT down}");
                    Condition.sleep(rng.nextInt(200, 800));
                    ctx.keyboard.send("{VK_RIGHT up}");
                    Condition.sleep(rng.nextInt(110,655));
            case 3: ctx.keyboard.send("{VK_LEFT down}");
                    Condition.sleep(rng.nextInt(150, 550));
                    ctx.keyboard.send("{VK_LEFT up}");
                    Condition.sleep(rng.nextInt(566,1555));
            case 4: ctx.keyboard.send("{VK_RIGHT down}");
                    Condition.sleep(rng.nextInt(111, 777));
                    ctx.keyboard.send("{VK_RIGHT up}");
                break;
            case 5: ctx.keyboard.send("{VK_UP down}");
                    Condition.sleep(rng.nextInt(111, 432));
                    ctx.keyboard.send("{VK_UP up}");
                break;
        }
    }
}