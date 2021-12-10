package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous


public class Auto_Blue_Left_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    private org.firstinspires.ftc.teamcode.Mecanum_IMU imu_motors = new org.firstinspires.ftc.teamcode.Mecanum_IMU();

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(false);
        imu_motors.init_auto_drive_motors(hardwareMap, telemetry);

        waitForStart();
//        arm.autoArmUp(3);
//        turntable.turntable_auto(90,.5);
        while(opModeIsActive()) {
            imu_motors.run_motors();
        }








//        this.sense_barcode_blue();
//
//
//        auto_motors.goToSpot(-inchToTicks*10, 1);
//        auto_motors.strafeRight(1, 26);
//        arm.autoArmUp(2);
//        turntable.turntable_auto(80, .5);
//
//        arm.autoArmUp(scorePosition);
//
//        if(scorePosition==1){
//            auto_motors.strafeRight(.75,5);
//        }else if (scorePosition==2) {
//            auto_motors.strafeRight(.75,6.5);
//        }else{
//            auto_motors.strafeRight(.75, 8.5);
//        }
//        intake.autoEject();
//        if(scorePosition==1){
//            auto_motors.strafeLeft(.75,5);
//        }else if (scorePosition==2) {
//            auto_motors.strafeLeft(.75,6.5);
//        }else{
//            auto_motors.strafeLeft(.75, 8.5);
//        }
//        arm.autoArmUp(2);
//        turntable.turntable_auto(-87, -.5);
//        arm.autoArmDown();
//
//        auto_motors.strafeLeft(1,29);
//        auto_motors.goToSpot(inchToTicks*55,1);
//




    }
}