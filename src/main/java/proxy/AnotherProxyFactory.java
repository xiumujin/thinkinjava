package proxy;

import lombok.extern.log4j.Log4j2;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

@Log4j2
public class AnotherProxyFactory implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info("You said: " + Arrays.toString(args));
        return proxy.invokeSuper(obj, args);
    }
}

class HelloConcrete {
    public String sayHello(String str) {
        return "HelloConcrete: " + str;
    }
}

