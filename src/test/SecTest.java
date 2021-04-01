package test;

import functions.CosinusCalculator;
import functions.SecCalculator;
import functions.SinusCalculator;
import interfaces.ICosinusCalculator;
import interfaces.ISecCalculator;
import interfaces.ISinusCalculator;
import mocks.CosMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecTest {

    private final static double eps = 0.0001;
    private static ISecCalculator sec;

    @BeforeAll
    private static void init(){
        ICosinusCalculator cosinusCalculator = new CosMock();
        sec = new SecCalculator(cosinusCalculator);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.444*Math.PI,-0.25*Math.PI, -0.75*Math.PI,-0.81*Math.PI})
    public void UpTest(double expectedX){
        assertEquals(1.0/Math.cos(expectedX), sec.sec(expectedX, eps), eps);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.75*Math.PI, 0.45*Math.PI, 0.33*Math.PI, 0.1*Math.PI, 0.7*Math.PI})
    public void DownTest(double expectedX){
        assertEquals(1.0/Math.cos(expectedX), sec.sec(expectedX, eps), eps);

    }
    @ParameterizedTest
    @ValueSource(doubles = {0.664*Math.PI, -0.33*Math.PI, Math.PI, 0.111*Math.PI, Math.PI*0.25})
    public void RepeatTest(double expectedX){
        assertEquals(1.0/Math.cos(expectedX), sec.sec(expectedX, eps), eps);
        assertEquals(sec.sec(expectedX, eps),sec.sec(expectedX+2*Math.PI, eps), eps);
        assertEquals(sec.sec(expectedX, eps),sec.sec(expectedX-2*Math.PI, eps), eps);

    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5 * Math.PI, -1.5 * Math.PI})
    public void BoundTest(double expectedX){
        assertEquals(NaN, sec.sec(expectedX, eps), eps);
    }


}

