package src.support;
import java.util.Random;


// see page 5 for rolling details
public class Dice {


    public static int roll1D() {
       Random rand = new Random();
       return rand.nextInt(6) + 1;
    }

    public static int roll2D() {
       return Dice.roll1D() + Dice.roll1D();
    }


    public static int roll3D() {
      return Dice.roll1D() + Dice.roll1D() + Dice.roll1D();
   }
}