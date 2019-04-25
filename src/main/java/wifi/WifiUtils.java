package wifi;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WifiUtils {
    /**
     * 执行器
     *
     * @param cmd      CMD命令
     * @param filePath 需要在哪个目录下执行
     */
    private static List<String> execute(String cmd, String filePath) {
        Process process = null;
        List<String> result = new ArrayList<>();
        try {
            if (filePath != null) {
                process = Runtime.getRuntime().exec(cmd, null, new File(filePath));
            } else {
                process = Runtime.getRuntime().exec(cmd);
            }
            BufferedReader bReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            String line = null;
            while ((line = bReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 列出所有信号较好的ssid
     *
     * @return 所有ssid
     */
    public static List<WiFiInfo> listWiFiInfo() {
        List<WiFiInfo> wiFiInfos = new ArrayList<>();
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
    private static boolean addProfile(String profileName) {
        String cmd = Command.ADD_PROFILE.replace("FILE_NAME", profileName);
        List<String> result = execute(cmd, Connector.PROFILE_TEMP_PATH);
        if (result != null && result.size() > 0) {
            return result.get(0).contains("添加到接口");
        }
        return false;
    }

    /**
     * 连接wifi
     *
     * @param ssid 添加配置文件
     */
    private static boolean connect(String ssid) {
        boolean connected = false;
        String cmd = Command.CONNECT.replace("SSID_NAME", ssid);
        List<String> result = execute(cmd, null);
        if (result != null && result.size() > 0) {
            if (result.get(0).contains("已成功完成")) {
                connected = true;
            }
        }
        return connected;
    }

    /**
     * ping 校验
     */
    private static boolean ping() {
        boolean pinged = false;
        String cmd = "ping " + Connector.PING_DOMAIN;
        List<String> result = execute(cmd, null);
        if (result != null && result.size() > 0) {
            for (String item : result) {
                if (item.contains("来自")) {
                    pinged = true;
                    break;
                }
            }
        }
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
