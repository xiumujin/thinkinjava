package proxy;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProxyTest {

    @Test
    public void testRequest() {
        Proxy proxy=new Proxy();
        proxy.Request();
    }
}