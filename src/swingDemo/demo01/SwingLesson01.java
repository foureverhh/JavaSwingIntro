package swingDemo.demo01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingLesson01 extends JFrame {
    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;

    public static void main(String[] args) {
        new SwingLesson01();
    }

    public SwingLesson01(){
        this.setSize(400,400);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int posX = (int)(dimension.getWidth()/2) - (this.getWidth()/2);
        int poxY = (dimension.height/2) - (this.getHeight()/2);
        this.setLocation(posX,poxY);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My second frame");

        JPanel thePanel = new JPanel();
        button1 = new JButton("Click here");
        button1.setText("Press here");

        //Add listener to button
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);

        textField1 = new JTextField("",10);
        //textField1.setColumns(10);
        //textField1.setToolTipText("Type text here.");
        ListenForKey lForKeys = new ListenForKey();
        textField1.addKeyListener(lForKeys);

        ListenForFocus lForFocus = new ListenForFocus();
        textField1.addFocusListener(lForFocus);

        textArea1 = new JTextArea("Tracking Event",15,20);
        //textArea1.setSize(10,15);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        JScrollPane scrollbar1 = new JScrollPane(textArea1
                ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        thePanel.add(button1);
        thePanel.add(textField1);
        thePanel.add(textArea1);
        thePanel.add(scrollbar1);

        ListenForWindow lForWindow = new ListenForWindow();
        this.addWindowListener(lForWindow);

        ListenForMouse lForMouse = new ListenForMouse();
        thePanel.addMouseListener(lForMouse);
        this.add(thePanel);
        this.setVisible(true);
        //this.show();
    }

    private class ListenForButton  implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                buttonClicked++;
                textArea1.append("Button clicked: "+buttonClicked+" times.\n");
                //e.getSource().toString();
            }
        }
    }

    private class ListenForKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            textArea1.append("Key typed: "+ e.getKeyChar()+"\n");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            textArea1.append("Key pressed: "+ e.getKeyChar()+"\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            textArea1.append("Key released: "+ e.getKeyChar()+"\n");
        }
    }

    private class ListenForWindow implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
            textArea1.append("windowOpened() is called\n");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            textArea1.append("windowClosing() is called\n");
        }

        //this.dispose() would be called
        @Override
        public void windowClosed(WindowEvent e) {
            textArea1.append("windowClosed() is called\n");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            textArea1.append("windowIconified() is called\n");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            textArea1.append("windowDeiconified() is called\n");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            textArea1.append("windowActivated() is called\n");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("windowDeactivated() is called\n");
        }
    }

    private class ListenForFocus implements FocusListener{
        @Override
        public void focusGained(FocusEvent e) {
            textArea1.append("focusGained() get called.\n");

        }

        @Override
        public void focusLost(FocusEvent e) {
            textArea1.append("focusLost() get called.\n");
        }
    }
    private class ListenForMouse implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            textArea1.append("Mouse Panel pos: "+ e.getX()+" "+e.getY()+"\n");
            textArea1.append("Mouse Screen pos: "+ e.getXOnScreen()+" "+e.getYOnScreen()+"\n");
            textArea1.append("Mouse Button pos: "+ e.getButton()+"\n");
            textArea1.append("Mouse Clicks "+ e.getClickCount());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
