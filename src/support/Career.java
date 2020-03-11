package src.support;
import java.util.*;
import src.support.*;
import src.character.*;



// see page 5 for rolling details
public interface Career {

    public List<String> validTables = null;

    /*
    *   Make a roll and see if the given character passes qualification
    */
    public Result rollForQualification(Traveller.TravellerBuilder character);

    /*
    *   Go through the character creation process automatically, altering the Traveller object as you go.
    *   Return a result where the string is what happened and the value indicates if the player gets a
    *   skill from advancement
    */
    public Result rollForSurvivalEventAdvance(Traveller.TravellerBuilder character, String Table);

}