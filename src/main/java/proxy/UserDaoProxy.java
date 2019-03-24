package proxy;

interface IUserDao {
    void save();
}

//静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
//关键：在编译期确定代理对象，在程序运行前代理类的.class文件就已经存在了。
//比如：在代理对象中实例化被代理对象或者将被代理对象传入代理对象的构造方法
public class UserDaoProxy implements IUserDao {
    //接收保存目标对象
    private IUserDao target;

    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}

class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
