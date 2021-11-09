/*
 This is the main driving code for the 2021-2022 14954 Robotics Team

 This code includes all features below:
    - Informs driver/s on current status of the robot (Initialized, running etc.)
    - Passive arm stabilizer with built in encoders
    - Advanced Mecanum Driving with the left joystick
    - lifting the main arm with the left & right triggers
    - opening and closing the claw with the left & right bumpers

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
import com.qualcomm.robotcore.hardware.CRServo;

//Tells robot this code is for driving
@TeleOp

public class MainDrivingCode extends OpMode {

    //variables for motors and other things
    public DcMotor fl = null;
    public DcMotor fr = null;
    public DcMotor bl = null;
    public DcMotor br = null;
    public DcMotor armlift = null;
    public DcMotor carousel = null;
    public CRServo claw = null;
    double ltrigger;
    double rtrigger;
    boolean lbumper;
    boolean rbumper;
    boolean x_button;
    double left_x = 0;
    double left_y = 0;
    double right_x = 0;
    boolean using_armlift = false;

    @Override
    public void init() {
        //setting up motors and other things
        telemetry.addData("Status", "Initializing");
        fl  = hardwareMap.get(DcMotor.class, "fl");
        fr  = hardwareMap.get(DcMotor.class, "fr");
        bl  = hardwareMap.get(DcMotor.class, "bl");
        br  = hardwareMap.get(DcMotor.class, "br");
        armlift = hardwareMap.get(DcMotor.class, "armlift" );
        carousel  = hardwareMap.get(DcMotor.class, "carousel");
        claw = hardwareMap.get(CRServo.class, "claw");

        //sets armlift motor to use the encoder and resets it
        armlift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armlift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //sets left motors direction backwards (for driving)
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);

        //Set all motors to zero power
        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);
        armlift.setPower(0);
        carousel.setPower(0);
        claw.setPower(0);

        telemetry.addData(">>", "Start when ready!");
    }

    @Override
    public void start() {
        //
        telemetry.addData("Status", "Running");
    }

    @Override
    public void loop() {

        //Renames left joystick axis
        left_x = this.gamepad1.left_stick_x; //strafe
        left_y = -1 * this.gamepad1.left_stick_y;
        right_x = this.gamepad1.right_stick_x; //turn

        //Updates variables
        ltrigger = gamepad1.left_trigger;
        rtrigger = gamepad1.right_trigger;

        lbumper = gamepad1.left_bumper;
        rbumper = gamepad1.right_bumper;

        x_button = gamepad1.x;

        //main code for driving
            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(left_y) + Math.abs(left_x) + Math.abs(right_x), 1);
            double frontLeftPower = (left_y + left_x + right_x) / denominator;
            double backLeftPower = (left_y - left_x + right_x) / denominator;
            double frontRightPower = (left_y - left_x - right_x) / denominator;
            double backRightPower = (left_y + left_x - right_x) / denominator;

            fl.setPower(frontLeftPower);
            fr.setPower(frontRightPower);
            br.setPower(backRightPower);
            bl.setPower(backLeftPower);


        //when left trigger is pressed, lift arm up; if right trigger is pressed, bring arm down
        if (ltrigger > 0) {
            using_armlift = true;
            armlift.setPower(0.5);
        } else if (rtrigger > 0) {
            using_armlift = true;
            armlift.setPower(-0.5);
        } else {
            using_armlift = false;
            armlift.setPower(0);
        }

        if (lbumper) {
            claw.setPower(0.5);
        } else if (rbumper) {
            claw.setPower(-0.5);
        } else {
            claw.setPower(0);
        }

        /*
        if armlift is done moving, set its position to lock at
        it will keep trying to get to the set position as long as we don't move it again

        if (!using_armlift) {
            armlift.setTargetPosition(armlift.getCurrentPosition());
            armlift.setPower(0.5);
            armlift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        } else {
            armlift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
        */

        if (x_button) {
            carousel.setPower(0.5);
        } else {
            carousel.setPower(0);
        }
    }

    @Override
    public void stop () {
        //
        telemetry.addData(">>", "Nice Job!");
    }
}