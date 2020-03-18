package com.company;

import java.io.File;
import net.sourceforge.tess4j.*;

import javax.xml.crypto.Data;

public class Main {
    /*
        Testing Class
     */

    public static void main(String[] args){
        //TEST WITH IMAGE
        File img = new File("test.png");
        ITesseract imgParser = new Tesseract();
        String[] system = new String[2];

        try{
            String test = imgParser.doOCR(img);
            system = test.split("\n");
        } catch (TesseractException e){
            System.err.println(e.getMessage());
        }
        System.out.println("Equation 1: " + system[0]);
        System.out.println("Equation 2: " + system[1]);
        Data2x2 problem = new Data2x2(system);
        problem.setArrays();
        problem.print();
        double[] resultArr = problem.solve2x2();
        System.out.println("x = " + resultArr[0]);
        System.out.println("y = " + resultArr[1]);
    }

}
