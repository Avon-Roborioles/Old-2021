package org.firstinspires.ftc.teamcode;

//STILL A WIP

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
        public boolean yes = false;
        //Max Distance
        private double md = 2.8*12;
        //Distance it sees
        private double dis = 0;
        //Where the position of the duck
        private int pos = 1;
        public void initDistance(HardwareMap hardwareMap) {
                ds1 = hardwareMap.get(Rev2mDistanceSensor.class,"ds1");
        }
        
        public void runDistance(Telemetry telemetry) {
                if(dis<md&&pos!=2) {
                        yes = true;
                }
                else if(pos==1&&!yes) {
                        pos = 0;
                }
                else if(pos==0&&!yes) {
                        pos = 2;
                        yes = true;
                }
                telemetry.addData("Distance", dis);
                telemetry.addData("Position",pos);
                telemetry.addData("Sees it", yes);
        }
}