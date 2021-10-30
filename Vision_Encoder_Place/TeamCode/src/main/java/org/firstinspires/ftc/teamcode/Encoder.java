package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous

public class Encoder extends LinearOpMode {
    private DcMotor motor = null;
    //Encoder Position
    private double enc_pos = 0;
    //Ticks per rotation
    private double tpr = 8192;
    //Quarter rotation
    private double qr = tpr/4;
    //Motor Position
    private double m_pos = 0;
    //Number of rotations
    private double num_rot = 0;
    //Power
    private double pwr = .001;
    //phase
    int phase=0;

    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.dcMotor.get("fr");
        enc_pos = motor.getCurrentPosition();

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);






        telemetry.addData("Position", enc_pos);
        telemetry.addData("Quarter Position",qr);
        telemetry.addData("Ticks Per Rotation", tpr);
        telemetry.addData("Motor Power",pwr);
        telemetry.update();

        waitForStart();
        boolean ranOnce = false;


        while (opModeIsActive()) {
            motor.setPower(1);
            if(!ranOnce) {
                Thread.sleep(5000);
            }
            ranOnce = true;
            m_pos = motor.getCurrentPosition();
            telemetry.addData("Position", m_pos);
            telemetry.addData("Quarter Position",qr);
            telemetry.addData("Ticks Per Rotation", tpr);
            telemetry.addData("encoder read", (m_pos/22.7)%360);
            telemetry.update();
            if (Math.abs((m_pos/22.7)%360) >= 180 && Math.abs((m_pos/22.7)%360) <= 185) {
                motor.setPower(0);
                Thread.sleep(5000);
                break;
            }
        }
    }

}
