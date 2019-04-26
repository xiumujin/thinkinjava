package wifi;

import java.io.File;

/**
 * 配置文件生成器
 */
public class ProfileGenerator {

    public ProfileGenerator() {
    }

    /**
     * 生成配置文件
     */
    public void genProfile(String ssid, String password, String profilePath, String profileName) {

        String profileContent = Profile.PROFILE.replace(Profile.WIFI_NAME, ssid);
        profileContent = profileContent.replace(Profile.WIFI_PASSWORD, password);
        FileUtils.writeToFile(profilePath + File.separator + profileName, profileContent);
    }
}
