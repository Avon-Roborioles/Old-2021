package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.ArrayList;
import org.firstinspires.ftc.teamcode.State;
import org.firstinspires.ftc.teamcode.StateController;

//Drives straight to warehouse area

@Autonomous
public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(false);

        StateController sc = new StateController();
        ArrayList<State> states = new ArrayList<State>();
        //populate states
        states.add(new State() {

            @Override
            public void start() {

            }

            @Override
            public boolean checkDone() {
                return false;
            }

            @Override
            public void stop() {

            }
        });
        sc.getStates(states);

        waitForStart();

        sc.runStates();

//        do {
//            auto_motors.goToSpot(50, .7);
//            auto_carousel.carousel_auto_SM(telemetry);
//        } while(auto_motors.isBusy());
//
//        auto_motors.stopMotors();
//        auto_carousel.carousel_auto_SM_stop();




       Thread.sleep( 10000);
    }

}