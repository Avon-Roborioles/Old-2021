import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorAdafruitRGB;
import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;


@TeleOp

public class CarouselSpinTest extends LinearOpMode {


    // variable for Carousel Motor
    private DcMotor carousel = null;
    //end of setting up variables
    @Override

    public void runOpMode () throws InterruptedException {

        //finds motors from the control hub to use
        carousel = hardwareMap.get(DcMotor.class, "carousel");

        //waits for you to press start on phone
        waitForStart();

        while (opModeIsActive()) {

            // if press x, spin carousel for this many seconds
            if (gamepad1.x) {
                carousel.setPower(0.75);
                //Make it wait before it stops the motor
                Thread.sleep(1250);
                carousel.setPower(0);
            }
            // if x isn't pressed, make sure the motor isn't running
            else {
                carousel.setPower(0);
            }

        }
    }



}
