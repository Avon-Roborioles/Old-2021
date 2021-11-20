package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Arm_14954 {

    private DcMotor armlift = null;
    private double speed;

    public void init_armlift (HardwareMap map, String name) { armlift  = map.get(DcMotor.class, name); }

    public void run_arm(Gamepad gamepad1, Telemetry telemetry) {

        double ltrigger = gamepad1.left_trigger;
        double rtrigger = gamepad1.right_trigger;
        
        if (ltrigger > 0) {
            speed = 0.5;
        } else if (rtrigger > 0 ) {
            speed = -0.5;
        } else {
            speed = 0;
        }

        armlift.setPower(speed);

        get_telemetry(telemetry);
    }

    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Arm Speed", speed);
    }

}