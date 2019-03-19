package initialization;

public class Test0060 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("initialization.CL");
        System.out.println("------------------------------");
//        Class clazz = Class.forName("initialization.CL");
    }
}

class CL {
    static {
        System.out.println("class CL static block");
    }
}

/**
 * 调用ClassLoader的loadClass方法加载一个类，并不是对类的主动使用。
 */