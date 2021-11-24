package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Impaler_15455 {
    private Servo impaler = null;
    private Telemetry telemetry = null;

    public void init_impaler (HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.impaler = hardwareMap.get(Servo.class, "impaler");
    }

    public void control_impaler (Gamepad gamepad) {
        boolean up = gamepad.b;
        boolean down = gamepad.a;

        if(up) {
            impaler.setPosition(90); //?????
        } else if (down) {
            impaler.setPosition(0);
        }
    }

    public void getTelemetry() {
        telemetry.addData("impaler position", impaler.getPosition());
    }
}