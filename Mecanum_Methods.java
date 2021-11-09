package org.firstinspires.ftc.teamcode;

public class Mecanum_Methods {

    private boolean strafe;
    private int strafe_set=1;

    //right == 1
    //left  == -1
    private double denominator;
    private double ly;
    private double lx;
    private double rx;

    /**
     *
     * @param right_strafe if you want right strafe set true, left set false
     */
    public Mecanum_Methods(boolean right_strafe){
    strafe=right_strafe;
    if (strafe)
        strafe_set = 1;
    else
        strafe_set = -1;

    }


    public void update(double l_y, double l_x, double r_x){
        ly=l_y;
        lx=l_x;
        rx=r_x;
        denominator = Math.abs(l_y)+Math.abs(l_x)+Math.abs(r_x);
    }



    /**
     *
     * @return returns the power for your front left motor
     */
    public double fl_power (){
        return (ly+lx+rx)/denominator;
    }
    /**
     *
     * @return returns the power for your back left motor
     */
    public double bl_power (){
        return (ly+lx*strafe_set-rx*strafe_set)/denominator;
    }

    /**
     *
     * @return returns the power for your front right motor
     */
    public double fr_power (){
        return (ly-lx-rx)/denominator;
    }

    /**
     *
     * @return returns the power for your back right motor
     */
    public double br_power (){
        return (ly-lx*strafe_set+rx*strafe_set)/denominator;
    }
}
