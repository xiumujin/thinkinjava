package bridge;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RefinedAbstractionTest {

    @Test
    public void testOperation() {
        Implementor imple=new ConcreteImplementorA();
        Abstraction abs=new RefinedAbstraction(imple);
        abs.Operation();
    }
}