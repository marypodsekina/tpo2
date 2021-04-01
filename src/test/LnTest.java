package test;

import functions.Ln;
import interfaces.ILn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class LnTest {

    private static ILn ln;
    public final static double eps = 0.000001;

    @BeforeAll
    public static void init() {
        ln = new Ln();
    }

    @Test
    public void ZeroTest() {
        double expectedX = 1;
        assertEquals(Math.log(expectedX), ln.ln(expectedX, eps), eps*1000);
    }
    @ParameterizedTest
    @ValueSource(doubles = {1.22, 3.49, 5.555, 80.0})
    public void UpperTest(double expectedX) {
        assertEquals(Math.log(expectedX), ln.ln(expectedX, eps), eps*1000);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.88, 0.10, 0.55, 0.81})
    public void LowerTest(double expectedX) {
        assertEquals(Math.log(expectedX), ln.ln(expectedX, eps), eps*1000);

    }
    @ParameterizedTest
    @ValueSource(doubles = {0.88, 0.10, 0.55, 0.81})
    public void XSolutionTest(double expectedX) {
        double value = ln.ln(expectedX, eps);
        assertEquals(Math.pow(Math.E, value), expectedX, eps*1000);
    }

}
