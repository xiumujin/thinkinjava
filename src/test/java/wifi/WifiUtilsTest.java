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

    @Test
    public void testAddProfile() {
        boolean hello = WifiUtils.addProfile("HUAWEI_P20_Pro.xml");
        System.out.println(hello);
    }

    @Test
    public void testConnect() {
        ProfileGenerator.genProfile("HUAWEI P20 Pro", "95369536", Connector.PROFILE_TEMP_PATH, "HUAWEI_P20_Pro.xml");
        WifiUtils.addProfile("HUAWEI_P20_Pro.xml");
        WifiUtils.connect("HUAWEI P20 Pro");
        WifiUtils.ping();
    }
}