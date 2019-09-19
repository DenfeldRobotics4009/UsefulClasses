import java.lang.Math;

/**
 * @author Nikolai
 */
public class Orientator {

    public double desiredAngle, currentAngle, relativeAngle, desiredMagnitude, xOutput, yOutput;

    /**
     * You need to know where you're currently facing.
     * @param inputAngle the thing that you want to set as your angle. 
     * You must have an angle from 0 to 360 degrees (not including 360).
     */

    public void setCurrentAngle(double inputAngle) {
        inputAngle = currentAngle;
    }
    /**
     * Finds the relative angle for the object to travel towards, so that your motion matches the angle you want.
     * @param x the horizontal input that you give (so, the strafe part)
     * @param y the forward/backwards input that you have.
     * 
     */
    public double getRelativeAngle(double x, double y){
        if(y >= 0){

        desiredAngle = Math.atan(x/y);
        }
        
        else {
            desiredAngle = Math.atan(x/y) + 180;
        }
        
        relativeAngle = desiredAngle - currentAngle;

        if(relativeAngle < 0){
            return relativeAngle + 360;
        }
        else {
        return relativeAngle;
        }
    }

    /**
     * Running this function will produce x and y components that you can plug into a drive system.
     * After running this command, the variables xOutput and yOutput can be used for your own purposes.
     * 
     * @param magnitude how much power you want to put in from 0-1. 
     */
    public void getOutputComponents(double magnitude){

        xOutput = magnitude * Math.cos(relativeAngle);
        yOutput = magnitude * Math.sin(relativeAngle); 
    }


}