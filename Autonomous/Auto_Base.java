package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class Auto_Base extends LinearOpMode {
    protected org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus auto_motors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus();
    protected org.firstinspires.ftc.teamcode.Carousel_Call auto_carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();

    public void init_classes() {
        auto_motors.init_auto_drive_motors(hardwareMap);
        auto_carousel.init_carousel(hardwareMap, "carousel", false);
    }
}