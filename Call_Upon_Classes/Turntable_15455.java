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


    public void init_turntable(HardwareMap map, String name) {
        turntable = map.get(CRServo.class, name);

    }

    public void run_turntable(Gamepad gamepad1, Telemetry telemetry) {
        double turn_right = gamepad1.right_trigger;
        double turn_left = gamepad1.left_trigger;

        if (turn_left>0) {
            turntable.setPower( -turn_left*.8 );
        } else if (turn_right>0) {
            turntable.setPower( turn_right*.8 );
        } else {
            turntable.setPower(0);
        }




        get_telemetry(telemetry);
    }



    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("turntable power", turntable.getPower());

    }
}
