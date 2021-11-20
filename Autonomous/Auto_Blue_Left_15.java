package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous


public class Auto_Blue_Left_15 extends org.firstinspires.ftc.teamcode.Auto_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes();


        waitForStart();

//        auto_motors.goToSpot(inchToTicks*39,1);
        arm.autoArmUp(2);
        intake.autoEject();
        arm.autoArmDown();



        //raise arm
            //level 1: no strafe
            //level 2: strafe 2" right
            //level 3: strafe 5" right

        //output freight

//        auto_motors.goToSpot(inchToTicks*-18,1);
//        auto_motors.turn90left(1);
//        auto_motors.goToSpot(inchToTicks*36,1);

    }
}