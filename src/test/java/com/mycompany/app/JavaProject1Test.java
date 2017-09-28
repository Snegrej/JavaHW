/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;

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
public class JavaProject1Test {

    public JavaProject1Test() {
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
     * Test of main method, of class JavaProject1.
     */
    @Test
    public void testMain() {
        System.out.println("main skipped");
    }

    /**
     * Test of run method, of class JavaProject1.
     */
    @Test
    public void testRun() {
        System.out.println("run skipped");
    }

    /**
     * Test of add method, of class JavaProject1.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        double[] numbers = {0,1,2,3,4};
        JavaProject1 instance = new JavaProject1();
        double expResult = 10.0;
        double result = instance.add(numbers);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of subtract method, of class JavaProject1.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        double start = 0.0;
        double[] numbers = {0,1,2,3,4};
        JavaProject1 instance = new JavaProject1();
        double expResult = -10.0;
        double result = instance.subtract(start, numbers);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of multiply method, of class JavaProject1.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        double[] numbers = {1,2,3,4};
        JavaProject1 instance = new JavaProject1();
        double expResult = 24.0;
        double result = instance.multiply(numbers);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of divide method, of class JavaProject1.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        double numer = 100;
        double[] numbers = {1,2,5,2};
        JavaProject1 instance = new JavaProject1();
        double expResult = 5.0;
        double result = instance.divide(numer, numbers);
        assertEquals(expResult, result, 0.0);
    }

}
