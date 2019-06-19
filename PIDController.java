public class PIDController{
    public double num1 = 0;
    public double num2 = 0;
    public double pvalue = 0;
    public double ivalue = 0;
    public double dvalue = 0;

    /**
     * 
     * @param input The number you are trying to control with the PID loop
     * @param P Proportional
     * @param I Integral
     * @param D Derivative
     */
    public void configure(double input, double P, double I, double D){
        this.input = input;
        this.P = P;
        this.I = I;
        this.D = D;
    }
    /**
     * 
     * @param target this is where you're trying to get the input to.
     */
    public void setTarget(double target){
        this.target = target;
    }
    public void setTolerance(double tolerance){
        this.tolerance = tolerance;
    }

    public double calculate(){
        double error = target - input;
        double last_error;
        double final_value;

        pvalue = error * P;

        dvalue = D * (error - last_error)/0.05;

        if(last_error * error <= 0){
            ivalue = 0;
        }
        else {
            ivalue += (error * 0.05 * I);
        }
        last_error = error;

        if(Math.abs(error) < tolerance){
            final_value = 0;
        }
        else{
        final_value = pvalue + ivalue + dvalue;
        }
        return final_value;

        
    }


}