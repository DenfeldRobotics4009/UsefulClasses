import java.lang.Math;

/**
 * @author Nikolai
 */
public class Orientator {

    public double desiredangle, currentangle, desiredmagnitude;

    /**
     * You need to know where you're facing.
     * @param inputAngle the thing that you want to set as your angle
     */

    public void setCurrentAngle(double inputAngle) {
        inputAngle = currentangle;
    }
    /**
     * Finds the relative angle for the object to travel towards.
     * @param x the horizontal input that you give (so, the strafe part)
     * @param y the forward/backwards input that you have.
     * 
     */
    public double findDesiredAngle(double x, double y){

        desiredangle = Math.atan(x/y);
        
        double relativeAngle = -1*(currentangle + desiredangle);
        
        return relativeAngle;
    }

    public double convertAngle(){
        return -1 * (desiredangle + currentangle);
    }


}