package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous


public class Auto_Blue_Right_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(false);


        waitForStart();
        this.sense_barcode_blue();


        auto_motors.strafeRight(1, 5);
        auto_motors.goToSpot((int) (-inchToTicks * 11), 1);
        auto_motors.strafeLeft(1,1);
        auto_carousel.run_carousel_auto(telemetry, false);
        auto_motors.strafeRight(1, 12);
        auto_motors.goToSpot(-inchToTicks * 7, 1);
        auto_motors.strafeRight(1, 18);
        auto_motors.goToSpot(-inchToTicks * 7, 1);


    }
}

