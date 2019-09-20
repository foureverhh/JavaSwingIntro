package swingDemo.demo05_tree;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class SwingLesson05 extends JFrame {
    private JButton button1;
    private String outputString = "";
    private JTree theTree;
    private DefaultMutableTreeNode documents,work,games,emails;
    private DefaultMutableTreeNode fileSystem =new DefaultMutableTreeNode("C Drive");

    public static void main(String[] args) {
        new SwingLesson05();
    }
    private SwingLesson05(){
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("My sixth frame - JTree");
        JPanel thePanel = new JPanel();
        button1 = new JButton("Get Answer");
        ButtonListener buttonListener = new ButtonListener();
        button1.addActionListener(buttonListener);
        thePanel.add(button1);

        //Handle tree
        theTree = new JTree(fileSystem);
        theTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        theTree.setVisibleRowCount(8);
        documents = addAFile("Docs",fileSystem);
        addAFile("Texes.exl",documents);
        addAFile("Story.txt",documents);
        //make a file named as "Emails" under documents
        emails = addAFile("Emails",documents);
        addAFile("Schedule.txt",documents);
        addAFile("CallBob.txt",emails);

        //make a file named as Work Application, under filesystem
        work = addAFile("Work application",fileSystem);
        addAFile("Spreadsheet.exe",work);
        addAFile("WordProcessor.exe",work);

        //make a file named as Games, under filesystem
        games = addAFile("Games",fileSystem);
        addAFile("SpaceInvader.exe",games);
        addAFile("PacMan.exe",games);

        JScrollPane scrollPane = new JScrollPane(theTree);
        Dimension d = scrollPane.getPreferredSize();
        d.width = 200;
        scrollPane.setPreferredSize(d);
        //thePanel.add(theTree);
        thePanel.add(scrollPane);
        this.add(thePanel);
        this.setVisible(true);
    }

    private DefaultMutableTreeNode addAFile(String fileName, DefaultMutableTreeNode parentFolder) {
        DefaultMutableTreeNode newFile = new DefaultMutableTreeNode(fileName);
        parentFolder.add(newFile);
        return newFile;
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == button1){
                Object treeObject = theTree.getLastSelectedPathComponent();
                DefaultMutableTreeNode theFile = (DefaultMutableTreeNode) treeObject;
                String treeNode = (String) theFile.getUserObject();
                outputString += "The selected node: "+treeNode+"\n";
                outputString += "Number of Children: "+ theFile.getChildCount()+"\n";
                outputString += "Number of sibling: "+ theFile.getSiblingCount()+"\n";
                outputString += "Parent: "+ theFile.getParent()+"\n";
                outputString += "Next Node "+ theFile.getNextNode()+"\n";
                outputString += "Previous Node "+ theFile.getPreviousNode()+"\n";
                outputString += "Previous Node "+ theFile.getPreviousNode()+"\n";
                outputString += "\nChildren of Node\n";
                for(Enumeration enumValue = theFile.children();enumValue.hasMoreElements();){
                    outputString += enumValue.nextElement()+"\n";
                }

                outputString += "\nPath From Root\n";
                TreeNode[] pathNodes = theFile.getPath();
                for(TreeNode node : pathNodes){
                    outputString += node + "\n";
                }

                JOptionPane.showMessageDialog(SwingLesson05.this
                ,outputString
                ,"Info"
                ,JOptionPane.INFORMATION_MESSAGE);
                outputString = "";
            }
        }
    }
}
