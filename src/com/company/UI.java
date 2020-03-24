package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.text.DecimalFormat;

import net.sourceforge.tess4j.*;


public class UI implements ActionListener {
    //Fields
    public static DecimalFormat numberFormat = new DecimalFormat("#.00");
    public static String standardForm = "-?\\d+x(\\+|-|\\*|/)-?\\d+y=-?\\d+";
    Browse browse;
    JFrame frame;
    public static JTextField eq1, eq2;
    JLabel title, manual, eq1Label, eq2Label, importImg;
    public static JLabel result;
    JButton solveButton;
    String[] userInput = new String[2];

    //CONSTRUCTOR
    UI(){
        //SETTING UP SWING OBJECTS
        frame = new JFrame();
        title = new JLabel("Systems of Equations Solver");
        manual = new JLabel("Enter Manually:");
        eq1Label = new JLabel("Equation 1: ");
        eq2Label = new JLabel("Equation 2:");
        eq1 = new JTextField();
        eq2 = new JTextField();
        solveButton = new JButton("Solve");
        result = new JLabel();
        importImg = new JLabel("Import Image:");
        browse = new Browse();

        //POSITIONING
        eq1Label.setBounds(10,75,100, 20);
        eq2Label.setBounds(10,100,100, 20);
        title.setBounds(10, 15, 200, 20);
        manual.setBounds(10, 50, 200, 20);
        eq1.setBounds(100,75,100, 20);
        eq2.setBounds(100,100,100, 20);
        solveButton.setBounds(175,430,75, 20);
        result.setBounds(225, 75, 150, 20);
        importImg.setBounds(10, 150,200,20);

        //ADDING SWING OBJECTS TO FRAME
        frame.add(title);
        frame.add(manual);
        frame.add(eq1Label);
        frame.add(eq2Label);
        frame.add(eq1);
        frame.add(eq2);
        frame.add(solveButton);
        frame.add(result);
        frame.add(importImg);
        frame.add(browse.browse);

        //ACTION LISTENER FOR MANUAL INPUT BUTTON
        solveButton.addActionListener(this);

        //CONFIGURING THE FRAME
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    //ACTIONS PERFORMED FOR "solveButton"
    public void actionPerformed(ActionEvent e){
        if(this.eq1.getText().matches(standardForm) && this.eq2.getText().matches(standardForm)){
            this.userInput[0] = this.eq1.getText();
            this.userInput[1] = this.eq2.getText();
            Data2x2 problem = new Data2x2(userInput);
            double[] solution = problem.solve2x2();
            result.setText("X: " + numberFormat.format(solution[0]) + "  "
                    + "Y: " + numberFormat.format(solution[1]));
        } else {
            result.setText("Not in Standard Form");
        }

    }
    //MAIN
    public static void main(String[] args){
        UI instance = new UI();
    }
}

//Creating Class for Browse Option
class Browse implements ActionListener {
    //Fields
    JFileChooser browse;
    File img;

    //CONSTRUCTOR
    Browse(){
        browse = new JFileChooser();
        browse.setBounds(20, 160, 350, 250);
        browse.addActionListener(this);
    }
    //ACTION
    public void actionPerformed(ActionEvent actionEvent) {
        //ASSIGNS FILE FROM SELECTED FILE IN VIEW
        this.img = browse.getSelectedFile();
        //Getting file name to check format
        String fileName = browse.getName(img);

        //TESSERACT-OCR INSTANCE
        ITesseract imgParser = new Tesseract();

        //Checking for unsupported file formats and confirming standard form
        if(
                    fileName.substring(fileName.length()-3, fileName.length()).equals("png") ||
                    fileName.substring(fileName.length()-3, fileName.length()).equals("jpg") ||
                    fileName.substring(fileName.length()-4, fileName.length()).equals("jpeg")
        ) {

            try {
                String[] system = imgParser.doOCR(img).split("\n");
                system[0] = system[0].replaceAll("\\s","");
                system[1] = system[1].replaceAll("\\s","");
                if(system[0].matches(UI.standardForm) && system[1].matches(UI.standardForm)){
                    UI.eq1.setText(system[0]);
                    UI.eq2.setText(system[1]);
                    Data2x2 problem = new Data2x2(system);
                    double[] solution = problem.solve2x2();
                    UI.result.setText("X: " + UI.numberFormat.format(solution[0]) + "  "
                            + "Y: " + UI.numberFormat.format(solution[1]));
                } else {
                    UI.result.setText("Unsupported Format");
                }

            } catch(TesseractException e) {
                System.err.println(e.getMessage());
            }

        } else {

            UI.result.setText("Unsupported Format");

        }
    }
}
