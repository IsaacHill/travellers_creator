package src.GUI;
import java.awt.event.*;  
import java.util.concurrent.*;

public class ButtonListener implements ActionListener { 
    
    ArrayBlockingQueue<String> guiQueue;  
    String id;  

    public ButtonListener(ArrayBlockingQueue<String> guiQueue, String id) {
        this.guiQueue = guiQueue;
        this.id = id;
    }

    public void actionPerformed(ActionEvent e) { 
        this.guiQueue.add(this.id);
    }
}