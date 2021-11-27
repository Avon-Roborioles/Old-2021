package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp

public class Teleop_14954 extends LinearOpMode {

    //objects for each function of the robot
    private final org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp drivingMotors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp(false);
    private final org.firstinspires.ftc.teamcode.Carousel_Call carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();
    private final org.firstinspires.ftc.teamcode.Arm_14954 armlift = new org.firstinspires.ftc.teamcode.Arm_14954();
    private final org.firstinspires.ftc.teamcode.Intake_14954 intake = new org.firstinspires.ftc.teamcode.Intake_14954();


    @Override
    public void runOpMode() throws InterruptedException {
        drivingMotors.init_drive_motors(hardwareMap);
        carousel.init_carousel(hardwareMap, "carousel", true);
        armlift.init_armlift(hardwareMap, "armlift");
        intake.init_intake(hardwareMap, "intake");
        telemetry.addData(">>", "Start when ready!");


        waitForStart();

        while (opModeIsActive()) {
            //Driver 1 Functions
            drivingMotors.run_drive_motors(gamepad1, telemetry); //driving
            carousel.run_carousel_loop(gamepad1, telemetry); //carousel
            armlift.run_arm(gamepad1, telemetry); //arm
            intake.run_intake(gamepad1, telemetry); //intake

            telemetry.update();
        }
    }
}
