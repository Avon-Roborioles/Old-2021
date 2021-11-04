package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp

public class new_mecanum extends LinearOpMode {
    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;
    //private CRServo s1 = null;
    private double left_x = 0;
    private double left_y=0;
    private double right_x = 0;
    org.firstinspires.ftc.teamcode.Mecanum_Methods test = new org.firstinspires.ftc.teamcode.Mecanum_Methods(false);//set false of right strafe

    @Override
    public void runOpMode() throws InterruptedException {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive() && !this.gamepad1.dpad_down){
            left_x = this.gamepad1.left_stick_x; //turn
            left_y = -1 * this.gamepad1.left_stick_y;
            right_x = this.gamepad1.right_stick_x; //strafe
            test.update(left_y,left_x,right_x);


            fl.setPower(test.fl_power());
            fr.setPower(test.fr_power());
            br.setPower(test.br_power());
            bl.setPower(test.bl_power());


            telemetry.addData("fl power: ",fl.getPower());
            telemetry.addData("fr power: ",fr.getPower());
            telemetry.addData("bl power: ",bl.getPower());
            telemetry.addData("br power: ",br.getPower());
            telemetry.update();

        }
        telemetry.clearAll();
        telemetry.addLine("Code force stopped");
        telemetry.update();
    }




    //    double r = Math.hypot(left_x, left_y);
    //    double robotAngle = Math.atan2(left_y, left_x) /*- Math.PI / 4*/;
    //    double rightX = gamepad1.right_stick_x;
    //    final double v1 = r * Math.sin(robotAngle) - rightX;
    //    final double v2 = r * Math.cos(robotAngle) + rightX;
    //    final double v3 = r * Math.cos(robotAngle) - rightX;
    //    final double v4 = r * Math.sin(robotAngle) + rightX;




}
