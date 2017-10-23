/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

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
public class StudentTest {
    
    public StudentTest() {
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
     * Test of getLast method, of class Student.
     */
    @Test
    public void testGetLast() {
        System.out.println("getLast");
        Student instance = new Student();
        String expResult = "EXAMPLE";
        String result = instance.getLast();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirst method, of class Student.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        Student instance = new Student();
        String expResult = "STUDENT";
        String result = instance.getFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Student.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Student instance = new Student();
        int expResult = 999999;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
    
}
