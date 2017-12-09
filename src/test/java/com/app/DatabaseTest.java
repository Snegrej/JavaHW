package com.app;

import java.sql.Connection;
import java.sql.Statement;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * 
 */
public class DatabaseTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DatabaseTest( String testName )
    {
        super( testName );
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DatabaseTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * Test of main method, of class Database.
     */
    @org.junit.Test
    public void testMain() throws Exception {
        System.out.println("main untested");
    }

    /**
     * Test of getConnection method, of class Database.
     */
    @org.junit.Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Database instance = new Database();
        assertTrue(instance.getConnection()!=null);
    }

    /**
     * Test of insert method, of class Database.
     */
    @org.junit.Test
    public void testInsert() {
        System.out.println("insert");
        int moistureLevel = 500;
        String theDate = "2017-12-08";
        String dataTime = "23:43:25";
        Database instance = new Database();
        instance.insert(moistureLevel, theDate, dataTime);
        testGetConnection();
    }

    /**
     * Test of getStatement method, of class Database.
     */
    @org.junit.Test
    public void testGetStatement() {
        System.out.println("getStatement");
        Database instance = new Database();
        assertTrue(instance.getStatement()!=null);
    }

    /**
     * Test of sql method, of class Database.
     */
    @org.junit.Test
    public void testSql() {
        System.out.println("sql");
        String command = "SELECT * FROM dataSet";
        int moistureLevel = 500;
        String theDate = "2017-12-08";
        String dataTime = "23:43:25";
        Database instance = new Database();
        instance.reset();
        instance.insert(moistureLevel, theDate, dataTime);
        instance.sql(command);
        //not really sure what to assert. What do I test exactly beyond that the code executes?
        
    }

    /**
     * Test of selectByDate method, of class Database.
     */
    @org.junit.Test
    public void testSelectByDate() throws Exception {
        System.out.println("selectByDate");
        //How do you test system output?
    }

    /**
     * Test of printAllData method, of class Database.
     */
    @org.junit.Test
    public void testPrintAllData() throws Exception {
        System.out.println("printAllData");
        //How do you test system output?
    }

    /**
     * Test of reset method, of class Database.
     */
    @org.junit.Test
    public void testReset() {
        System.out.println("reset");
        //just calls sql
    }

    /**
     * Test of readData method, of class Database.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testReadData() throws Exception {
        System.out.println("readData");
    }

    /**
     * Test of run method, of class Database.
     * @throws java.lang.Exception
     */
    @org.junit.Test
    public void testRun() throws Exception {
        System.out.println("run untested");
    }
}
