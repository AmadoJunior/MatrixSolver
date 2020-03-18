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

        try{
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch(TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
