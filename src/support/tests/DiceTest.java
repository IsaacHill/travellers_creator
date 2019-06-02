package src.support.tests;
import src.support.*;

public class DiceTest
{
     public static void main(String[] args) {
        System.out.println("Hello from the matrix");
        D1Test();
    }

    public static void D1Test() {
        int rolled_value = Dice.roll1D();
        rolled_value = Dice.roll1D();
        assert rolled_value > 0 && rolled_value < 6;
        rolled_value = Dice.roll1D();
        assert rolled_value > 0 && rolled_value < 6;
        rolled_value = Dice.roll1D();
        assert rolled_value > 0 && rolled_value < 6;
        rolled_value = Dice.roll1D();
        assert rolled_value > 0 && rolled_value < 6;

    }
}
