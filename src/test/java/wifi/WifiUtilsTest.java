package wifi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class WifiUtilsTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testListSsid() {
        WifiUtils.listWiFiInfo();
    }

    @Test
    public void testCheck() {
    }
}