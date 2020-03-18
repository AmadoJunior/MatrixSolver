package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import net.sourceforge.tess4j.*;


public class UI implements ActionListener {
    JFrame frame;
    JTextField eq1, eq2;
    JLabel eq1Label, eq2Label, result;
    JButton solveButton;
    String[] userInput = new String[2];

    UI(){
        frame = new JFrame();
        eq1Label = new JLabel("Equation 1: ");
        eq2Label = new JLabel("Equation 2:");
        eq1 = new JTextField();
        eq2 = new JTextField();
        solveButton = new JButton("Solve");
        result = new JLabel();

        eq1Label.setBounds(10,50,100, 20);
        eq2Label.setBounds(10,75,100, 20);
        eq1.setBounds(100,50,100, 20);
        eq2.setBounds(100,75,100, 20);
        solveButton.setBounds(10,150,75, 20);
        result.setBounds(250, 50, 100, 20);

        frame.add(eq1Label);
        frame.add(eq2Label);
        frame.add(eq1);
        frame.add(eq2);
        frame.add(solveButton);
        frame.add(result);

        solveButton.addActionListener(this);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        this.userInput[0] = this.eq1.getText();
        this.userInput[1] = this.eq2.getText();
        Data2x2 problem = new Data2x2(userInput);
        double[] solution = problem.solve2x2();
        result.setText("X: " + solution[0] + "  "
                        + "Y: " + solution[1]);
    }

    public static void main(String[] args){
        UI instance = new UI();
    }
}
