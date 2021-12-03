package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous
//@Disabled
public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(false);

        waitForStart();

        auto_motors.goToSpot((int) (inchToTicks*36), .75);

        Thread.sleep( 10000);
    }

}