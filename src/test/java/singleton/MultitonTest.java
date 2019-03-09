package singleton;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: pengxin19536@hundsun.com<br>
 * 开发时间: 2019年03月09日<br>
 */
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
