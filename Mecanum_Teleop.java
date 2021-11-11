package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp

public class Mecanum_Teleop extends LinearOpMode {

    private org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp drive_motors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp(false);//set false of right strafe
    private org.firstinspires.ftc.teamcode.Carousel_Call carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();

    @Override
    public void runOpMode() throws InterruptedException {
        drive_motors.init_drive_motors(hardwareMap);
        carousel.init_carousel(hardwareMap, "carousel");

        waitForStart();

        while (opModeIsActive() && !this.gamepad1.dpad_down) {

            drive_motors.run_drive_motors(gamepad1, telemetry);
            carousel.run_carousel_loop(gamepad1, telemetry);

        }

    }

}
