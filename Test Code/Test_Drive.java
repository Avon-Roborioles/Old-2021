package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Test_Drive extends OpMode {
    private final org.firstinspires.ftc.teamcode.Distance_Sensor distance_class = new org.firstinspires.ftc.teamcode.Distance_Sensor();

    @Override
    public void init() {
        distance_class.initDistance(hardwareMap);
        telemetry.addData(">>>","Start When Ready");
        telemetry.update();
    }

    @Override
    public void start() {
        telemetry.addData("Status", "Running");
        telemetry.update();
    }

    @Override
    public void loop() {
       distance_class.runDistance(telemetry);

    }
}