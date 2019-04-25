package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String s = "1005&2|8021&2|8000&3^4#2|6&1|7&1|949&1|8101&1|9001&2|";
        // 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
        // 在这里，我们要提取最后一个数字，正则规则就是“一个数字加上大于等于0个非数字再加上结束符”
        Pattern pattern = Pattern.compile("8000&(.*?)\\|");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find())
            System.out.println(matcher.group(1));
    }
}
