package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Arm_14954 {

    private DcMotor armlift1 = null;
    private DcMotor armlift2 = null;
    private double speed = .6;
    boolean armholding = false;


    public void init_armlift (HardwareMap map, String name1, String name2) {
        armlift1  = map.get(DcMotor.class, name1);
        armlift2  = map.get(DcMotor.class, name2);

    }
    
    

     // Test method for normal armlift operation + Passive motor position holder
   /*public void init_armliftv2 (HardwareMap map, String name1, String name2) {
       armlift1  = map.get(DcMotor.class, name1);
       armlift2  = map.get(DcMotor.class, name2);

       boolean armholding = false;
   }*/

    
    public void run_arm(Gamepad gp, Telemetry telemetry) {

        double ltrigger = gp.left_trigger;
        double rtrigger = gp.right_trigger;
        
        if (ltrigger > 0) {
            speed = .6;
        } else if (rtrigger > 0 ) {
            speed = -.6;
        } else {
            speed = 0;
        }

        armlift1.setPower(speed);
        armlift2.setPower(speed);

        get_telemetry(telemetry);
    }
    

    //Test method for normal armlift operation + Passive motor position holder
    public void run_armv2 (Gamepad gp, Telemetry telemetry) throws InterruptedException {
        double up = gp.left_trigger;
        double down = gp.right_trigger;
        boolean dpadispressed = gp.dpad_down;


/*        if (up > 0) {
           armlift1.setTargetPosition(armlift1.getCurrentPosition() + 200);
            armlift2.setTargetPosition(armlift2.getCurrentPosition() + 200);
            Thread.sleep(50);
        } else if (down > 0) {
            armlift1.setTargetPosition(armlift1.getCurrentPosition() - 200);
            armlift2.setTargetPosition(armlift2.getCurrentPosition() - 200);
            Thread.sleep(50);
        }*/

        if (up > 0) {
            speed = .6;
        } else if (down > 0 ) {
            speed = -.6;
        } else {
            speed = 0;
        }

        armlift1.setPower(speed);
        armlift2.setPower(speed);

        if (dpadispressed) {

            if (armholding = false) {
                armholding = true;
                armlift1.setTargetPosition(armlift1.getCurrentPosition());
                armlift2.setTargetPosition(armlift2.getCurrentPosition());

                armlift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                armlift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                armlift1.setPower(0.8);
                armlift2.setPower(0.8);
            }

        } else {
            armholding = false;
            armlift1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            armlift2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        get_telemetry(telemetry);

    }


    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Armlift Speed", speed);
    }

}
