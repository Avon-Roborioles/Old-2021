package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous


public class Auto_Blue_Left_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(false);


        waitForStart();

        this.sense_barcode();


        auto_motors.goToSpot(inchToTicks*40, 1);
        arm.autoArmUp(3);
        turntable.turntable_auto(90, .75);

        //go to actual level
        arm.autoArmUp(this.scorePosition);
        auto_motors.strafeRight(1, 7); //make this dependent a bit on which level?

        intake.autoEject();
        turntable.turntable_auto(-90,-.75);
        arm.autoArmDown();
        auto_motors.turn90left(.75);
        auto_motors.goToSpot(30*inchToTicks, 1);



        while (opModeIsActive()) {}

    }
}