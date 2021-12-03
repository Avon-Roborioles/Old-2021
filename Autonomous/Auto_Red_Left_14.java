package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;


@Autonomous
@Disabled
public class Auto_Red_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(true);

        waitForStart();

       // this.sense_barcode();

        auto_motors.strafeLeft(.80,5);


        auto_motors.goToSpot((int) (-inchToTicks*30), .75);

        auto_motors.turn90left(1);

       auto_carousel.run_carousel_auto(telemetry,true);
       // auto_motors.strafeLeft(.75, 10);
       // auto_motors.goToSpot(-inchToTicks*9,.75);
       // auto_motors.strafeLeft(.75, 15);








        Thread.sleep(10000);
    }
}