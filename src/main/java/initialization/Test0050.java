package initialization;

public class Test0050 {
    public static void main(String[] args) {
        System.out.println(Child0050.a);
    }
}

class Parent0050 {
    static int a = 3;

    static {
        System.out.println("parent static block");
    }
}

class Child0050 extends Parent0050 {
    static {
        System.out.println("child static block");
    }
}

/**
 * 有当程序访问的静态变量或静态方法确实在当前类或接口中定义时，才可以认为是对类的主动使用。
 */