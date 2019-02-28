import java.util.*;


public class traveller {
       
    private HashMap<String, int> skills;
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



    private traveller(travellerBuilder builder) {

    }

    /*
    *   returns the bonus of the given skill
    */
    public int getSkill(String skill) {
        if(skills.containsKey(skill)) {
            return skills.get(skill)
        } else if(skills.containsKey("Jack-of-All-Trades") {
            return skills.get("Jack-of-All-Trades") - 3;
        } else {
            return -3;
        }
    }

    public static class travellerBuilder {

        public travellerBuilder(String name){
            this.name = name;
            skills = new HashMap<String, int>();
            gear = new ArrayList<String>();
        }
        
        /*
        *  Sets a given skill to a given level if not higher
        */
        public void addSkill(String skillName, int level) {
            if(skills.containsKey(skillName)) {
                if(skills.get(skillName) < level) {
                    replace(skillName, level);
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
                replace(skillName, skills.get(skillName) + 1);
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

        public traveller build() {
            return new traveller(this);
        }
 
    }

}