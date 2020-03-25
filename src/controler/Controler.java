package src.controler;
import src.GUI.*;
import src.character.*;
import java.util.*;
import src.support.*;
import src.support.careers.*;


public class Controler {
    Traveller.TravellerBuilder character;
    GUI gui;
    enum State {START, STATS, PRECAREER, CAREER, FINISH}

    public Controler() {
        character = new Traveller.TravellerBuilder("Jacob");
        gui = new FakeGui();
    }

    // this will eventually turn into main loop
    public void run() {
        List<Integer> stats;
        List<Integer> statRolls = new ArrayList<Integer>();
        State state = State.START;
        Career careerChoice = null;
        while(true) {
            switch(state) {
                case START: 
                    state = State.STATS;
                    for(int i = 0; i < 6; i++) {
                        statRolls.add(Dice.roll2D());
                    }
                    break;
                case STATS:
                    stats = gui.requestStats(statRolls.toString());
                    boolean statsCorrect = true;
                    List tempRoll = new ArrayList<>(statRolls);
                    for(int i = 0; i < 6; i++) {
                        if(!tempRoll.contains(stats.get(i))) {
                            statsCorrect = false;
                            System.out.println("bad stat" + Integer.toString(stats.get(i)));
                        } else {
                            //System.out.println(statRolls.toString());
                            tempRoll.remove(tempRoll.indexOf(stats.get(i)));
                        }
                    }
                    if(statsCorrect == true) {
                        state = State.PRECAREER;
                        character.setStats(stats);
                        System.out.println("Stats chosen sucessfully");
                    }
                    break;
                case PRECAREER:
                    // Optional: resolve anti-aging
                    // Ask the user for a career
                    careerChoice = getCareerChoice(Arrays.asList(new Agent(), new Drifter(), new Draft()));
                    System.out.println(careerChoice.name);
                    // roll qualification for chosen career
                    Result qualificationResult = careerChoice.rollForQualification(character);
                    //System.out.println(.toString());
                    if(qualificationResult.value == 0) {
                        careerChoice = getCareerChoice(Arrays.asList(new Drifter(), new Draft()));
                    }
                    state = State.CAREER;
                    
                    
                case CAREER:
                    // resolve ageing
                    
                    // roll survival, event, advancement, if pass all ask for extra table
                    careerChoice.rollForSurvivalEventAdvance(character, gui);
                    System.out.println(character.skills.toString());
                    // ask if they want another career
                    break;
                default:
            }

        }
    }

    private Career getCareerChoice(List<Career> list) {
        ArrayList<String> choices = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++) {
            choices.add(list.get(i).name);
        }
        int careerChoiceInt = gui.getCareer(choices);
        return list.get(careerChoiceInt);

    }

}