package src.GUI;
import java.awt.event.*;  
import java.util.concurrent.*;
import src.GUI.*;

public class CareerListener implements ActionListener { 

    public CareerListener() {

    }

    public void actionPerformed(ActionEvent e) {    
        PopUpper popup = new PopUpper();
        System.out.println(((CareerMenuItem)e.getSource()).filename);
        popup.display(((CareerMenuItem)e.getSource()).filename);
        
    }     
}