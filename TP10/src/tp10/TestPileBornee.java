package tp10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPileBornee {

    @Test
    public void testIsEmptyAfterCreate() {
        PileBorneeT p = new PileBorneeT(3);
        assertTrue(p.isEmpty());
    }

    @Test
    public void testIsEmptyAfterCreateAndPush() throws FullStackException {
        PileBorneeT p = new PileBorneeT(3);
        p.push(20);
        assertFalse(p.isEmpty());
    }

    @Test
    public void testMaxSizeAfterCreate() {
        PileBorneeT p = new PileBorneeT(3);
        assertEquals(3, p.getMaxSize());
    }

    @Test
    public void testMaxSizeAfterCreateAndPush() throws FullStackException {
        PileBorneeT p = new PileBorneeT(3);
        p.push(20);
        assertEquals(3, p.getMaxSize());
    }

    @Test
    public void testGetSizeAfterCreate() {
        PileBorneeT p = new PileBorneeT(2);
        assertEquals(0, p.getSize());
    }

    @Test
    public void testGetSizeAfterCreateAndPush() throws FullStackException {
        PileBorneeT p = new PileBorneeT(2);
        p.push(11);
        assertEquals(1, p.getSize());

        p.push(22);
        assertEquals(2, p.getSize());
    }

    @Test
    public void testIsFullAfterCreate() {
        PileBorneeT p = new PileBorneeT(0);
        assertTrue(p.isFull());
    }

    @Test
    public void testIsFullAfterCreateAndPush() throws FullStackException {
        PileBorneeT p = new PileBorneeT(2);
        p.push(11);
        assertFalse(p.isFull());

        p.push(22);
        assertTrue(p.isFull());
    }

    @Test(expected = EmptyStackException.class)
    public void testTopAfterCreate() throws EmptyStackException {
        PileBorneeT p = new PileBorneeT(2);
        p.top();
    }

    @Test
    public void testTopAfterCreateAndPush()
            throws EmptyStackException, FullStackException {
        PileBorneeT p = new PileBorneeT(2);
        p.push(11);
        assertEquals(11, (int) p.top());

        p.push(22);
        assertEquals(22, (int) p.top());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopAfterCreate() throws EmptyStackException {
        PileBorneeT p = new PileBorneeT(2);
        p.pop();
    }

    @Test
    public void testPopAfterCreateandPush() throws EmptyStackException, FullStackException {
        PileBorneeT p = new PileBorneeT(2);
        p.push(11);
        p.pop();
        assertTrue(p.isEmpty());
        p.push(11);
        p.push(22);
        p.pop();
        assertEquals(11, (int) p.top());
    }

}
