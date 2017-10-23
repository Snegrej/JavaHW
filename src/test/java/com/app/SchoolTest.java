/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;
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
public class SchoolTest {
    
    public SchoolTest() {
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
     * Test of enrollStudents method, of class School.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testEnrollStudents() throws FileNotFoundException{
        System.out.println("enrollStudents");
        School instance = new School("test School");
        instance.enrollStudents("students.dat");
        int numExpected = 10;
        Student exampleStudent = new Student("Mark","Steve",1001);
        assertEquals(numExpected, instance.studentMasterList.size());
        assertEquals(exampleStudent.getLast(), instance.studentMasterList.get(0).getLast());
        assertEquals(exampleStudent.getFirst(), instance.studentMasterList.get(0).getFirst());
        assertEquals(exampleStudent.getId(), instance.studentMasterList.get(0).getId());
    }

    /**
     * Test of printStudents method, of class School.
     */
    @Test
    public void testPrintStudents() {
        System.out.println("printStudents skipped");
    }

    /**
     * Test of main method, of class School.
     */
    @Test
    public void testMain() {
        System.out.println("main skipped");
    }

    /**
     * Test of run method, of class School.
     */
    @Test
    public void testRun() {
        System.out.println("run skipped");
    }

    /**
     * Test of sortStudentsName method, of class School.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testSortStudentsName() throws FileNotFoundException {
        System.out.println("sortStudentsName");
        School instance = new School("test School");
        instance.enrollStudents("students.dat");
        Student temp = new Student("AAAA","AAAA",1000);
        instance.sortStudentsName();
        for(final Student student : instance.studentMasterList){
            assertTrue(temp.getLast().compareTo(student.getLast())<=0);
            temp = student;
        }
    }

    /**
     * Test of sortStudentsId method, of class School.
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testSortStudentsId() throws FileNotFoundException {
        System.out.println("sortStudentsId");
        School instance = new School("test School");
        instance.enrollStudents("students.dat");
        Student temp = new Student("AAAA","AAAA",1000);
        instance.sortStudentsId();
        for(final Student student : instance.studentMasterList){
            System.out.println(temp.getId() + " " + student.getId() + " " + (temp.getId()-student.getId()));
            assertTrue(temp.getId()-student.getId()<=0);
            temp = student;
        }
    }
    
    
    
}
