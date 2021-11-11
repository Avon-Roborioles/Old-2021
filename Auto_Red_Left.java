package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous

public class Auto_Red_Left extends LinearOpMode {

    private org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp auto_motors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp(true);
    private org.firstinspires.ftc.teamcode.Carousel_Call auto_carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();

    @Override
    public void runOpMode() throws InterruptedException {
        auto_motors.init_auto_drive_motors(hardwareMap);
        auto_carousel.init_carousel(hardwareMap, "carousel");
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