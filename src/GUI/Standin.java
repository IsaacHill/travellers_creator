package src.GUI;
import java.util.*;
import java.io.*;


public class Standin {

    public Standin() {

    }


    public String queryPlayerMC(String message, ArrayList<String> options) {
        System.out.println(message);
        for(int i = 0; i < options.size(); i++) {
            System.out.println(Integer.toString(i) + ": " + options.get(i));
        }
        int choice = -1;
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextInt());
        choice = sc.nextInt();
        return options.get(choice);
    }
}