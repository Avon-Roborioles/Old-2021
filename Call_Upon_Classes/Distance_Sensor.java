package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
public class Distance_Sensor {
        //the sensor
        private Rev2mDistanceSensor ds1 = null;
        //variable for if it sees it
        private boolean yes = false;
        //Max Distance
        private double md = 2.8*12;
        //Distance it sees
        private double d = 0;

        public void initDistance(HardwareMap hardwareMap) {
                ds1 = hardwareMap.get(Rev2mDistanceSensor.class,"ds1");
        }
        
        public void runDistance(Telemetry telemetry) {
                if(d<md){
                        yes = true;
                }
                telemetry.addData("Distance", d);
                telemetry.addData("Sees it", yes);
                telemetry.update();
        }
}