package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//Drives straight to warehouse area

@Autonomous
public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(false);

        waitForStart();

        imu_drive.setZero();

        auto_motors.goToSpot(35, .75);

        imu_drive.strafeRight(.75, 30);


       Thread.sleep( 10000);
    }

}