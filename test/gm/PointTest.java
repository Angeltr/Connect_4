/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gm;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Angel
 */
public class PointTest {
    
    public PointTest() {
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
     * Test of equalsPosition method, of class Point.
     */
    @Test
    public void testEqualsPosition() {
        System.out.println("equalsPosition");
        Point q = new Point(1, 2, 0);
        Point instance = new Point(1, 2, 0);
        boolean expResult = true;
        boolean result = instance.equalsPosition(q);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class Point.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        Point instance = new Point(1, 2, 0);
        instance.setX(x);
        
        assertEquals(instance.getX(), 0);
    }

    /**
     * Test of setY method, of class Point.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Point instance = new Point(1, 2, 0);
        instance.setY(y);
        
        assertEquals(instance.getY(), 0);
    }

    /**
     * Test of setState method, of class Point.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        int player = 1;
        Point instance = new Point(1, 2, 0);
        instance.setState(player);
        
        assertEquals(instance.getState(), 1);
    }

    /**
     * Test of getX method, of class Point.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Point instance = new Point(1, 2, 0);
        int expResult = 1;
        int result = instance.getX();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class Point.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Point instance = new Point(1, 2, 0);
        int expResult = 2;
        int result = instance.getY();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class Point.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Point instance = new Point(1, 2, -1);
        int expResult = -1;
        int result = instance.getState();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Point.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Point instance = new Point(1, 2, 0);
        String expResult = "1,2|0";
        String result = instance.toString();
        
        assertEquals(expResult, result);
    }
}
