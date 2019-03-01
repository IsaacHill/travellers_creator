package MyClasses;
import java.util.*;


public class Traveller {
       
    private HashMap<String, Integer> skills;
    private String name;
    private int strength;
    private int dexterity;
    private int endurance;
    private int intellect;
    private int education;
    private int social;
    private int psi;
    private int credits;
    private ArrayList<String> gear;



    private Traveller(TravellerBuilder builder) {
        this.name = builder.name;
        this.skills = builder.skills;
    }

    public String getName() {
        return this.name;
    }

    /*
    *   returns the bonus of the given skill
    */
    public int getSkill(String skill) {
        if(skills.containsKey(skill)) {
            return skills.get(skill);
        } else if(skills.containsKey("Jack-of-All-Trades")) {
            return Math.min(skills.get("Jack-of-All-Trades"), 3) - 3;
        } else {
            return -3;
        }
    }

    public static class TravellerBuilder {
        public HashMap<String, Integer> skills;
        public String name;
        public int strength;
        public int dexterity;
        public int endurance;
        public int intellect;
        public int education;
        public int social;
        public int psi;
        public int credits;
        public ArrayList<String> gear;

        public TravellerBuilder(String name){
            this.name = name;
            this.skills = new HashMap<String, Integer>();
            this.gear = new ArrayList<String>();
        }
        
        /*
        *  Sets a given skill to a given level if not higher
        */
        public void addSkill(String skillName, int level) {
            if(skills.containsKey(skillName)) {
                if(skills.get(skillName) < level) {
                    skills.replace(skillName, level);
                }
            } else {
                skills.put(skillName, level);
            }
        }

        /*
        *  Increaces a given know skill or sets an unknown skill to 1
        */
        public void addSkill(String skillName) {
            if(skills.containsKey(skillName)) {
                skills.replace(skillName, skills.get(skillName) + 1);
            } else {
                skills.put(skillName, 1);
            }
        }

        /*
        *  Adds a piece of gear to your inventory
        */
        public void addGear(String item) {

        }
        /*
        *  Adds or subtracts inventory
        */
        public void addCredits(int credits) {

        }

        public Traveller build() {
            return new Traveller(this);
        }

        public String getName() {
            return this.name;
        }


 
    }

}