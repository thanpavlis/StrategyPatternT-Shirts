package assignment3strategy;

import assignment3strategy.variations.Color;
import assignment3strategy.variations.Fabric;
import assignment3strategy.variations.Size;
import assignment3strategy.variations.TShirt;
import java.util.Random;

public class RandTshirtGen {//dhmiourgei random TShirts, wste na zhtame oso to dynaton ligotera apo ton xrhsth kai einai singleton

    private static RandTshirtGen rtg;
    private Random rand;

    private RandTshirtGen() {//arxikopoihsh tou random antikeimenou
        rand = new Random();
    }

    public static RandTshirtGen getRandTshirtGen() {
        if (rtg == null) {//an einai null to dhmiourgei
            rtg = new RandTshirtGen();
        }
        return (rtg);
    }

    private Color getRandomColor() {//random xrwma
        return (Color.values()[rand.nextInt(Color.values().length)]);
    }

    private Size getRandomSize() {//random megethos
        return (Size.values()[rand.nextInt(Size.values().length)]);
    }

    private Fabric getRandomFabric() {//random yliko
        return (Fabric.values()[rand.nextInt(Fabric.values().length)]);
    }

    public TShirt getRandomTShirt() {//paragei ena tyxaio tshirt kai to epistrefei 
        return (new TShirt(getRandomColor(), getRandomSize(), getRandomFabric()));
    }

}
