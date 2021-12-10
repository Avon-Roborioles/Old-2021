package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class Mecanum_IMU {

    private DcMotor fl = null, fr = null, bl = null, br = null;
    private Telemetry telemetry = null;
    private BNO055IMU imu;

    double globalAngle, correction, power = .2;
    Orientation lastAngles = new Orientation();

    public void init_auto_drive_motors(HardwareMap hardwareMap, Telemetry telemetry) {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);
        init_IMU(hardwareMap);
    }

    private void init_IMU(HardwareMap hardwareMap) {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    public void run_motors_forward() {
        correction = checkDirection();

        fl.setPower(power - correction);
        bl.setPower(power - correction);
        fr.setPower(power + correction);
        br.setPower(power + correction);
    }

    public void setRelativeTargetIndividual(int fl_target, int bl_target, int fr_target, int br_target) {
        fl.setTargetPosition(fl_target + fl.getCurrentPosition());
        bl.setTargetPosition(bl_target + bl.getCurrentPosition());
        fr.setTargetPosition(fr_target + fr.getCurrentPosition());
        br.setTargetPosition(br_target + br.getCurrentPosition());
    }

    public void setPowerIndividual(double FL, double FR, double BR, double BL){
        fl.setPower(FL);
        br.setPower(BR);
        bl.setPower(BL);
        fr.setPower(FR);
    }

    public void strafeLeft(double inches, double power) {
        //107 ticks= 1 inch
        inches*=107;
        setRelativeTargetIndividual((int)-inches,(int) inches,(int)inches,(int)-inches);

        while (isBusy()) {
            correction = checkDirection();

            if(correction > 0) { //positive
                fl.setPower(-1 * (power + correction));
                bl.setPower(power - correction);
                fr.setPower(power - correction);
                br.setPower(-1 * (power + correction));
            } else { //negative
                fl.setPower(-1 * (power - correction));
                bl.setPower(power + correction);
                fr.setPower(power + correction);
                br.setPower(-1 * (power - correction));
            }
        }
    }

    private double getAngle() {
        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        double deltaAngle = angles.firstAngle - lastAngles.firstAngle;

        if(deltaAngle < -180) {
            deltaAngle += 360;
        } else if (deltaAngle > 180) {
            deltaAngle -= 360;
        }

        globalAngle += deltaAngle;

        lastAngles = angles;

        return globalAngle;
    }

    private double checkDirection() {
        double correction, gain = .1;

        correction  = -1 * getAngle(); //opposite of where we're currently heading
        correction *= gain; //......idk

        return correction;
    }


    public boolean isBusy (){
//        getTelemetry(telemetry);
        int totalBusy=0;
        if (fl.isBusy())
            totalBusy++;
        if (bl.isBusy())
            totalBusy++;
        if (br.isBusy())
            totalBusy++;
        if (fr.isBusy())
            totalBusy++;

        if (totalBusy>=4)
            return true;
        else
            return false;
    }

    
}