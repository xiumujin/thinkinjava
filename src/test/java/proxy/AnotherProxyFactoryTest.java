package proxy;

import net.sf.cglib.proxy.Enhancer;
import org.testng.annotations.Test;

public class AnotherProxyFactoryTest {

    @Test
    public void testIntercept() {
        // 2. 然后在需要使用HelloConcrete的时候，通过CGLIB动态代理获取代理对象。
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new AnotherProxyFactory());

        HelloConcrete hello = (HelloConcrete) enhancer.create();
        System.out.println(hello.sayHello("I love you!"));
    }
}