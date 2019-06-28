public class DeadZoneTuner{

/**
 * 
 * @author Nikolai
 * 
 * This should handle customizations (especially for deadzones) that one may want to use on items that have a scale range
 * This should also be able to handle any additional scaling outside of the deadzones.
 */

 /**
 * adjustForDeadzone is entirely meant for the deadzone to be used, and it automatically utilizes a previously derived math equation
 * to start
 * @param input
 * @param minimumrange
 * @param maximumrange
 * @param deadzone
 * @param isInverted just to quickly
 * 
 */

    public double adjustForDeadzone(double tobescaled, double minimumrange, double maximumrange, double deadzone, boolean isInverted){
        double result;
        if(Math.abs(input) <= deadzone){
            result = 0;
        }
        else{
            result = Math.signum(input) *((Math.abs(input) - deadzone) *(1/(1 - deadzone)));
        }
        if (isInverted){
            return result * -1;
        }
        else{
        return result;
        }
    }
    /**WIP
     * 
     */
    public void changescale(double input, double minimumscale, double maximumscale, boolean override){
        double output;
        if(override){
            output = 1;
        }
        else{
            output = idk yet;
        }
    }
}