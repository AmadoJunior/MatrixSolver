package com.company;

import java.io.File;
import net.sourceforge.tess4j.*;

public class Main {
    /*
    Will need to create a regex to split the string around the new lines and store them into an array
    which I will send into the data2x2 object.
     */

    public static void main(String[] args){
        File imageFile = new File("eurotext.png");
        ITesseract instance = new Tesseract();

        try{
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch(TesseractException e) {
            System.err.println(e.getMessage());
        }
    }

}
