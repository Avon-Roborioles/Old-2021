package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
//@Disabled????

public class Auto_Red_Right_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(true);

        waitForStart();
        this.sense_barcode();

        this.auto_motors.strafeLeft(1,25);

        this.arm.autoArmUp(2);
        this.turntable.turntable_auto(-90,1);

        this.auto_motors.turn45left(1);

        this.arm.autoArmUp(this.scorePosition);
        if(this.scorePosition==2) {
            this.auto_motors.strafeLeft(1,1);
        } else if(this.scorePosition==3) {
            this.auto_motors.strafeLeft(1,2);
        }







        this.telemetry.update();

        Thread.sleep(5000);
    }
}