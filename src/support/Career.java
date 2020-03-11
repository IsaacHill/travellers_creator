package src.support;
import java.util.*;
import src.support.*;
import src.character.*;



// see page 5 for rolling details
public class Career {
    
    public String name;

    public Career() {
        name = "default";
    }

    public List<String> getValidTables(Traveller.TravellerBuilder character) {
        return null;
    }

    /*
    *   Make a roll and see if the given character passes qualification
    */
    public Result rollForQualification(Traveller.TravellerBuilder character) {
        return null;
    }

    /*
    *   Go through the character creation process automatically, altering the Traveller object as you go.
    *   Return a result where the string is what happened and the value indicates if the player gets a
    *   skill from advancement
    */
    public Result rollForSurvivalEventAdvance(Traveller.TravellerBuilder character, String table){
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
		    return false;
        return this.name.equals(((Career) obj).name);
    }

    public int hashCode(Object other) {
        return this.name.hashCode();
    }
}