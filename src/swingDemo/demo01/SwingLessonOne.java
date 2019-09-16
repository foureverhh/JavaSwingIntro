package swingDemo.demo01;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class SwingLessonOne extends JFrame{

    public static void main(String[] args) {
        new SwingLessonOne();
    }

    public SwingLessonOne(){
        this.setSize(400,400);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();
        int xPos = (dimension.width/2)-(this.getWidth()/2);
        int yPos = (dimension.height/2)-(this.getHeight()/2);
        this.setLocation(xPos,yPos);
        this.setLocationRelativeTo(null);

        this.setResizable(true);
        this.setVisible(true);
        //To close the frame by pressing x
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("My First Frame");
    }

}
