package initialization;

class Singleton1 {
    private static Singleton1 singleton = new Singleton1();
    public static int counter1=3;
    public static int counter2 = 2;

    public Singleton1() {
        counter1++;
        counter2++;
    }

    public static Singleton1 getInstance() {
        return singleton;
    }
}

class Singleton2 {
    public static int counter1;
    public static int counter2 = 0;
    private static Singleton2 singleton = new Singleton2();

    public Singleton2() {
        counter1++;
        counter2++;
    }

    public static Singleton2 getInstance() {
        return singleton;
    }
}

public class Test0010 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton1.counter1);
        System.out.println(singleton1.counter2);
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.counter1);
        System.out.println(singleton2.counter2);
    }
}

/**
 * 初始化执行过程就是按照顺序执行里面的静态语句和静态代码块。执行private static Singleton1 singleton = new Singleton1(); 时，counter1和counter2均自增，此时counter1和counter2的值均为1，继续往下执行时counter2 又被赋值为0，所以最终
 * counter1和counter2的值分别为1和0。同样的道理不难看出Singleton2中初始化操作顺序执行静态语句之后，counter1和counter2的值分别为1和1。
 * ---------------------
 * 作者：左撇子小哥哥
 * 来源：CSDN
 * 原文：https://blog.csdn.net/lchpersonal521/article/details/53955766
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */