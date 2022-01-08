package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous
public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(false);

        waitForStart();

        auto_motors.goToSpot((int) (inchToTicks * -25), .75);

        auto_motors.strafeLeft(30, .75);

        //armlifts.arm_auto(1);
       Thread.sleep( 10000);
    }

}