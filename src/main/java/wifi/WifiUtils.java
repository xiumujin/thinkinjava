package wifi;

import java.util.ArrayList;
import java.util.List;

import static wifi.CmdExecutor.execute;

public class WifiUtils {


    /**
     * 列出所有信号较好的ssid
     *
     * @return 所有ssid
     */
    public static List<SsidInfo> listWiFiInfo() {
        List<SsidInfo> wiFiInfos = new ArrayList<>();
        String cmd = Command.SHOW_NETWORKS;
        List<String> results = execute(cmd, null);
        if (results != null && results.size() > 0) {
            for (String result : results) {
                System.out.println(result);
            }
            // todo 整合信息
        }
        return wiFiInfos;
    }

    /**
     * 添加配置文件
     *
     * @param profileName 添加配置文件
     */
    public static boolean addProfile(String profileName) {
        String cmd = Command.ADD_PROFILE.replace("FILE_NAME", profileName);
        List<String> results = execute(cmd, Connector.PROFILE_TEMP_PATH);
        if (results != null && results.size() > 0) {
            for (String result : results) {
                System.out.println(result);
            }
            return results.get(0).contains("添加到接口");
        }
        return false;
    }

    /**
     * 连接wifi
     *
     * @param ssid 添加配置文件
     */
    public static boolean connect(String ssid) {
        boolean connected = false;
        String cmd = Command.CONNECT.replace("SSID_NAME", "\"" + ssid + "\"");
        List<String> results = execute(cmd, null);
        if (results != null && results.size() > 0) {
            for (String result : results) {
                System.out.println(result);
            }
            if (results.get(0).contains("已成功完成")) {
                connected = true;
            }
        }
        return connected;
    }

    /**
     * ping 校验
     */
    public static boolean ping() {
        boolean pinged = false;
        String cmd = "ping " + Connector.PING_DOMAIN;
        List<String> result = execute(cmd, null);
        if (result != null && result.size() > 0) {
            for (String item : result) {
                if (item.contains("来自")) {
                    pinged = true;

                }
                System.out.println(item);
            }
        }
        System.out.println("ping:" + pinged);
        return pinged;
    }

    /**
     * 校验WLAN配置文件是否正确
     * <p>
     * 校验步骤为：
     * ---step1 添加配置文件
     * ---step3 连接wifi
     * ---step3 ping校验
     */
    public synchronized boolean check(String ssid, String password) {
        System.out.println("check : " + password);
        try {
            String profileName = password + ".xml";
            if (addProfile(profileName)) {
                if (connect(ssid)) {
                    Thread.sleep(50);
                    if (ping()) {
                        return true;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
