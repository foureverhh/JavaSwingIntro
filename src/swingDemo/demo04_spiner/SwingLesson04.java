package swingDemo.demo04_spiner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class SwingLesson04 extends JFrame {
    JButton button1;
    JSpinner spinner1,spinner2,spinner3,spinner4;
    String outputString = "";

    public static void main(String[] args) {
       new  SwingLesson04();
    }

    private SwingLesson04(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fifth Frame - Spinner");
        JPanel thePanel = new JPanel();

        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        spinner1 = new JSpinner();
        thePanel.add(spinner1);

        spinner2 = new JSpinner(new SpinnerNumberModel(1,1,100,1));
        thePanel.add(spinner2);

        String[] weekDays = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        spinner3 = new JSpinner(new SpinnerListModel(weekDays));
        //Modify dimension of spinner 3 to show all options
        Dimension d = spinner3.getPreferredSize();
        d.width = 100;
        spinner3.setPreferredSize(d);
        thePanel.add(spinner3);

        //spinner4
        Date todayDate = new Date();
        spinner4 = new JSpinner(new SpinnerDateModel(todayDate,null,null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner4,"dd:MM:yyyy");
        spinner4.setEditor(dateEditor);
        thePanel.add(spinner4);

        ListenForSpinner lForSpinner = new ListenForSpinner();
        spinner4.addChangeListener(lForSpinner);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                outputString+="Spinner 1 Value: "+ spinner1.getValue()+" .\n";
                outputString+="Spinner 2 Value: "+ spinner2.getValue()+" .\n";
                outputString+="Spinner 3 Value: "+ spinner3.getValue()+" .\n";
                outputString+="Spinner 4 Value: "+ spinner4.getValue()+" .\n";

                JOptionPane.showMessageDialog(SwingLesson04.this
                        ,outputString
                        ,"Info"
                        ,JOptionPane.INFORMATION_MESSAGE);
            }
            outputString = "";
        }
    }

    private class ListenForSpinner implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {

        }
    }
}
