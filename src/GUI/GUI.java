package src.GUI;
import javax.swing.*; 
import java.util.*; 
import java.util.concurrent.*;
import src.GUI.*;
import java.awt.event.*;  
public class GUI {

    ArrayBlockingQueue<String> guiQueue;

    public GUI() {
        guiQueue = new ArrayBlockingQueue<String>(10);
    }


    public void openWindow() {
        JFrame f=new JFrame();//creating instance of JFrame  
                  
        JButton b = new JButton("click");//creating instance of JButton  
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
                  
        f.add(b);//adding button in JFrame  
                  
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
    }

    public String queryPlayerMC(String message, ArrayList<String> options) {
        System.out.println(message);
        String result;
        JFrame f=new JFrame();
        JButton b;
        ButtonListener listener;
        for(int i = 0; i < options.size(); i++) {
            listener = new ButtonListener(guiQueue, options.get(i));
            b = new JButton(options.get(i));
            b.setBounds(50+100*i, 50, 100, 40);
            b.addActionListener(listener);
            f.add(b);
        }
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 

        try {
            result = guiQueue.take();
        } catch (Exception e) {
            result = "";
        }
        f.setVisible(false);
        return result;
    }
}