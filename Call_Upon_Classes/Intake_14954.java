package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake_14954 {
    private DcMotor intake = null;
    private double speed = 0;

    public void init_intake(HardwareMap map, String name) { intake = map.get(DcMotor.class, name); }


    public void run_intake(Gamepad gamepad1, Telemetry telemetry) {

        boolean lbumper = gamepad1.left_bumper;
        boolean rbumper = gamepad1.right_bumper;

        if (lbumper) {
           speed = 0.75;
        } else if (rbumper) {
            speed = -0.75;
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