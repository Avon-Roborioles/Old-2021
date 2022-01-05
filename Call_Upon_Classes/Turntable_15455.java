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
    private DcMotor TTEncoder = null;
    private Telemetry telemetry = null;
    public void init_turntable(HardwareMap map, Telemetry telemetry, String name) {
        turntable = map.get(CRServo.class, name);
        TTEncoder = map.get(DcMotor.class, name);
        this.telemetry = telemetry;
    }

    public void run_turntable(Gamepad gamepad1, Telemetry telemetry) {
        double turn_right = gamepad1.right_trigger;
        double turn_left = gamepad1.left_trigger;

        if (turn_left>0&&TTEncoder.getCurrentPosition()>-8000*5) {
            //turntable.setPower( -turn_left*.75);
            TTEncoder.setPower(-.5*turn_left);
        } else if (turn_right>0&&TTEncoder.getCurrentPosition()<8000*5) {
//            turntable.setPower( turn_right*.75);
            TTEncoder.setPower(.5*turn_right);
        } else {
//            turntable.setPower(0);
            TTEncoder.setPower(0);
        }

        get_telemetry(telemetry);
    }

    public void turntable_auto (int deg, double power) {
        TTEncoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        int start_pos = TTEncoder.getCurrentPosition();
        power = Math.min(power,.5);
        TTEncoder.setTargetPosition(deg*(8000/360));
        TTEncoder.setPower(power);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        TTEncoder.setTargetPosition(0);


    }
    public void arm_0 () {
        if (TTEncoder.getCurrentPosition()>0){
            while (TTEncoder.getCurrentPosition()>0)
                turntable.setPower(-.75*.88);

        }
    }
    public void turntable_test () {
        TTEncoder.setPower(.5);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TTEncoder.setPower(-.25/2);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TTEncoder.setPower(0);
    }



    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("turntable power", TTEncoder.getPower());
        telemetry.addData("turntable pos", TTEncoder.getCurrentPosition());
    }













}
