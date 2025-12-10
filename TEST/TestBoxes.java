import org.junit.*;
import static org.junit.Assert.*;

public class TestBoxes {

    @Test
    public void testBoxCreate() {
        Box b = new Box();
        assertTrue(b.isOpen()); 
    }

    @Test
    public void testAddAndContains() {
        Box b = new Box();
        Thing t = new Thing(1, "clé");
        b.add(t);
        assertTrue(b.contains(t)); 
    }

    @Test(expected = Exception.class)
    public void testRemoveException() throws Exception {
        Box b = new Box();
        Thing t = new Thing(1, "fantôme");
        b.remove(t); 
    }

    @Test
    public void testRemoveSuccess() throws Exception {
        Box b = new Box();
        Thing t = new Thing(1, "clé");
        b.add(t);
        b.remove(t);
        assertFalse(b.contains(t)); 
    }

    @Test
    public void testOpenClose() {
        Box b = new Box();
        b.close();
        assertFalse(b.isOpen()); 
        b.open();
        assertTrue(b.isOpen());  
    }

    @Test
    public void testActionLook() {
        Box b = new Box();
        Thing t1 = new Thing(1, "ceci");
        Thing t2 = new Thing(1, "cela");
        b.add(t1);
        b.add(t2);
        assertEquals("la boite contient: ceci, cela", b.actionLook()); 
        b.close();
        assertEquals("la boite est fermee", b.actionLook()); 
    }

 
    @Test
    public void testCapacityAndHasRoom() throws Exception {
        Box b = new Box(true, 5); 
        Thing t1 = new Thing(3, "gros");
        Thing t2 = new Thing(2, "petit");
        assertTrue(b.hasRoomFor(t1)); 
        b.actionAdd(t1);             
        assertTrue(b.hasRoomFor(t2)); 
        b.actionAdd(t2);             
        assertFalse(b.hasRoomFor(new Thing(1, "trop"))); 
    }


    @Test(expected = Exception.class)
    public void testActionAddFailClosed() throws Exception {
        Box b = new Box();
        b.close();
        b.actionAdd(new Thing(1, "clé")); 
    }


    @Test
    public void testFindSuccess() throws Exception {
        Box b = new Box();
        Thing t = new Thing(1, "bidule");
        b.add(t);
        assertEquals(t, b.find("bidule")); 
    }


    @Test(expected = Exception.class)
    public void testFindFail() throws Exception {
        Box b = new Box();
        b.find("inconnu"); // doit lancer Exception
    }


    @Test(expected = Exception.class)
    public void testFindFailClosed() throws Exception {
        Box b = new Box();
        b.close();
        b.find("bidule"); 
    }
}