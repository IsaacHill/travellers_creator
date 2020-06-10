package src.support.careers;
import java.util.*;
import src.support.*;
import src.character.*;
import src.GUI.*;
import src.support.careers.*;

public class Agent extends Career {

    public Agent() {
        name = "Agent";
    }

    String specialty;
    String[] personalDevelopment = {"Gun Combat", "Dex +1", "END +1", "Melee", "INT +1", "Athletics"};
    String[] serviceSkills = {"Streewise", "Drive", "Investigate", "Flyer", "Recon", "Gun Combat"};
    String[] corperate = {"Investigate", "Electronics(Computers)", "Stealth", "Carouse", "Deception", "Streetwise"};

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
        // DEBUG REMOVE FOR DEPLOYMENT
        character.bonuses.add(new UniBonus());
        if (character.history.contains(new Agent())) {
            System.out.println("inval");
            return new Result(2, "You can't go back to old careers");
        }
        int externalBonus = character.getExternalBonus("Qualification", "Agent");
        System.out.println("Bonus: %d" + Integer.toString(externalBonus));
        int roll = Dice.roll2D() + character.getStatMod("intellect") - character.getNumCareers() + externalBonus;
        if (roll >= 6) {
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
    public Result rollForSurvivalEventAdvance(Traveller.TravellerBuilder character, GUI gui){
        // do basic training
        System.out.println(character.history.toString());
        if(character.history.size() == 0 ) {
            System.out.println("full basic");
            for(int i = 0; i < serviceSkills.length; i++) {
                character.addSkill(serviceSkills[i], 0);
            }
        } else if (character.history.get(character.history.size() - 1) != this) {
            System.out.println("half basic");
            character.addSkill(getSkillChoice(serviceSkills, gui), 0);
        }

        // Ask for table
        String[] table = this.getSkillTable(this.getValidTables(character), gui);
        System.out.println(table[0]);
        character.addSkill(table[Dice.roll1D()-1]);
        // TODO: roll Survival based on specialty
        // TODO: roll for advancvement based on specialty
        return null;
    }

    // Asks the user for a table and returns the correct list of skills in that table
    private String[] getSkillTable(List<String> list, GUI gui) {

        ArrayList<String> choices = new ArrayList<String>(list);
        String tableChoice = gui.getTableChoice(choices);
        System.out.println("0");
        switch(tableChoice){
            case "Service Skills" :
                System.out.println("1");
                return serviceSkills;
            case "Corperate" :
                System.out.println("2");
                return corperate;
            case "Personal Development" :
                System.out.println("3");
                return corperate;
            default:
                return null;
        }

    }

    // Asks the user to choose a specific skill from a given table
    private String getSkillChoice(String[]list, GUI gui) {
        List<String> choices = Arrays.asList(list);
        return gui.getTableChoice(choices);
    }


    /*
    *   Loop through terms untill you leave the career
    */
    public Result enterCareer(Traveller.TravellerBuilder character, GUI gui) {
        boolean leaving = false;
        // TODO: Choose Specialty
        character.history.add(this);
        while(leaving == false){
            // roll survival, event, advancement, if pass all ask for extra table
            this.rollForSurvivalEventAdvance(character, gui);
            
            System.out.println(character.skills.toString());
        }
        
        return null;
    }
    


    private class AgentEvent4Bonus implements Bonus {
        public int checkBonus(String rollType, String subtype, Traveller.TravellerBuilder character) {
            System.out.println("AgentEvent4Bonus");
            if(rollType == "Benefit" ) {
                return 1;
            }
            return 0;
        }
    }

    private class UniBonus implements Bonus {
        public int checkBonus(String rollType, String subtype, Traveller.TravellerBuilder character) {
            System.out.println("UniBonus");
            if(rollType == "Qualification" && subtype == "Agent") {
                return 4;
            }
            return 0;
        }
    }
}