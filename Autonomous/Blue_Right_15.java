package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous


public class Blue_Right_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(false);


        waitForStart();
        this.sense_barcode_blue();
        imu_drive.setZero();


        imu_drive.strafeRight(1, 5);
        imu_drive.goToSpot(-9.5, 1);
        imu_drive.strafeLeft(1,1);
        auto_carousel.run_carousel_auto(telemetry, false);
        imu_drive.strafeRight(.75, 12);
        imu_drive.goToSpot(-5, 1);
        imu_drive.strafeRight(.75,15);






    }
}

