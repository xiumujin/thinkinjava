package singleton.expansion;

public class MultitonTest {

    @org.testng.annotations.BeforeMethod
    public void setUp() {
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
    }

    @org.testng.annotations.Test
    public void testGetInstance() {
        for (int i = 0; i < 20; i++) {
            Multiton multiton = Multiton.getInstance();
            multiton.say();
        }
    }
}
