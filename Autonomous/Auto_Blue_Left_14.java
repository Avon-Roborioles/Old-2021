package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base {

    @Override
    public void runOpMode() throws InterruptedException {

        org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus drivingCode = new org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus();
       drivingCode.init_auto_drive_motors(hardwareMap);

        waitForStart();

        drivingCode.setTargetAll(200);
        drivingCode.setPowerAll(0.7);

        drivingCode.getTelemetry(telemetry);

        telemetry.update();
    }
}

//            if(auto_run_count < 10000) { //not sure how many ticks we want, or if we should do it another way
//                auto_carousel.run_carousel_auto(telemetry);
//                auto_run_count++;
//            } else {
//                auto_carousel.stop_carousel_auto(telemetry);
//            }
//        double auto_run_count = 0;