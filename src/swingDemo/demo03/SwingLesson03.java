package swingDemo.demo03;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingLesson03 extends JFrame {

    private JButton button1;
    private String infoOnComponent = "";
    private JList favoriteMovies, favoriteColors;
    private DefaultListModel defaultListModel = new DefaultListModel();
    private JScrollPane scroller;

    public static void main(String[] args) {
        new SwingLesson03();
    }

    private SwingLesson03(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Fifth Frame");
        JPanel thePanel = new JPanel();

        button1 = new JButton("Get Answer");
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        String[] movies = {"Matrix","Minority Report","Big"};
        favoriteMovies = new JList(movies);
        favoriteMovies.setFixedCellHeight(30);
        favoriteMovies.setFixedCellWidth(150);
        favoriteMovies.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        String[] colors = {"Black","Blue","White","Green","Orange","Gray"};
        for(String color : colors){
            defaultListModel.addElement(color);
        }
        defaultListModel.add(2,"Purple");

        favoriteColors = new JList(defaultListModel);
        favoriteColors.setVisibleRowCount(4);

        scroller = new JScrollPane(favoriteColors
        ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        favoriteColors.setFixedCellHeight(30);
        favoriteColors.setFixedCellWidth(150);

        thePanel.add(favoriteMovies);
        thePanel.add(favoriteColors);
        thePanel.add(scroller);

        this.add(thePanel);
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button1){
                if(defaultListModel.contains("Black")){
                    infoOnComponent+="Black is here\n";
                }

                if(!defaultListModel.isEmpty()){
                    infoOnComponent += "Isn't an empty list\n";
                }

                infoOnComponent+="Elements in the List" + defaultListModel.size()+"\n";
                infoOnComponent+="Last element is " + defaultListModel.lastElement()+"\n";

                JOptionPane.showMessageDialog(SwingLesson03.this
                ,infoOnComponent
                ,"Info component"
                ,JOptionPane.INFORMATION_MESSAGE);

                infoOnComponent = "";
            }
        }
    }
}
