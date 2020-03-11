package src.support.careers;
import java.util.*;
import src.support.*;
import src.character.*;

public class Draft extends Career {

    public Career service;

    public Draft() {
        name = "Draft";
        // TODO roll for service
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
    /*
    *   Make a roll and see if the given character passes qualification
    */
    public Result rollForQualification(Traveller.TravellerBuilder character) {
        return new Result(1, "Always passes");
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