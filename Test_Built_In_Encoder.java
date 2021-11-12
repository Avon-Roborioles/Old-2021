package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Test_Built_In_Encoder extends LinearOpMode {
    private DcMotor motor = null;

    @Override
    public void runOpMode() {
        motor = hardwareMap.get(DcMotor.class, "fr");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setTargetPosition(1120);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        while (opModeIsActive()) {
            while (motor.isBusy()) {
                motor.setPower(.5);

                telemetry.addData("Target", motor.getTargetPosition());
                telemetry.addData("Current pos", motor.getCurrentPosition());
                telemetry.update();
            }
            motor.setPower(0);
        }

    }
}