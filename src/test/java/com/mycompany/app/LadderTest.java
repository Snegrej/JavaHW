/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joshua
 */
public class LadderTest {

    public LadderTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Ladder.
     */
    @Test
    public void testMain() {
        System.out.println("main untested");
    }

    /**
     * Test of run method, of class Ladder.
     */
    @Test
    public void testRun() {
        System.out.println("run untested");
    }

    /**
     * Test of readInput method, of class Ladder.
     */
    @Test
    public void testReadInput() {
        System.out.println("readInput");
        Scanner in = new Scanner("500 70");
        Ladder instance = new Ladder();
        instance.readInput(in);
        assertEquals(500,instance.h);
        assertEquals(70,instance.v);
    }

    /**
     * Test of solveProblem method, of class Ladder.
     */
    @Test
    public void testSolveProblem() {
        System.out.println("Solve problem");
        Scanner in = new Scanner("500 70");
        Ladder instance = new Ladder();
        instance.readInput(in);
        instance.solveProblem();
        assertEquals(533, instance.maxHeight);
    }

}
