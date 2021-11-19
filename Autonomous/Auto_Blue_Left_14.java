package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        init_classes();

        waitForStart();

        auto_motors.goToSpot(inchToTicks * 8, 1);
    }
}

//            if(auto_run_count < 10000) { //not sure how many ticks we want, or if we should do it another way
//                auto_carousel.run_carousel_auto(telemetry);
//                auto_run_count++;
//            } else {
//                auto_carousel.stop_carousel_auto(telemetry);
//            }
//        double auto_run_count = 0;