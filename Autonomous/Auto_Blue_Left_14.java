package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous
@Disabled
public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(false);

        waitForStart();

//        imu_drive.goToSpot((int) (36), .75);

        //imu_drive.strafeLeft(30, .75);

        armlifts.arm_auto(3);
        Thread.sleep( 10000);
    }

}