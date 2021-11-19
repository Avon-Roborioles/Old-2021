package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_14954 {
    private DcMotor intake = null;
    private double speed;

    public void init_intake(HardwareMap map, String name) { intake  = map.get(DcMotor.class, name); }


    public void run_intake(Gamepad gamepad1, Telemetry telemetry) {

        boolean x = gamepad1.x;
        boolean b = gamepad1.b;

        if (x) {
            speed = 1;
        } else if (b) {
            speed = -1;
        } else {
            speed = 0;
        }

        intake.setPower(speed);

        get_telemetry(telemetry);
    }


    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Intake Speed", speed);
    }
}