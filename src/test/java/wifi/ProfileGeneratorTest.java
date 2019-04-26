package wifi;

import org.testng.annotations.Test;

public class ProfileGeneratorTest {

    @Test
    public void testGenProfile() {
        ProfileGenerator profileGenerator = new ProfileGenerator();
        profileGenerator.genProfile("HUAWEI P20 Pro", "953619536", Connector.PROFILE_TEMP_PATH, "HUAWEI_P20_Pro.xml");
    }
}