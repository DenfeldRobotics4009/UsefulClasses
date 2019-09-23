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
            currentangle = inputAngle + (Math.PI * 2);
        }
        else {
            currentangle = inputAngle;
        }
    }
  

    /**
     * you need to first use SetCurrentAngle() before 
     * @param magnitude
     * @param angle
     */
    public void getComponents(double magnitude, double angle){
       

        relativeAngle = angle - currentangle;
        
        if(relativeAngle < 0){
        desiredangle = relativeAngle + (Math.PI * 2);
        }
        else {
        desiredangle = relativeAngle;
        }

        xOutput = magnitude * Math.cos(desiredangle);
        yOutput = magnitude * Math.sin(desiredangle); 
    }

    


    


}