package test;

import functions.CosinusCalculator;
import functions.SinusCalculator;
import interfaces.ICosinusCalculator;
import interfaces.ISinusCalculator;
import mocks.SinMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosinusTest {

    private final static double eps = 0.0001;
    private static ICosinusCalculator cos;

    @BeforeAll
    private static void init(){
        ISinusCalculator sinusCalculator = new SinMock();
        cos = new CosinusCalculator(sinusCalculator);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.4 * Math.PI, -0.25 * Math.PI, -0.75 * Math.PI, -0.8 * Math.PI})
    public void UpTest(double expectedX){
        assertEquals(Math.cos(expectedX), cos.cos(expectedX, eps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.75 * Math.PI, 0.456 * Math.PI, 0.3 * Math.PI, 0.1 * Math.PI, 0.7 * Math.PI})
    public void DownTest(double expectedX){
        assertEquals(Math.cos(expectedX), cos.cos(expectedX, eps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.664 * Math.PI, -0.25 * Math.PI, Math.PI, 0.111 * Math.PI})
    public void RepeatTest(double expectedX){
        assertEquals(Math.cos(expectedX), cos.cos(expectedX, eps), eps);
        assertEquals(cos.cos(expectedX, eps),cos.cos(expectedX + 2 * Math.PI, eps), eps);
        assertEquals(cos.cos(expectedX, eps),cos.cos(expectedX - 2 * Math.PI, eps), eps);

    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI, -Math.PI, 0.5*Math.PI,-1.5*Math.PI})
    public void BoundTest(double expectedX){
        assertEquals(Math.cos(expectedX), cos.cos(expectedX, eps), eps);
    }

}
