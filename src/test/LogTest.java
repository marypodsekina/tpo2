package test;

import functions.Ln;
import functions.Log;
import interfaces.ILn;
import interfaces.ILog;
import mocks.LnMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class LogTest {

    private static ILog log;

    private final static double eps = 0.0000001;
    @BeforeAll
    public static void BeforeTest() {
        ILn ln = new LnMock();
        log = new Log(ln);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.22, 3.49, 5.555, 100.00, 0.1, 0.99, 0.3, 0.5, 1.0})
    public void Base5Test(double expectedX) {
        assertEquals(Math.log(expectedX)/Math.log(5), log.log(expectedX, 5, eps), eps*1000);
    }
    @ParameterizedTest
    @ValueSource(doubles = {1.22, 3.49, 5.555, 100.00, 0.1, 0.99, 0.3, 0.5, 1.0})
    public void Base2Test(double expectedX) {
        assertEquals(Math.log(expectedX)/Math.log(2), log.log(expectedX, 2, eps), eps*1000);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.22, 3.49, 5.555, 100.00, 0.1, 0.99, 0.3, 0.5, 1.0})
    public void Base10Test(double expectedX) {
        assertEquals(Math.log10(expectedX), log.log(expectedX, 10, eps), eps*1000);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.22, 3.49, 5.555, 100.00, 0.1, 0.99, 0.3, 0.5, 1.0})
    public void ConversationToBase(double expectedX) {
    assertEquals(Math.log10(expectedX), log.log(expectedX, 2, eps)/log.log(10, 2, eps), eps*1000);
    }

}
