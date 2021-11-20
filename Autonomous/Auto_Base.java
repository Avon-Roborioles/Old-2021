package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class Auto_Base extends LinearOpMode {
    protected org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus auto_motors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus();
    protected org.firstinspires.ftc.teamcode.Carousel_Call auto_carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();
    protected org.firstinspires.ftc.teamcode.Distance_Sensor distance_sensor = new org.firstinspires.ftc.teamcode.Distance_Sensor();
    protected org.firstinspires.ftc.teamcode.Arm_15455 arm = new org.firstinspires.ftc.teamcode.Arm_15455();
    protected org.firstinspires.ftc.teamcode.Intake_15455 intake = new org.firstinspires.ftc.teamcode.Intake_15455();

    protected int inchToTicks = 91;


    public void init_classes() {
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        auto_carousel.init_carousel(hardwareMap, "carousel", false);
        arm.init_arm(hardwareMap, "arm");
        intake.init_intake(hardwareMap, "intake");
    }
}