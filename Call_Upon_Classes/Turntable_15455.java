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
        double turn_right = gamepad1.right_trigger;
        double turn_left = gamepad1.left_trigger;

        if (turn_left-.1>0) {
            speed = -turn_left+.1;
        } else if (turn_right-.1>0) {
            speed = turn_right-.1;
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
