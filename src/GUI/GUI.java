package src.GUI;
import javax.swing.*; 
import java.util.*; 
import java.util.concurrent.*;
import src.GUI.*;
import java.awt.event.*;  
import src.character.*;
import java.awt.FlowLayout; 
import javax.swing.table.DefaultTableModel; 
public class GUI {
    JFrame mainFrame = new JFrame();//creating instance of JFrame
    ArrayBlockingQueue<String> choiceGuiQueue;
    JTable charNameTable;
    JTable charStatsTable;
    JTable charSkillsTable;

    public GUI() {
        choiceGuiQueue = new ArrayBlockingQueue<String>(10);
    }

    /* opens the main window for the user interface and sets up initial elelments*/
    public void openWindow() {      
        mainFrame.setSize(1000,800);
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        setupEncyclopedia(mainFrame);
        initCharSheet(mainFrame);
        //updateCharSheet(new Traveller.TravellerBuilder("Dan"));
        //f.setLayout(null);//using no layout managers  
        mainFrame.setVisible(true);//making the frame visible  
    }

    /* sets up the dropdown for the career details menu. needs a png file for each carrer with their career page on it*/
    public void setupEncyclopedia(JFrame f) {
        JMenuBar mb = new JMenuBar();  
        JMenu menu = new JMenu("Careers"); 
        CareerMenuItem item; 
        // This list will need to be populated with the names of the PNG career sheet files
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

    /* sets up the initial space to display character information */
    public void initCharSheet(JFrame f) {

        DefaultTableModel model;
        System.out.println("starting table");
        String basicInfo[][]={ {"Name:", "","Age:", "", "Species:", ""} };    
        String column6[] = {"", "", "", "", "", ""};          
        charNameTable = new JTable(new DefaultTableModel(basicInfo,column6)); 
        charNameTable.setTableHeader(null);   
        charNameTable.setBounds(30,40,200,210);  
        JScrollPane charNamePane = new JScrollPane(charNameTable); 
        f.add(charNamePane); 

        String stats[][]={ {"Str:", "","Dex:","", },
                          {"Int:", "", "Edu:", "" }, 
                          {"End:", "", "Soc:", "" } };    
        String column4[] = {"","","",""};         
        charStatsTable = new JTable(new DefaultTableModel(stats,column4)); 
        charStatsTable.setTableHeader(null);   
        charStatsTable.setBounds(30,40,200,210);   
        JScrollPane charStatPane = new JScrollPane(charStatsTable); 
        f.add(charStatPane);     
        
        String skills[][]={ };      
        String column2[] = {"",""};
        charSkillsTable = new JTable(new DefaultTableModel(skills,column2)); 
        charSkillsTable.setTableHeader(null);   
        charSkillsTable.setBounds(30,40,200,210);   
        JScrollPane charSkillsPane = new JScrollPane(charSkillsTable); 
        f.add(charSkillsPane); 
    }

    /* updates the caracter information diusplayed to match the traveller that it is given */
    public void updateCharSheet(Traveller.TravellerBuilder details) {
        charNameTable.getModel().setValueAt(details.name, 0, 1);
        charNameTable.getModel().setValueAt(details.age, 0, 3);

        charStatsTable.getModel().setValueAt(details.strength, 0, 1);
        charStatsTable.getModel().setValueAt(details.dexterity, 0, 3);
        charStatsTable.getModel().setValueAt(details.intellect, 1, 1);
        charStatsTable.getModel().setValueAt(details.education, 1, 3);
        charStatsTable.getModel().setValueAt(details.endurance, 2, 1);
        charStatsTable.getModel().setValueAt(details.social, 2, 3);
    }

    // This probally won't work on reflection
    /* Opens up a popup with buttons for each given option that when clicked will return the option picked*/
    public String queryPlayerMC(String message, ArrayList<String> options) {
        System.out.println(message);
        String result;
        JFrame f=new JFrame();
        JButton b;
        ButtonListener listener;
        // add all the action listeners
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
            // blocks the thread until there is an ellement put into the queue from the action listener
            result = choiceGuiQueue.take();
        } catch (Exception e) {
            result = "";
        }
        f.setVisible(false);
        return result;
    }
}