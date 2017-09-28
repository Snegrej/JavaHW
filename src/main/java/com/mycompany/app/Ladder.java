package com.mycompany.app;

import java.util.Scanner;

/**
 *
 * @author Joshua
 */
public class Ladder {

    int h,v,maxHeight;
    public static void main(String[] args) throws Exception{
        Ladder ladder = new Ladder();
        ladder.run();
    }

    public void run() throws Exception{
        readInput();
        solveProblem();
        writeOutput();
    }

    public void readInput() throws Exception{
        Scanner in = new Scanner(System.in);
        readInput(in);
    }
    public void readInput(Scanner in){
        h = in.nextInt();
        v = in.nextInt();
        if(h <= 1 || h >= 10_000){
            throw new IllegalStateException("invalid value of h: " +h);
        }
        if(v <= 1 || v >= 89){
            throw new IllegalStateException("invalid value of v: " +v);
        }
    }

    public void solveProblem(){
        maxHeight = (int)Math.ceil(h/Math.sin((v*Math.PI)/180));
    }
    public void writeOutput(){
        System.out.println(maxHeight);
    }


}
