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
    private double speed;
    

    public void init_armlift (HardwareMap map, String name1, String name2) {
        armlift1  = map.get(DcMotor.class, name1);
        armlift2  = map.get(DcMotor.class, name2);
    }
    
    
    
    
    
    
      //Test method for normal armlift operation + Passive motor position holder  
      public void init_armliftv2 (HardwareMap map, String name1, String name2) {
        //names motors for configurations
        armlift1  = map.get(DcMotor.class, name1);
        armlift2  = map.get(DcMotor.class, name2);

        //


        //sets current motor encoder values to zero (resets)
        armlift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armlift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        //tells motors to go to target position and hold it (key to position holder)
        armlift1.setTargetPosition(0);
        armlift2.setTargetPosition(0);
          
        armlift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armlift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       
        //maximum power robot can use to move and adjust armlift
        armlift1.setPower(1);
        armlift2.setPower(1);
    }

    
    
    
    
    
    public void run_arm (Gamepad gp, Telemetry telemetry) {

        double ltrigger = gp.left_trigger;
        double rtrigger = gp.right_trigger;
        
        if (ltrigger > 0) {
            speed = 1;
        } else if (rtrigger > 0 ) {
            speed = -1;
        } else {
            speed = 0;
        }

        armlift1.setPower(speed);
        armlift2.setPower(speed);

        get_telemetry(telemetry);
    }
    
    
    
    
    
    
    //Test method for normal armlift operation + Passive motor position holder  
    public void run_armv2 (Gamepad gp, Telemetry telemetry) {
        
        double ltrigger = gp.left_trigger;
        double rtrigger = gp.right_trigger;
        
        //moves armlift up
        if (ltrigger > 0) {
            
            armlift1.setTargetPosition( armlift1.getCurrentPosition() + 5 ); //change number if needed
            armlift2.setTargetPosition( armlift2.getCurrentPosition() + 5 ); //change number if needed
         
        //moves armlift down
        } else if (rtrigger > 0 ) {
            
            armlift1.setTargetPosition( armlift1.getCurrentPosition() - 5 ); //change number if needed
            armlift2.setTargetPosition( armlift2.getCurrentPosition() - 5 ); //change number if needed
            
        }

        
        get_telemetry(telemetry);
    }   

    
    
    
    
    
    
    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("Armlift Speed", speed);
    }

}
