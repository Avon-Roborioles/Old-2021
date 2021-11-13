package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Turntable_15455 {
    private CRServo turntable = null;
    private double speed;

    public void init_turntable(HardwareMap map, String name) {
        turntable = map.get(CRServo.class, name);
    }

    public void run_turntable(Gamepad gamepad1, Telemetry telemetry) {
        boolean dpad_right = gamepad1.dpad_right;
        boolean dpad_left = gamepad1.dpad_left;

        if (dpad_left) {
            speed = -0.5;
        } else if (dpad_right) {
            speed = 0.5;
        } else {
            speed = 0;
        }

        turntable.setPower(speed);


        get_telemetry(telemetry);
    }



    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("turntable power", turntable.getPower());

    }
}
