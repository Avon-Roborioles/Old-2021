package org.firstinspires.ftc.teamcode;

public class Mecanum_Methods {





    public Mecanum_Methods(){


    }

    /**
     *
     * @param ly left y power
     * @param lx left
     * @param rx
     * @param right_strafe
     * @return
     */
    public double front_left_power (int ly, int lx, int rx, boolean right_strafe){
        return ly+lx+rx;
    }











}
