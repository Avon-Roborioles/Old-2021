package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Carousel_Increment extends OpMode {
    private DcMotor carousel = null;
    private double carouselStartSpeed = 0.37; //base speed
    private double carouselIncrSpeed = carouselStartSpeed; //speed as carousel is running and increasing
    private double displayFinalSpeed = carouselIncrSpeed; //for display
    
    private double incrAmt = 0.0008; //as carousel runs, increases by this value (.08%)

    //prevents over-increase from one press - one press doesn't increase/decrease it fifteen times, just once
    private boolean incrementWasPressed = false;
    private boolean decrementWasPressed = false;

    //used for backpedaling at the end
    private boolean carouselMoving = false;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        carousel  = hardwareMap.get(DcMotor.class, "carousel");
    }

    @Override
    public void loop() {
        //checks to see if you've pressed incr/dcr
        //and if you did, checks that you're not still pressing it
        //(prevents over-increase/decrease)
        if(incrementWasPressed && !gamepad1.y) {
            incrAmt += 0.0001;
            incrementWasPressed = false;
        }
        if(decrementWasPressed && !gamepad1.a) {
            incrAmt -= 0.0001;
            decrementWasPressed = false;
        }

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

        //sets that incr/dcr is being pressed
        if (gamepad1.y) {
            incrementWasPressed = true;
        } else if (gamepad1.a) {
            decrementWasPressed = true;
        }

        //min/max - if exceed, then resets to min or max
        if(carouselStartSpeed > 0.6) {
            carouselStartSpeed = 0.6;
        } else if (carouselStartSpeed < 0) {
            carouselStartSpeed = 0;
        }

        telemetry.addData("End Ramp Speed", displayFinalSpeed);
        telemetry.addData("Incr Amt", incrAmt);
        telemetry.addData("Carousel Speed", "Speed = " + carouselStartSpeed);
        telemetry.addData("Carou Encoder", "Current Pos = " + carousel.getCurrentPosition());
        telemetry.update();
    }
}
