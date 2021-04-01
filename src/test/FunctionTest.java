package test;

import functions.*;
import interfaces.*;
import mocks.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class FunctionTest {

    public final static double eps = 0.0001;

    private static IFunction iFunc;
    private static ICosinusCalculator iCos;
    private static ISecCalculator iSec;
    private static ICscCalculator iCsc;
    private static ILog iLog;
    private static ILn iLn;
    private static ISinusCalculator iSin;

    private static IFunction func;
    private static ICosinusCalculator cos;
    private static ISecCalculator sec;
    private static ICscCalculator csc;
    private static ILog log;
    private static ILn ln;
    private static ISinusCalculator sin;

    @BeforeAll
    public static void init() {
        iSin = new SinMock();
        iLn = new LnMock();
        iCos = new CosMock();
        iSec = new SecMock();
        iCsc = new CscMock();
        iLog = new LogMock();
        iFunc = new Function(iCos, iSin, iSec, iCsc, iLog);

        sin = new SinusCalculator();
        ln = new Ln();
        cos = new CosinusCalculator(sin);
        sec = new SecCalculator(cos);
        csc = new CscCalculator(sin);
        log = new Log(ln);
        func = new Function(cos, sin, sec, csc, log);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.444 * Math.PI, -0.25 * Math.PI})
    public void negative(double h){
        assertEquals(func.func(h, eps), iFunc.func(h,eps), eps*1000);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.75* Math.PI, 0.25 * Math.PI})
    public void positive(double h){
        assertEquals(func.func(h, eps), iFunc.func(h,eps), eps*1000);
    }

    @Test
    public void RootTest(){
        assertEquals(0.000, iFunc.func(3.3391, eps), eps*1000);
    }

}