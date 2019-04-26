package wifi;

import org.testng.annotations.Test;

/**
 * 文件描述
 * ProductName :    Hundsun UF30
 * ProjectName :    适当性
 * Package :        wifi
 * Description :
 *
 * @author :        pengxin19536
 * @version :       1.0
 * UpdateRemark :
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 * @date :          2019/4/26
 */
public class ProfileGeneratorTest {

    @Test
    public void testGenProfile() {
        ProfileGenerator profileGenerator = new ProfileGenerator();
        profileGenerator.genProfile("HUAWEI P20 Pro", "953619536", Connector.PROFILE_TEMP_PATH, "HUAWEI_P20_Pro.xml");
    }
}