import java.lang.Math;

/**
 * @author Nikolai
 */
public class Orientator {

    public double desiredangle, currentangle, relativeAngle, desiredmagnitude, xOutput, yOutput;

    /**
     * You need to know where you're currently facing.
     * @param inputAngle the thing that you want to set as your angle. 
     * You must have an angle from 0 to 360 degrees (not including 360).
     */

    public void setCurrentAngle(double inputAngle) {
        inputAngle = currentangle;
    }
    /**
     * Finds the relative angle for the object to travel towards, so that your motion matches the angle you want.
     * @param x the horizontal input that you give (so, the strafe part)
     * @param y the forward/backwards input that you have.
     * 
     */
    public double getRelativeAngle(double x, double y){
        if(y >= 0){

        desiredangle = Math.atan(x/y);
        }
        
        else {
            desiredangle = Math.atan(x/y) + 180;
        }
        
        relativeAngle = -1*(currentangle + desiredangle);

        if(relativeAngle < 0){
            return relativeAngle + 360;
        }
        else {
        return relativeAngle;
        }
    }


    public double getOutputComponents(double magnitude){

        xOutput = magnitude * Math.cos(desiredangle);
        yOutput = magnitude * Math.sin(desiredangle); 
    }


}