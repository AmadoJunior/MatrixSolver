package com.company;

public class Data2x2 {
    //STRING DATA
    private String equation1;
    private String equation2;

    //RESULTING ARRAYS
    private double[][] matrix = new double[2][2];
    private double[] vector = new double[2];

    //CONSTRUCTOR
    public Data2x2(String[] equations){
        this.equation1 = equations[0];
        this.equation2 = equations[1];
        setArrays();
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
        arr2 = this.equation2.split(pattern1);

        //Setting Vector Array
        vector[0] = Double.parseDouble(arr1[1]);
        vector[1] = Double.parseDouble(arr2[1]);

        //STORING INTO TEMP ARRAY FROM ARR1
        temp = arr1[0].split(pattern2);

        //PARSING AND STORING INTO 2D ARRAY
        for(int i = 0; i < this.matrix[0].length; i++){

            this.matrix[0][i] = Double.parseDouble(temp[i]);

        }

        //STORING INTO TEMP ARRAY FROM ARR2
        temp = arr2[0].split(pattern2);

        //PARSING AND STORING INTO 2D ARRAY
        for(int i = 0; i < this.matrix[1].length; i++){

            this.matrix[1][i] = Double.parseDouble(temp[i]);

        }


    }

    public double[] solve2x2(){
        //FIND DETERMINANT
        double det = (this.matrix[0][0]*this.matrix[1][1])-(this.matrix[0][1]*this.matrix[1][0]);

        //GET COO-FACTORS
        double temp = this.matrix[0][0];
        this.matrix[0][0] = this.matrix[1][1];
        this.matrix[1][1] = temp;
        this.matrix[0][1] = -this.matrix[0][1];
        this.matrix[1][0] = -this.matrix[1][0];

        //MULTIPLY BY INVERSE DET
        for(int i = 0; i < matrix[0].length; i++){
            this.matrix[1][i] *= 1/det;
            this.matrix[0][i] *= 1/det;
        }
        //AFTER FINDING INVERSE MATRIX I WILL FIND X AND Y
        double[] result = new double[2];
        result[0] = (this.matrix[0][0]*this.vector[0])+(this.matrix[0][1]*this.vector[1]);
        result[1] = (this.matrix[1][0]*this.vector[0])+(this.matrix[1][1]*vector[1]);
        return result;
    }

    public String getEq1(){
        return this.equation1;
    }

    public String getEq2(){
        return this.equation2;
    }

    public double[] getVector(){
        return this.vector;
    }

    public double[][] getMatrix(){
        return this.matrix;
    }

    public void print(){

        //PRINTS VEC
        for(double i: this.vector){
            System.out.println("Vector: " + i);
        }

        //PRINTS MATRIX
        for(double i[]: this.matrix){
            for(double f: i){
                System.out.println("Matrix: " + f);
            }
        }

    }

}
