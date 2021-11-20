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
    private Telemetry telemetry = null;


    private void init_drive_motors(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);
    }
    /*
    the circumference of the wheel is 12.57 in
    belt ration is 1:1
    1 rotation is 1440 ticks
    thus 1440 ticks is 12.57 in
    91 ticks is approx 1 inch
    */
    public void init_auto_drive_motors(HardwareMap hardwareMap, Telemetry telemetry) {
        init_drive_motors(hardwareMap);
        this.telemetry = telemetry;
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

    public void setRelativeTargetAll(int target) {
        fl.setTargetPosition(fl.getCurrentPosition() + target);
        bl.setTargetPosition(bl.getCurrentPosition() + target);
        fr.setTargetPosition(fr.getCurrentPosition() + target);
        br.setTargetPosition(br.getCurrentPosition() + target);
    }

    public void setTargetIndividual(int fl_target, int bl_target, int fr_target, int br_target){
        fl.setTargetPosition(fl_target);
        bl.setTargetPosition(bl_target);
        fr.setTargetPosition(fr_target);
        br.setTargetPosition(br_target);
    }

    public void setRelativeTargetIndividual(int fl_target, int bl_target, int fr_target, int br_target) {
        fl.setTargetPosition(fl_target + fl.getCurrentPosition());
        bl.setTargetPosition(bl_target + bl.getCurrentPosition());
        fr.setTargetPosition(fr_target + fr.getCurrentPosition());
        br.setTargetPosition(br_target + br.getCurrentPosition());
    }

    public void setPowerAll(double power) {
        fl.setPower(power);
        bl.setPower(power);
        fr.setPower(power);
        br.setPower(power);
    }

    public void setPowerIndividual(double FL, double FR, double BR, double BL){
        fl.setPower(FL);
        br.setPower(BR);
        bl.setPower(BL);
        fr.setPower(FR);

    }

    public void goToSpot(int target, double power){
        setRelativeTargetAll(target);
        setPowerAll(power);
        while (isBusy()){}
    }

    public void turn90left (int power){
        setRelativeTargetAll((int) Math.floor(-1440*1.5));
        setPowerIndividual(-1*power,1*power,1*power,-1*power);
        while (isBusy()){}
    }

    public boolean isBusy (){
//        getTelemetry(telemetry);

        if (fl.isBusy()||fr.isBusy()||br.isBusy()||bl.isBusy())
            return true;
        else
            return false;
    }



    public void getTelemetry (Telemetry telemetry){
        telemetry.addData("fl encoder value: ",fl.getCurrentPosition());
        telemetry.addData("fr encoder value: ",fr.getCurrentPosition());
        telemetry.addData("bl encoder value: ",bl.getCurrentPosition());
        telemetry.addData("br encoder value: ",br.getCurrentPosition());
    }
}
