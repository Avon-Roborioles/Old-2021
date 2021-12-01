package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
//@Disabled?????

public class Auto_Blue_Right_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(false);

        waitForStart();
        this.sense_barcode();

        //move into position

        auto_carousel.run_carousel_auto(telemetry,false);


//        this.auto_motors.strafeRight(1,25);




        Thread.sleep(5000);
    }
}