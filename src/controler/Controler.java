package src.controler;
import src.GUI.*;
import src.character.*;
import java.util.*;
import src.support.*;


public class Controler {
    Traveller.TravellerBuilder character;
    FakeGui gui;
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
                    for(int i = 0; i < 6; i++) {
                        if(!statRolls.contains(stats.get(i))) {
                            statsCorrect = false;
                        }
                    }
                    if(statsCorrect == true) {
                        state = State.PRECAREER;
                        character.setStats(stats);
                        System.out.println(Integer.toString(character.getStatMod("strength")));
                    }
                    System.out.println("hello"  + stats.toString());
                    break;
                case PRECAREER:
                    // Optional: resolve anti-aging
                    // Ask the user for a career
                    // roll qualification for chosen career
                    // if fail ask for drift or draft
                    // ask them to pick a table
                    // roll survival, event, advancement, if pass all ask for extra table
                    // ask if they want another career
                    break;
                default:
            }

        }
    }

}