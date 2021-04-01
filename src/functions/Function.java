package functions;

import interfaces.*;

public class Function implements IFunction {

    private ICosinusCalculator iCosinusCalculator;
    private ISinusCalculator iSinusCalculator;
    private ISecCalculator iSecCalculator;
    private ICscCalculator iCscCalculator;
    private ILog iLog;

    public Function(ICosinusCalculator iCosinusCalculator,
                    ISinusCalculator iSinusCalculator,
                    ISecCalculator iSecCalculator,
                    ICscCalculator iCscCalculator,
                    ILog iLog) {
        this.iCosinusCalculator = iCosinusCalculator;
        this.iSinusCalculator = iSinusCalculator;
        this.iSecCalculator = iSecCalculator;
        this.iCscCalculator = iCscCalculator;
        this.iLog = iLog;
    }

    @Override
    public double func(double x, double eps) {
        if (x <= 0) {
            return Math.pow((Math.pow(Math.pow(iSecCalculator.sec(x, eps) / iSecCalculator.sec(x, eps), 3), 3) - ((iSinusCalculator.sin(x, eps) + iCscCalculator.csc(x, eps)) * (iSecCalculator.sec(x, eps) / iCosinusCalculator.cos(x, eps)))), 3);
        }

        double result = Math.pow(iLog.log(x, 3, eps), 3);
        result += (iLog.log(x, 10, eps) / iLog.log(x, 10, eps));
        result = Math.pow(result, 2);
        result -= Math.pow(iLog.log(x, 2, eps) / iLog.log(x, 5, eps), 2);
        result /= iLog.log(x, 3, eps) / iLog.log(x, 2, eps);
        return result;
    }
}
