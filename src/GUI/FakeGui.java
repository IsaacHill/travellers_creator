package src.GUI;
import java.io.*;
import java.util.*;

public class FakeGui {
    
    public FakeGui() {

    }

    // a fake gui method that asks the user for 6 cs values
    public List<Integer> requestStats(String message) {
        List<Integer> result;
        List<String> items;
        Boolean done = false;
        result = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        System.out.println(message);

        while(done != true) {
            while(!sc.hasNextLine());
            String response = sc.nextLine();
            items = Arrays.asList(response.split("\\s*,\\s*"));
            result = new ArrayList<Integer>();
            try {
                for(int i = 0; i < 6; i++) {
                    result.add(Integer.parseInt(items.get(i)));
                }
                done = true;

            } 
            catch(Exception e) {
                System.out.println("Invalid");
            }
        }
        return result;

    }

    public int getCareer(List<String> choices) {
        System.out.println("What Career do you want?");
        for(int i = 0; i < choices.size(); i++) {
            System.out.println(Integer.toString(i) + ": " + choices.get(i));
        }
        Scanner sc = new Scanner(System.in);
        while(true) {
            while(!sc.hasNextInt());
            int response = sc.nextInt();
            if (response < choices.size()) {
                return response;
            }
            System.out.println("Invalid");
        }
    }

}