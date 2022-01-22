package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//Drives straight to warehouse area


@Autonomous


public class Auto_Red_Right_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {


        this.init_classes(true);

        waitForStart();

        auto_motors.goToSpot(36, .75);

        auto_motors.strafeLeft(.75,35);

        auto_motors.turn45left(.6);


        Thread.sleep( 10000);
    }

}