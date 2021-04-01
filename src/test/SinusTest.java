package test;

import functions.SinusCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SinusTest {

    public final static double eps = 0.0001;

    @Before
    public void init(){
        SinusCalculator bs = new SinusCalculator();

    }
    @ParameterizedTest
    @ValueSource(doubles = {0.322 * Math.PI, 1 / 4 * Math.PI, 1 / 2 * Math.PI,-0.4 * Math.PI})
    private void UpTest(double expectedX){
        SinusCalculator bs = new SinusCalculator();
        assertEquals(Math.sin(expectedX), bs.sin(expectedX, eps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.3 * Math.PI, 1.25 * Math.PI, Math.PI, 1.5 * Math.PI, 0.75 * Math.PI})
    public void DownTest(double expectedX){
        SinusCalculator bs = new SinusCalculator();
        assertEquals(Math.sin(expectedX), bs.sin(expectedX, eps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.664 * Math.PI, -0.25 * Math.PI, Math.PI, 0.111 * Math.PI})
    public void RepeatTest(double expectedX){
        SinusCalculator bs = new SinusCalculator();
        assertEquals(Math.sin(expectedX), bs.sin(expectedX, eps), eps);
        assertEquals(bs.sin(expectedX, eps),bs.sin(expectedX+2*Math.PI, eps), eps);
        assertEquals(bs.sin(expectedX, eps),bs.sin(expectedX-2*Math.PI, eps), eps);
    }

    @Test
    public void ZeroTest(){
        double expectedX = 0;
        SinusCalculator bs = new SinusCalculator();
        assertEquals(Math.sin(expectedX), bs.sin(expectedX, eps), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {Math.PI, -Math.PI, 0.5 * Math.PI, -1.5 * Math.PI})
    public void BoundTest(double expectedX){
        SinusCalculator bs = new SinusCalculator();
        assertEquals(Math.sin(expectedX), bs.sin(expectedX, eps), eps);
    }

}
