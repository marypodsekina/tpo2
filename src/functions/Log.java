package functions;

import interfaces.ILn;
import interfaces.ILog;

public class Log implements ILog {

    private ILn iLn;

    public Log(ILn iLn) {
        this.iLn = iLn;
    }

    @Override
    public double log(double x, double a, double eps) {
        return iLn.ln(x, eps)/iLn.ln(a, eps) ;
    }

}
