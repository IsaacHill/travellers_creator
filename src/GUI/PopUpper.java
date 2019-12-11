package src.GUI;
import java.awt.*; 
import java.io.*;   
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JFrame;  
  
public class PopUpper extends Canvas{  
    private BufferedImage page;  
    JFrame f;

    public void paint(Graphics g) {   
        g.drawImage(page, 0,0,this);   
    }  

    public PopUpper() {  

    }  

    public void display(String image) { 
        Toolkit t=Toolkit.getDefaultToolkit(); 
        f=new JFrame();
        try {
            page = ImageIO.read(new File(image));
        } catch (Exception e) {

        }
        
        f.add(this);  
        f.setSize(page.getWidth(this), page.getHeight(this)); 
        f.setVisible(true);  
    }
  
}  