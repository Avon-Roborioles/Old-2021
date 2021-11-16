package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Arm_15455{
    private DcMotor arm = null;
    private double speed;




    public void init_arm(HardwareMap map, String name) { arm  = map.get(DcMotor.class, name); }

    public void run_arm(Gamepad gamepad1, Telemetry telemetry) {

        boolean dpad_up = gamepad1.dpad_up;
        boolean dpad_down = gamepad1.dpad_down;

        if (dpad_up) {
            speed = 0.75;
        } else if (dpad_down) {
            speed = -0.75;
        } else {
            speed = 0;
        }

        arm.setPower(speed);

        get_telemetry(telemetry);
    }



    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Arm Speed", speed);
    }
}
