package org.firstinspires.ftc.teamcode.2021.AutoStateMachines;

public interface State {

    public void start();
    public boolean checkDone();
    public void stop();

}