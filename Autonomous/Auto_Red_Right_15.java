package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous


public class Auto_Red_Right_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(true);


        waitForStart();


        auto_motors.goToSpot(inchToTicks*40, 1);
        arm.autoArmUp(3);
        turntable.turntable_auto(-90, -.75);

        arm.autoArmUp(scorePosition);
        auto_motors.strafeLeft(1, 7);

        intake.autoEject();
        turntable.turntable_auto(90,.75);
        arm.autoArmDown();
        auto_motors.turn90right(.75);
        auto_motors.goToSpot(30*inchToTicks, 1);




        while (opModeIsActive()) {}

    }
}