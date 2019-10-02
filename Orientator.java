import java.lang.Math;

/**
 * @author Nikolai
 * This is my solution to the whole field-oriented drive problem  You have to get an angle relative to your current, and get the components for that relative motion in order to use in a traditional drive.
 * This class handles all of the math needed, with exceptions included.
 */
public class Orientator {

    public double desiredAngle, currentAngle, relativeAngle, desiredMagnitude, xOutput, yOutput;

    /**
     * You need to know where you're currently facing.
     * @param inputAngle the thing that you want to set as your angle. 
     * You must have an angle from -2pi to 2pi. If the angle is < 0 rad, This function will just add 2 pi to it.
     */

    public void setCurrentAngle(double inputAngle) {
        if (inputAngle < 0){
            currentAngle = inputAngle + (Math.PI * 2);
        }
        else {
            currentAngle = inputAngle;
        }
    }
  

    /**
     * you need to first use SetCurrentAngle() before doing this. This will make the xOutput and yOutput into usable variables
     * 
     * @param magnitude how fast you want to be going
     * @param angle (in radians) that you want to be heading towards.
     */
    public void getComponents(double magnitude, double angle){
       
        relativeAngle = angle - currentAngle;
        
        if(relativeAngle < 0){
        desiredAngle = relativeAngle + (Math.PI * 2);
        }
        else {
        desiredAngle = relativeAngle;
        }

        xOutput = magnitude * Math.cos(desiredAngle);
        yOutput = magnitude * Math.sin(desiredAngle); 
    }
}