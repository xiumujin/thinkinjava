package prototype;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RealizetypeTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testClone() {
        Realizetype obj1 = new Realizetype();
        Realizetype obj2 = null;
        try {
            obj2 = (Realizetype) obj1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("obj1==obj2?" + (obj1 == obj2));
    }
}