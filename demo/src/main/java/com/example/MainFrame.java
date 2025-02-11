package com.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    public void initialize(){

        JPanel formPanel = new JPanel(new GridLayout(2,1,5,5));
        JButton gramButton = new JButton("Grammit!");
        gramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                App.gram();
            }
        });
        formPanel.add(gramButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formPanel);
        add(mainPanel);

        setTitle("Instantly Grammit");
        setSize(500,600);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
