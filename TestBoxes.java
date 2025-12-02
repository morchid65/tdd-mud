import org.junit.*;
import static org.junit.Assert.*;

public class TestBoxes {
    @Test
    public void testBoxCreate() {
        Box box = new Box();
    }
    //*
    //  */
    @Test
    public void testBoxAdd() {
        Box b = new Box();
        b.add("item1");
        b.add("item2");
    }        
}