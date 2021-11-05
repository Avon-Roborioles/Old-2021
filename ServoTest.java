package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp

public class ServoTest extends LinearOpMode {
    private CRServo rm = null;

    @Override

    public void runOpMode() {
        rm = hardwareMap.get(CRServo.class, "rm");
        waitForStart();
        while (opModeIsActive()) {
            rm.setPower(.75);
        }
    }
}
