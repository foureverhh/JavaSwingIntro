package swingDemo.demo06_layout;

import com.sun.tools.javac.comp.Flow;

import javax.swing.*;
import java.awt.*;

public class SwingLesson06 extends JFrame {
    JButton button1,button2,button3,button4,button5;

    public static void main(String[] args) {
        new SwingLesson06();
    }

    private SwingLesson06(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Seventh Frame - Layout");
        //JPanel thePanel = new JPanel();

        /*FLOW LAYOUT*/
        //thePanel.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));

        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");

        /*
        //for flowLayOut
        thePanel.add(button1);
        thePanel.add(button2);
        thePanel.add(button3);
        thePanel.add(button4);
        thePanel.add(button5);
        */

        /*BORDER LAYOUT*/
        /*
        thePanel.setLayout(new BorderLayout());
        JPanel thePanel2 = new JPanel();
        thePanel2.add(button1);
        thePanel2.add(button2);
        thePanel.add(thePanel2,BorderLayout.NORTH);
        */
        /*
        thePanel.add(button1,BorderLayout.NORTH);
        thePanel.add(button2,BorderLayout.SOUTH);
        thePanel.add(button3,BorderLayout.EAST);
        thePanel.add(button4,BorderLayout.WEST);
        thePanel.add(button5,BorderLayout.CENTER);
        this.add(thePanel);
        */
        /*BOX LAYOUT*/
        Box theBox = Box.createHorizontalBox();
        theBox.add(button1);
        theBox.add(Box.createRigidArea(new Dimension(30,20)));
        theBox.add(button2);
        theBox.add(Box.createHorizontalStrut(5));
        theBox.add(button3);
        theBox.add(Box.createHorizontalGlue());
        //theBox.add(Box.createHorizontalStrut(5));
        theBox.add(button4);

        //theBox.add(button5);


        this.add(theBox);
        this.setVisible(true);
    }

}
