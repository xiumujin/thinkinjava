package initialization;

public class Test0030 {
    static {
        System.out.println("main static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

class Parent {
    static {
        System.out.println("parent static block");
    }
}

class Child extends Parent {
    static int b = 4;

    static {
        System.out.println("child static block");
    }
}

/**
 * 当初始化一个类时，会先初始化这个类的父类。
 */
