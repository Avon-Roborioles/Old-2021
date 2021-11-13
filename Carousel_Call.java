package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//hi
public class Carousel_Call{
    private DcMotor carousel = null;
    private double carouselStartSpeed = 0.37; //base speed
    private double carouselIncrSpeed = carouselStartSpeed; //speed as carousel is running and increasing
    private double displayFinalSpeed = carouselIncrSpeed; //for display
    
    private double incrAmt = 0.0008; //as carousel runs, increases by this value (.08%)

    //used for backpedaling at the end
    private boolean carouselMoving = false;

    public void init_carousel(HardwareMap map, String name) { carousel  = map.get(DcMotor.class, name); }

    public void run_carousel_loop(Gamepad gamepad1, Telemetry telemetry) {

        //back-pedals a tiny bit once motor stops running
        //updates the final speed it reached from increments to display
        if(carouselMoving && !gamepad1.x) {
            displayFinalSpeed = carouselIncrSpeed;
            carouselIncrSpeed = carouselStartSpeed;
            carousel.setPower(-0.3);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            carouselMoving = false;
        }

        //controls whether motor is running or not
        //increases pace while pressed
        if (gamepad1.x) {
            carousel.setPower(carouselIncrSpeed);
            carouselIncrSpeed+= incrAmt;
            carouselMoving = true;
        } else {
            carousel.setPower(0);
        }

        //min/max - if exceed, then resets to min or max
        if(carouselStartSpeed > 0.6) {
            carouselStartSpeed = 0.6;
        } else if (carouselStartSpeed < 0) {
            carouselStartSpeed = 0;
        }

        get_telemetry(telemetry);
    }

    public void run_carousel_auto (Telemetry telemetry) {
        carousel.setPower(carouselIncrSpeed);
        carouselIncrSpeed+= incrAmt;

        get_telemetry(telemetry);
    }

    public void stop_carousel_auto (Telemetry telemetry) {
        displayFinalSpeed = carouselIncrSpeed;
        carousel.setPower(-0.3);
        get_telemetry(telemetry);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("End Ramp Speed", displayFinalSpeed);
        telemetry.addData("Incr Amt", incrAmt);
        telemetry.addData("Carousel Speed", "Speed = " + carouselStartSpeed);
        telemetry.addData("Carou Encoder", "Current Pos = " + carousel.getCurrentPosition());

    }
}
