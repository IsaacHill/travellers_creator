package src.GUI;
import javax.swing.*;
public class CareerMenuItem extends JMenuItem {
    String filename;

    CareerMenuItem(String name, String filename) {
        super(name);
        this.filename = filename;
    }

}