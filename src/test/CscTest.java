package test;

import functions.CscCalculator;
import functions.SinusCalculator;
import interfaces.ICscCalculator;
import interfaces.ISinusCalculator;
import mocks.SinMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CscTest {
    private final static double eps = 0.0001;
    private static ICscCalculator csc;

    @BeforeAll
    private static void init() {
        ISinusCalculator sinusCalculator = new SinMock();
        csc = new CscCalculator(sinusCalculator);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.444 * Math.PI, -0.25 * Math.PI, -0.75 * Math.PI, -0.81 * Math.PI})
    public void UpTest(double expectedX) {
        assertEquals(1.0 / Math.sin(expectedX), csc.csc(expectedX, eps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.75 * Math.PI, 0.45 * Math.PI, 0.33 * Math.PI, 0.1 * Math.PI, 0.7 * Math.PI})
    public void DownTest(double expectedX) {
        assertEquals(1.0 / Math.sin(expectedX), csc.csc(expectedX, eps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.664 * Math.PI, -0.33 * Math.PI, 0.111 * Math.PI, Math.PI * 0.25})
    public void RepeatTest(double expectedX) {
        assertEquals(1.0 / Math.sin(expectedX), csc.csc(expectedX, eps), eps);
        assertEquals(csc.csc(expectedX, eps), csc.csc(expectedX + 2 * Math.PI, eps), eps);
        assertEquals(csc.csc(expectedX, eps), csc.csc(expectedX - 2 * Math.PI, eps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI, -Math.PI, 0})
    public void BoundTest(double expectedX) {
        assertEquals(NaN, csc.csc(expectedX, eps), eps);
    }

}