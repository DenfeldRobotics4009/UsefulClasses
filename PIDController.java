
import edu.wpi.first.wpilibj.Timer;

public class PIDController {
    
    
    /**
     * @author Nikolai (AdmiralTryhard)
     * If you don't know what a PID controller is, then you should come back and learn about them separately.
     */
    
    public double num1 = 0;
    public double num2 = 0;
    public double pvalue = 0;
    public double ivalue = 0;
    public double dvalue = 0;
    public Timer startcorrect = new Timer();
    public double aceptederror = 0;
    public double kP;
    public double kI;
    public double kD;
    public double input;
    public double target;
    public double tolerance;
    public double last_error = 0;

    /**
     * this is what you need to set up the PID controller. You must use this method before doing anything else.
     * @param kP Proportional
     * @param kI Integral
     * @param kD Derivative
     */
    public PIDController(double kP, double kI, double kD){
        kP = this.kP;
        kI = this.kI;
        kD = this.kD;
        
    }
    /**
     * this function tells the pid controller where you want your number to be
     * @param target this is where you're trying to get the input to.
     * @param input The number you are trying to control with the PID loop
     *
     */
    public void Set(double target, double input){
        target = this.target;
        input = this.input;
    }

    /**
     * Use this if you want to set a tolerance on your pidcontroller
     * @param tolerance the number you want to allow for a maximum tolerance
     */
    public void setTolerance(double tolerance){
        tolerance = this.tolerance;
    }

    /**
     * this is where the PID value is calculated and used at your discretion
     * @param maximumoutput based on your number being controlled, you may want to set limits (1 is a typical limit as it represents 100% power)
     * @param minimumoutput this is essentially the same as the maximum, but likely in the opposite direction (-1 is the typical limit as -1 represents 100% power in the opposite direction)
     * 
     */
    public double calculate(double maximumoutput, double minimumoutput){
        double error = target - input;
        double final_value;

        pvalue = error * kP;

        dvalue = kD * (error - last_error)/0.05;

        if(last_error * error <= 0){
            ivalue = 0;
        }
        else {
            ivalue += (error * 0.05 * kI);
        }
        last_error = error;

        if(Math.abs(error) < tolerance){
            final_value = 0;
        }
        else{
        final_value = pvalue + ivalue + dvalue;
        }
        if(final_value >= maximumoutput){
            return maximumoutput;
        }
        else if(final_value <= minimumoutput){
            return minimumoutput;
        }
        else {
            return final_value;
        }
    }

    /**
     * 
     * This is a commonly used team function that allows for full manual control when you wish to input it. Otherwise, a timer will go off to check.
     * After a short period of time, the PID Controller will act to maintain the last known input when you had manual control.
     * DOUBLE CHECK that the manual input affects the number that you set as the input for the PID Controller. 
     * Otherwise, you may be in for a wacky ride.
     * @param manualinput this is the number of an variable that you could get from manual control. Like, say 
     * for a motor, this might be a speed variable you get from a joystick or other source outside of this PID controller.
     * The input from configure earlier will be used as your set point as things go along.
     * @param maximumoutput if your output can't exceed a certain number, set this to that number so things won't go over 100%
     * @param minimuminput same as above, but in the opposite direction
     *
     */
    public double semiAutomate(double manualinput, double maximumoutput, double minimumoutput){
        PIDController autocorrect = new PIDController(kP, kI, kD);

        startcorrect.start();

        if (Math.abs(manualinput) > 0){
            autocorrect.Set(input, input);
            startcorrect.reset();
            return manualinput;
        }
        else if (startcorrect.get() < 0.33){
            return 0;
        }
        else {
            return autocorrect.calculate(maximumoutput, minimumoutput);
        }
    }

}   