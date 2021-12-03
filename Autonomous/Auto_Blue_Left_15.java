package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous


public class Auto_Blue_Left_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(false);


        waitForStart();

        this.sense_barcode_blue();


        auto_motors.goToSpot(-inchToTicks*14, 1);
        auto_motors.strafeRight(1, 18);
        arm.autoArmUp(2);
        turntable.turntable_auto(80, .5);

        arm.autoArmUp(scorePosition);

        if(scorePosition==1){
            auto_motors.strafeRight(.75,3.5);
        }else if (scorePosition==2) {
            auto_motors.strafeRight(.75,4);
        }else{
            auto_motors.strafeRight(.75, 7);
        }
        intake.autoEject();
        if(scorePosition==1){
            auto_motors.strafeLeft(.75,3.5);
        }else if (scorePosition==2) {
            auto_motors.strafeLeft(.75,4);
        }else{
            auto_motors.strafeLeft(.75, 7);
        }
        arm.autoArmUp(2);
        turntable.turntable_auto(-80, -.5);
        arm.autoArmDown();

        auto_motors.strafeLeft(1,19);
        auto_motors.goToSpot(inchToTicks*55,1);



        while (opModeIsActive()) {}

    }
}