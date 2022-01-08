package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//Runs carousel program and parks

@Autonomous
//@Disabled
public class Auto_Red_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(true);

        waitForStart();

        // this.sense_barcode();

        auto_motors.strafeLeft(0.8, 6);
        auto_motors.goToSpot((int) (-25), .75);

        auto_carousel.run_carousel_auto(telemetry,true);

        auto_motors.strafeLeft(0.75, 25);
        auto_motors.goToSpot((int) (-9), .75);

        Thread.sleep(10000);
    }
}