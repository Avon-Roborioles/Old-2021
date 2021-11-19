/*
 This is the main driving code for the 2021-2022 14954 Robotics Team

 This code includes all features below:
    - Informs driver/s on current status of the robot (Initialized, running etc.)
    - Passive arm stabilizer with built in encoders (Working on it :) )
    - Advanced Mecanum Driving with the left joystick
    - lifting the main arm with the left & right triggers
    - Spinning the intake with the left & right bumpers
    - Using the carousel with the x and b buttons

 Make sure to setup these device names on the robot:

 Motor Channel:  Front Left drive motor: "fl"
 Motor Channel:  Front right drive motor: "fr"
 Motor Channel:  Back Left drive motor: "bl"
 Motor Channel:  Back Right drive motor "br"
 Motor Channel:  Arm Lift motor "armlift"
 Motor Channel:  Carousel motor "carousel
 CRServo Channel: Claw servo "claw"
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//Tells robot this code is for driving
@TeleOp

public class Teleop_14954V1 extends OpMode {

    //variables for motors and other things
    public DcMotor armlift = null;
    public Servo claw = null;
    boolean using_armlift = false;
    private final org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp drive_class = new org.firstinspires.ftc.teamcode.Mecanum_Methods_TeleOp(false);
    private final org.firstinspires.ftc.teamcode.Carousel_Call carousel_class = new org.firstinspires.ftc.teamcode.Carousel_Call();
    private final org.firstinspires.ftc.teamcode.RoboVision vision_class = new org.firstinspires.ftc.teamcode.RoboVision();
    @Override
    //runs once
    public void init() {

        //setting up motors and other things
        telemetry.addData("Status", "Initializing");
        drive_class.init_drive_motors(hardwareMap);
        armlift = hardwareMap.get(DcMotor.class, "armlift" );
        carousel_class.init_carousel(hardwareMap, "carousel", false);
        claw = hardwareMap.get(Servo.class, "claw");
        //vision_class.initCamera(hardwareMap);
        /*
        sets armlift motor to use the encoder and resets it
        armlift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        */

        //Set other motors to zero power
        armlift.setPower(0);
        armlift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //claw.setPosition(0);

        telemetry.addData(">>", "Start when ready!");
    }

    @Override
    //runs once
    public void start() {
        //
        telemetry.addData("Status", "Running");
    }

    //runs repeatedly
    @Override
    public void loop() {

        drive_class.run_drive_motors(gamepad1, telemetry);
        carousel_class.run_carousel_loop(gamepad1, telemetry);
        //vision_class.runCamera(telemetry);
        telemetry.addData("Armlift Position", armlift.getCurrentPosition());

        //when left trigger is pressed, lift arm up; if right trigger is pressed, bring arm down
        if (gamepad1.left_trigger > 0) {
            using_armlift = true;
            armlift.setPower(0.5);
        } else if (gamepad1.right_trigger > 0) {
            using_armlift = true;
            armlift.setPower(-0.5);
        } else {
            using_armlift = false;
            armlift.setPower(0);
        }

        //when left bumper pressed, intake forward, if right bumper pressed, intake reverse
        if (gamepad1.left_bumper) {
            claw.setPosition(0.8);
        } else if (gamepad1.right_bumper) {
            claw.setPosition(0.3);
        } else {
            claw.setPosition(0);
        }

        //if armlift is done moving, set its position to lock at
        //it will keep trying to get to the set position as long as we don't move it again
        /*
        if (!using_armlift) {
            armlift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armlift.setTargetPosition(armlift.getCurrentPosition());
            armlift.setPower(0.5);
        } else {
            armlift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
            */

        telemetry.update();
    }

    @Override
    public void stop () {
        //
        vision_class.turn_off_camera();
        telemetry.addData(">>", "Nice Job!");
    }
}