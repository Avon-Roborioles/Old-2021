package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base {

    @Override
    public void runOpMode() throws InterruptedException {
        distance_sensor.initDistance(hardwareMap, telemetry, false);

        init_classes();

        waitForStart();

        int scorePosition = 3; //furthest to the right, won't be changed if it doesn't see 1 or 2

        if(distance_sensor.checkSeesSomething()) {
            scorePosition = 2;
        }
        auto_motors.goToSpot(inchToTicks * 8, 1);

        if(distance_sensor.checkSeesSomething()) {
            scorePosition = 1;
        }

        telemetry.addData("Final Scoring Position Found: ", scorePosition);
        telemetry.update();
        //done sensing barcode :)

        //move X inches to carousel
        //turn somehow to be on the far end of carousel
        //run carousel

        Thread.sleep(5000);
    }
}

//            if(auto_run_count < 10000) { //not sure how many ticks we want, or if we should do it another way
//                auto_carousel.run_carousel_auto(telemetry);
//                auto_run_count++;
//            } else {
//                auto_carousel.stop_carousel_auto(telemetry);
//            }
//        double auto_run_count = 0;