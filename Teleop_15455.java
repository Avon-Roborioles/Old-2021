package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp

public class Teleop_15455 extends LinearOpMode {

    private org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp drive_motors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp(true);//set false for left strafe
    private org.firstinspires.ftc.teamcode.Carousel_Call carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();
    private org.firstinspires.ftc.teamcode.Turntable_15455 turntable = new org.firstinspires.ftc.teamcode.Turntable_15455();
    private org.firstinspires.ftc.teamcode.Arm_15455 arm = new org.firstinspires.ftc.teamcode.Arm_15455();
    private org.firstinspires.ftc.teamcode.Intake_15455 intake = new org.firstinspires.ftc.teamcode.Intake_15455();


    @Override
    public void runOpMode() throws InterruptedException {
        drive_motors.init_drive_motors(hardwareMap);
        //carousel.init_carousel(hardwareMap, "carousel");
        turntable.init_turntable(hardwareMap, "turntable");
        intake.init_intake(hardwareMap, "intake");
        arm.init_arm(hardwareMap, "arm");

        waitForStart();

        while (opModeIsActive()) {
            drive_motors.run_drive_motors(gamepad1, telemetry);
            //carousel.run_carousel_loop(gamepad1, telemetry);
            //turntable.run_turntable(gamepad1, telemetry);
            intake.run_intake(gamepad1, telemetry);
            arm.run_arm(gamepad1, telemetry);

            telemetry.update();
        }
    }

}
