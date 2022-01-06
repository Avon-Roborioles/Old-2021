package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;


@Autonomous

@Disabled
public class Auto_Blue_Right_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(true);

        waitForStart();

        // this.sense_barcode();

        imu_drive.strafeRight(6, .8);
        imu_drive.goToSpot((int) (-25), .75);

        auto_carousel.run_carousel_auto(telemetry,false);

        imu_drive.strafeRight(30, .75);
        imu_drive.goToSpot((int) (-9), .75);

        Thread.sleep(10000);
    }
}