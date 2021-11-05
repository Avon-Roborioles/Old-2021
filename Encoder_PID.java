package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous

public class Encoder_PID extends LinearOpMode {
    private DcMotor motor = null;

    private double position = 0;
    private double max_power = .01;


    @Override
    public void runOpMode() {
        motor = hardwareMap.dcMotor.get("fr");
        position = motor.getCurrentPosition();

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        move_via_encoder(1880);

        sleep(5000);
    }

    public void move_via_encoder(int position) {
        motor.setTargetPosition(position);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor.setPower(max_power);

        while(opModeIsActive() && motor.isBusy()) {
            telemetry.addData("Target", position);
            telemetry.addData("Current Pos", motor.getCurrentPosition());
            telemetry.addData("Power", motor.getPower());
            telemetry.addData("Direction", motor.getDirection());
            telemetry.update();
        }

        //reset
        motor.setPower(0);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Complete", "done");
        telemetry.update();
    }
}
