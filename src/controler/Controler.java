package src.controler;
import src.GUI.*;
import src.character.*;
import java.util.*;

public class Controler {
    Traveller.TravellerBuilder character;
    FakeGui gui;

    public Controler() {
        character = new Traveller.TravellerBuilder("Jacob");
        gui = new FakeGui();
    }

    // this will eventually turn into main loop
    public void run() {
        List<Integer> stats;
        while(true) {
            stats = gui.requestStats("Request 1");
            System.out.println(stats.toString());
        }
    }

}