//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class SortedListFrame extends JFrame{


    JPanel mainPnl;
    JPanel displayPnl;
    JPanel controlPnl;
    JPanel buttonPnl;

    JButton writeButton;
    JButton readButton;
    JTextArea displayTA;
    JScrollPane scroller;


    JButton quitBtn;

    SortedList list = new SortedList();












    public SortedListFrame()
    {


        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());


        createButtonPanel();
        mainPnl.add(buttonPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(810, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createButtonPanel()
    {

        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1, 2));
        writeButton = new JButton("Add a word");
        readButton = new JButton("Get position of a word");

        readButton.addActionListener((ActionEvent ae) -> {

            String word = JOptionPane.showInputDialog("Enter a word to search for");

                    if (list.search(word)) {
                        displayTA.setText(word + " was found at " + list.Sort(word) + " point in the list");
                    } else {
                        displayTA.setText(word + " was not found, but would be located at " + list.Sort(word) + " point in the list");
                    }



                }
        );

        writeButton.addActionListener((ActionEvent ae) -> {

                   String word = JOptionPane.showInputDialog("Enter a word to add");

                    list.addString(word);

                    displayTA.setText("");

                    for (int i = 0; i < list.size(); i++) {
                        displayTA.append(i + ": " + list.pullString(i) + "\n");
                    }





                }
        );
        buttonPnl.add(writeButton);
        buttonPnl.add(readButton);



    }





    private void createDisplayPanel()
    {

        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 35);
        displayTA.setFont(new Font("Georgia", Font.PLAIN, 14));
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 1));


        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Verdana", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> {
                    System.exit(0);
                }
        );


        controlPnl.add(quitBtn);

    }


}