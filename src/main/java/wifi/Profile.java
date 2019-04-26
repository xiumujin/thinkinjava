package wifi;

public class Profile {
    public static final String WIFI_NAME = "SSID_NAME";

    public static final String WIFI_PASSWORD = "PASSWORD";

    public static final String PROFILE = "<?xml version=\"1.0\"?>\n" +
            "<WLANProfile xmlns=\"http://www.microsoft.com/networking/WLAN/profile/v1\">\n" +
            "<name>" + WIFI_NAME + "</name>\n" +
            "<SSIDConfig>\n" +
            "    <SSID>\n" +
            "        <name>" + WIFI_NAME + "</name>\n" +
            "    </SSID>\n" +
            "</SSIDConfig>\n" +
            "<connectionType>ESS</connectionType>\n" +
            "<connectionMode>auto</connectionMode>\n" +
            "<MSM>\n" +
            "    <security>\n" +
            "        <authEncryption>\n" +
            "            <authentication>WPA2PSK</authentication>\n" +
            "            <encryption>AES</encryption>\n" +
            "            <useOneX>false</useOneX>\n" +
            "        </authEncryption>\n" +
            "        <sharedKey>\n" +
            "            <keyType>passPhrase</keyType>\n" +
            "            <protected>false</protected>\n" +
            "            <keyMaterial>" + WIFI_PASSWORD + "</keyMaterial>\n" +
            "        </sharedKey>\n" +
            "    </security>\n" +
            "</MSM>\n" +
            "<MacRandomization xmlns=\"http://www.microsoft.com/networking/WLAN/profile/v3\">\n" +
            "    <enableRandomization>false</enableRandomization>\n" +
            "</MacRandomization>\n" +
            "</WLANProfile>";
}
