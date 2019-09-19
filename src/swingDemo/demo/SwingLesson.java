package swingDemo.demo;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

public class SwingLesson extends JFrame{

    public static void main(String[] args) {
        new SwingLesson();
    }

    public SwingLesson(){
        this.setSize(400,400);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimension = tk.getScreenSize();
        int xPos = (dimension.width/2)-(this.getWidth()/2);
        int yPos = (dimension.height/2)-(this.getHeight()/2);
        this.setLocation(xPos,yPos);
        //this.setLocationRelativeTo(null);

        this.setResizable(true);
        this.setVisible(true);
        //To close the frame by pressing x
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //To set title
        this.setTitle("My First Frame");
        //Set JPanel and JLabel
        JPanel thePanel = new JPanel();

        JLabel label1 = new JLabel("Tell me something");
        thePanel.add(label1);
        label1.setText("New Text");
        label1.setToolTipText("Doesn't do anything.");

        JButton button1 = new JButton("Send");
        //button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.setText("New button");
        button1.setToolTipText("This is a button.");
        thePanel.add(button1);

        //JTextField
        JTextField textField1 = new JTextField("Type here", 15);
        textField1.setColumns(10);
        textField1.setText("Type");
        textField1.setToolTipText("Type something in pls");
        thePanel.add(textField1);

        //JTextArea
        JTextArea textArea1 = new JTextArea(15,20);
        textArea1.setText("Just a whole bunch of text that is important.\n");
        textArea1.setLineWrap(true);

        textArea1.setWrapStyleWord(true);
        int numOfLines = textArea1.getLineCount();
        textArea1.append("number of lines "+numOfLines);

        JScrollPane scrollbar1 = new JScrollPane(textArea1
                ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollbar1);
        this.add(thePanel);
        //textField1.requestFocus();
        textArea1.requestFocus();
        this.show();

    }

}
