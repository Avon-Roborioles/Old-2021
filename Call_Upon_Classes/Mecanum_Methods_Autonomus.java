package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Mecanum_Methods_Autonomus {


    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;


    public void init_drive_motors(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);
    }
    public void init_auto_drive_motors(HardwareMap hardwareMap) {
        init_drive_motors(hardwareMap);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setTargetPosition(0);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setTargetPosition(0);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setTargetPosition(0);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setTargetPosition(0);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }



    public void setTargetAll(int target){
        fl.setTargetPosition(target);
        bl.setTargetPosition(target);
        fr.setTargetPosition(target);
        br.setTargetPosition(target);
    }
    public void setTargetIndividual(int fl_target, int bl_target, int fr_target, int br_target){
        fl.setTargetPosition(fl_target);
        bl.setTargetPosition(bl_target);
        fr.setTargetPosition(fr_target);
        br.setTargetPosition(br_target);
    }


    public void getTelemetry (Telemetry telemetry){
        telemetry.addData("fl power: ",fl.getPower());
        telemetry.addData("fr power: ",fr.getPower());
        telemetry.addData("bl power: ",bl.getPower());
        telemetry.addData("br power: ",br.getPower());
        telemetry.update();
    }







}
