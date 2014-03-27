/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gm;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Angelos Trigkas
 */
public class BoardTest {
    
    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateCL method, of class Board.
     */
    @Test
    public void testGenerateCL() {
        System.out.println("generateCL");
        /**
         * Board instance = new Board(7, 6);
         * instance.generateCL();
         */
        fail("The test case is a prototype.");
    }

    /**
     * Test of validMove method, of class Board.
     */
    @Test
    public void testValidMove() {
        System.out.println("validMove");
        int column = 0;
        Board instance = new Board(7, 6);
        boolean expResult = true;
        boolean result = instance.validMove(column);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of makeMove method, of class Board.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        int column = 0;
        Board instance = new Board(7, 6);
        instance.makeMove(column);
        
        assertEquals(instance.getHeight(0), 1);
        assertEquals(instance.getMove(instance.getLm()), 0);
    }

    /**
     * Test of undoMove method, of class Board.
     */
    @Test
    public void testUndoMove() {
        System.out.println("undoMove");
        Board instance = new Board(7, 6);
        instance.makeMove(0);
        instance.undoMove();
        
        assertEquals(instance.getHeight(0), 0);
	assertEquals(instance.getLm(), -1);
    }

    /**
     * Test of validMovesLeft method, of class Board.
     */
    @Test
    public void testValidMovesLeft() {
        System.out.println("validMovesLeft");
        Board instance = new Board(7, 6);
        boolean expResult = true;
        boolean result = instance.validMovesLeft();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of winnerIs method, of class Board.
     */
    @Test
    public void testWinnerIs() {
        System.out.println("winnerIs");
        /**
         * Board instance = new Board(7, 6);
         * int expResult = 0;
         * int result = instance.winnerIs();
         * assertEquals(expResult, result);
         */
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStrength method, of class Board.
     */
    @Test
    public void testGetStrength() {
        System.out.println("getStrength");
        /**
         * Board instance = new Board(7, 6);
         * int expResult = 0;
         * int result = instance.getStrength();
         * assertEquals(expResult, result);
         */
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        /**
         * Board instance = new Board(7, 6);
         * String expResult = "";
         * String result = instance.toString();
         * assertEquals(expResult, result);
         */
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCP method, of class Board.
     */
    @Test
    public void testSetCP() {
        System.out.println("setCP");
        int cp = 1;
        Board instance = new Board(7, 6);
        instance.setCP(cp);
        
        assertEquals(instance.getCP(), 1);
    }

    /**
     * Test of getCP method, of class Board.
     */
    @Test
    public void testGetCP() {
        System.out.println("getCP");
        Board instance = new Board(7, 6);
        int expResult = 1;
        int result = instance.getCP();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of printCL method, of class Board.
     */
    @Test
    public void testPrintCL() {
        System.out.println("printCL");
        /**
         * Board instance = new Board(7, 6);
         * instance.printCL();
         */
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Board.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        int col = 0;
        Board instance = new Board(7, 6);
        instance.makeMove(col);
        instance.makeMove(col);
        int expResult = 2;
        int result = instance.getHeight(col);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getMove method, of class Board.
     */
    @Test
    public void testGetMove() {
        System.out.println("getMove");
        int lm = 0;
        Board instance = new Board(7, 6);
        instance.makeMove(0);
        int expResult = 0;
        int result = instance.getMove(lm);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getLm method, of class Board.
     */
    @Test
    public void testGetLm() {
        System.out.println("getLm");
        Board instance = new Board(7, 6);
        instance.makeMove(0);
        int expResult = 0;
        int result = instance.getLm();
        
        assertEquals(expResult, result);
    }
}
