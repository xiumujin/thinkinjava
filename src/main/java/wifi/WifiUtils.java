package wifi;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static wifi.CmdExecutor.execute;

public class WifiUtils {


    /**
     * 列出所有信号较好的ssid
     *
     * @return 所有ssid
     */
    public static List<SsidInfo> listSsidInfo() {
        List<SsidInfo> ssidInfos = new ArrayList<>();
        String cmd = Command.SHOW_NETWORKS;
        List<String> results = execute(cmd, null);
        if (results != null && results.size() > 0) {
            for (String result : results) {
                if (StringUtils.contains(result, "SSID") && !StringUtils.contains(result, "BSSID")) {
                    SsidInfo ssidInfo = new SsidInfo();
                    ssidInfo
                }

            }
        }
        return ssidInfos;
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

    public void run(char[] charSource, int maxLength) {

        //计数器，多线程时可以对其加锁，当然得先转换成Integer类型。
        int counter = 0;
        StringBuilder buider = new StringBuilder();
        while (buider.toString().length() <= maxLength) {
            buider = new StringBuilder(maxLength * 2);
            int _counter = counter;
            //10进制转换成26进制
            while (_counter >= charSource.length) {
                //获得低位
                buider.insert(0, charSource[_counter % charSource.length]);
                _counter = _counter / charSource.length;
                //精髓所在，处理进制体系中只有10没有01的问题，在穷举里面是可以存在01的
                _counter--;
            }
            //最高位
            buider.insert(0, charSource[_counter]);
            counter++;

        }
    }
}
