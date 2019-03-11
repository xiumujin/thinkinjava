package singleton.expansion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 单例模式的扩展
 * <p>
 * 单例模式可扩展为有限的多例（Multiton）模式，这种模式可生成有限个实例并保存在 ArrayList 中，客户需要时可随机获取。
 */
public class Multiton {

    private static List<Multiton> list = new ArrayList<>();

    private static int maxNum = 5;

    private int number;

    private Multiton(int number) {
        this.number = number;
    }

    static {
        for (int i = 0; i < maxNum; i++) {
            list.add(new Multiton(i));
        }
    }

    public static Multiton getInstance() {
        int value = new Random().nextInt(maxNum);
        return list.get(value);
    }

    public void say() {
        System.out.println(this.number);
    }
}
