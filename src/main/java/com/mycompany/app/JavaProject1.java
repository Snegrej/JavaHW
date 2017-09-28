/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;

/**
 *
 * @author Joshua
 */
public class JavaProject1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        JavaProject1 app = new JavaProject1();
        app.run();
    }

    void run(){
        double sum = add(1,2,3,3.4,5);
        double remainder = subtract(5,4,3,2,1);
        double product = multiply(1,2,3,4,5);
        double quotient = divide(840,2,2);
        System.out.println("Sum, remainder, product, quotient = " + sum + ", "+ remainder + ", " + product + ", " + quotient);
    }

    double add(double...numbers){
        double sum = 0;
        for(double number : numbers){
            sum += number;
        }
        return sum;
    }

    double subtract(double start,double...numbers){
        double remainder = start;
        for(double number : numbers){
            remainder -= number;
        }
        return remainder;
    }

    double multiply(double...numbers){
        double product = 1;
        for(double num : numbers){
            product *= num;
        }
        return product;
    }

    double divide(double numer,double...numbers){
        double quotient = numer;
        for(double num : numbers){
            quotient /= num;
        }
        return quotient;
    }

}
