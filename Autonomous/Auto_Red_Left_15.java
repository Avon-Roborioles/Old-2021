package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
@Disabled
public class Auto_Red_Left_15 extends org.firstinspires.ftc.teamcode.Auto_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes();
        double auto_run_count = 0;

        waitForStart();

        while(opModeIsActive()) {
            if(auto_run_count < 10000) { //not sure how many ticks we want, or if we should do it another way
                auto_carousel.run_carousel_auto(telemetry);
                auto_run_count++;
            } else {
                auto_carousel.stop_carousel_auto(telemetry);
            }

        }




    }
}