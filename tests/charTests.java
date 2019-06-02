package tests;
import src.GUI.*;
import src.character.*;
import java.util.*;


public class charTests
{

     public static void runCharTests() {
        System.out.println("Hello from the matrix");
        basicBuilderTest();
        basicSkillTest();
        jackSkillTest();
        overJackSkillTest();
        playerChoiceTest();
    }

    public static void basicBuilderTest() {
        Traveller.TravellerBuilder builder = new Traveller.TravellerBuilder("Luke Skywalker");
        Traveller luke = builder.build();
        assert luke.getName().equals("Luke Skywalker") : "bad name";
 
    }

    public static void basicSkillTest() {
        Traveller.TravellerBuilder builder = new Traveller.TravellerBuilder("Luke Skywalker");
        builder.addSkill("Gun Combat");
        builder.addSkill("Advocate", 0);
        builder.addSkill("Gun Combat");
        builder.addSkill("Pilot");
        builder.addSkill("Pilot", 0);
        Traveller luke = builder.build();
        assert luke.getSkill("Gun Combat") == 2 : "gun combat";
        assert luke.getSkill("Advocate") == 0 : "Advocate";
        assert luke.getSkill("Survival") == -3 : "Survival";
        assert luke.getSkill("Pilot") == 1 : "Pilot";
    }

    public static void jackSkillTest() {
        Traveller.TravellerBuilder builder = new Traveller.TravellerBuilder("Luke Skywalker");
        builder.addSkill("Jack-of-All-Trades");
        Traveller luke = builder.build();
        assert luke.getSkill("Jack-of-All-Trades") == 1 : "Jack-of-All-Trades";
        System.out.println(luke.getSkill("Survival"));
        assert luke.getSkill("Survival") == -2 : "Survival";
    }

    public static void overJackSkillTest() {
        Traveller.TravellerBuilder builder = new Traveller.TravellerBuilder("Luke Skywalker");
        builder.addSkill("Jack-of-All-Trades", 4);
        Traveller luke = builder.build();
        assert luke.getSkill("Jack-of-All-Trades") == 4 : "Jack-of-All-Trades";
        System.out.println(luke.getSkill("Survival"));
        assert luke.getSkill("Survival") == 0 : "Survival:" + luke.getSkill("Survival");
    }

    public static void playerChoiceTest() {
        Standin manager = new Standin();
        ArrayList<String> options = new ArrayList();
        options.add("One");
        options.add("Two");
        options.add("Three");
        System.out.println((manager.queryPlayerMC("pick something", options)));
    }
}