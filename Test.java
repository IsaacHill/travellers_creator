import tests.charTests;
import tests.guiTests;
import src.controler.*;

public class Test
{
     public static void main(String[] args) {
        System.out.println("Hello 2");
        //charTests.runCharTests();
        //guiTests.guiTest();
        Controler c = new Controler();
        while(true) {
            c.run();
        }
        
    }

}