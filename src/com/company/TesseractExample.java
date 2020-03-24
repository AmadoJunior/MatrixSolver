package com.company;

import java.io.File;
import net.sourceforge.tess4j.*;
/*
    Class for Testing Tess
 */
public class TesseractExample {
    public static void main(String[] args){
        File imageFile = new File("Test_Img_( 0, 4 ).png");
        ITesseract instance = new Tesseract();

        String test = "2x+3y=56";
        String standardForm = "\\d+x(+|-|*|/)\\d+y=\\d+";
        if(test.matches(standardForm)){
            System.out.println("It matches");
        } else {
            System.out.println("no");
        }
    }
}
