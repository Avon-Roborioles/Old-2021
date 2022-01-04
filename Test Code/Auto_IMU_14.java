package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Auto_IMU_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(false);

        imu_drive.setZero();
        waitForStart();

        imu_drive.strafeLeft(30, .75);

        Thread.sleep(1000);
    }
}