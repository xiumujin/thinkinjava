package prototype.expansion;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProtoTypeManagerTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testAddshape() {
    }

    @Test
    public void testGetShape() {
        ProtoTypeManager pm = new ProtoTypeManager();
        Shape obj1 = pm.getShape("Circle");
        obj1.countArea();
        Shape obj2 = pm.getShape("Square");
        obj2.countArea();
    }
}