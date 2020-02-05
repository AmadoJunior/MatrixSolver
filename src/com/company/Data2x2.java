package com.company;

public class Data2x2 {
    //STRING DATA
    private String equation1;
    private String equation2;

    //RESULTING ARRAYS
    private int[][] matrix = new int[2][2];
    private int[] vector = new int[2];

    //CONSTRUCTOR
    public Data2x2(String[] equations){
        this.equation1 = equations[0];
        this.equation2 = equations[1];
    }

    public void setArrays(){
        //REGULAR EXPRESSION
        String pattern1 = "y=";
        String pattern2 = "x";

        //TEMP ARRAYS
        String[] arr1 = new String[2];
        String[] arr2 = new String[2];
        String[] temp = new String[2];

        //STORING INTO TEMP ARRAYS
        arr1 = this.equation1.split(pattern1);
        arr2 = this.equation2.split(pattern2);

        //Setting Vector Array
        vector[0] = Integer.parseInt(arr1[1]);
        vector[1] = Integer.parseInt(arr2[1]);

        //STORING INTO TEMP ARRAY FROM ARR1
        temp = arr1[0].split(pattern2);

        //PARSING AND STORING INTO 2D ARRAY
        for(int i = 0; i < this.matrix[0].length; i++){

            this.matrix[0][i] = Integer.parseInt(temp[i]);

        }

        //STORING INTO TEMP ARRAY FROM ARR2
        temp = arr2[0].split(pattern2);

        //PARSING AND STORING INTO 2D ARRAY
        for(int i = 0; i < this.matrix[1].length; i++){

            this.matrix[1][i] = Integer.parseInt(temp[i]);

        }

    }

    public int[] solve2x2(){
        //FIND REVERSE

        //MULTIPLY

        //RETURN RESULT IN FORM OF ARRAY

        return null;
    }

    public String getEq1(){
        return this.equation1;
    }

    public String getEq2(){
        return this.equation2;
    }

    public int[] getVector(){
        return this.vector;
    }

    public int[][] getMatrix(){
        return this.matrix;
    }

    public void print(){

        //PRINTS VEC
        for(int i: this.vector){
            System.out.println("Vector: " + i);
        }

        //PRINTS MATRIX
        for(int i[]: this.matrix){
            for(int f: i){
                System.out.println("Matrix: " + f);
            }
        }

    }

}
