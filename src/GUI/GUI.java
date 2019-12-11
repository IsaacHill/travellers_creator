package src.GUI;
import javax.swing.*; 
import java.util.*; 
import java.util.concurrent.*;
import src.GUI.*;
import java.awt.event.*;  
public class GUI {

    ArrayBlockingQueue<String> choiceGuiQueue;

    public GUI() {
        choiceGuiQueue = new ArrayBlockingQueue<String>(10);
    }


    public void openWindow() {
        JFrame f = new JFrame();//creating instance of JFrame       
        f.setSize(1000,800);
        setupEncyclopedia(f);
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
    }

    public void setupEncyclopedia(JFrame f) {
        JMenuBar mb = new JMenuBar();  
        JMenu menu = new JMenu("Careers"); 
        CareerMenuItem item; 
        String careers[] = {"Agent", "Army", "Navy", "Drifter"};
        CareerListener careerListener = new CareerListener();
        for(int i = 0; i < careers.length; i++) {
            item = new CareerMenuItem(careers[i], careers[i] + ".png");
            item.addActionListener(careerListener);  
            menu.add(item); 
        }
        mb.add(menu);
        f.setJMenuBar(mb);  
    }

    public String queryPlayerMC(String message, ArrayList<String> options) {
        System.out.println(message);
        String result;
        JFrame f=new JFrame();
        JButton b;
        ButtonListener listener;
        for(int i = 0; i < options.size(); i++) {
            listener = new ButtonListener(choiceGuiQueue, options.get(i));
            b = new JButton(options.get(i));
            b.setBounds(50+100*i, 50, 100, 40);
            b.addActionListener(listener);
            f.add(b);
        }
        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
        try {
            result = choiceGuiQueue.take();
        } catch (Exception e) {
            result = "";
        }
        f.setVisible(false);
        return result;
    }
}