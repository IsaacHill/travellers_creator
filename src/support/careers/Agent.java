package src.support.careers;
import java.util.*;
import src.support.*;
import src.character.*;

public class Agent extends Career {

    public Agent() {
        name = "Agent";
    }

    public List<String> getValidTables(Traveller.TravellerBuilder character) {
        if (character.education >= 8) {
            return new ArrayList<String>(Arrays.asList("Personal Development",
                    "Service Skills", "Advanced Education", "Law Enforcement", "Intelligence", "Corperate"));
        }
        return new ArrayList<String>(Arrays.asList("Personal Development",
                "Service Skills", "Law Enforcement", "Intelligence", "Corperate"));

    }

    /*
    *   Make a roll and see if the given character passes qualification
    */
    public Result rollForQualification(Traveller.TravellerBuilder character) {
        int roll = Dice.roll2D() + character.getStatMod("intellect") - character.getNumCareers();
        if (character.history.contains(new Agent())) {
            System.out.println("inval");
            return new Result(2, "You can't go back to old careers" + Integer.toString(roll));
        }
        if (roll > 6) {
            System.out.println("pass");
            return new Result(1, "Passed with " + Integer.toString(roll));
        } else {
            System.out.println("fail");
            return new Result(0, "Failed with" + Integer.toString(roll));
        }
    }

    /*
    *   Go through the character creation process automatically, altering the Traveller object as you go.
    *   Return a result where the string is what happened and the value indicates if the player gets a
    *   skill from advancement
    */
    public Result rollForSurvivalEventAdvance(Traveller.TravellerBuilder character, String Table){
        return null;
    }
}