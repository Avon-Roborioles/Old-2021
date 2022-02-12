package org.firstinspires.ftc.teamcode.2021.AutoStateMachines;

import org.firstinspires.ftc.teamcode.State;
import java.util.ArrayList;

public class StateController {

    public ArrayList<ArrayList<State>> allStates;
    ArrayList<State> currentStates;
    int nextStateNum = 0;

    public void getStates(ArrayList<ArrayList<State>> states) {
        this.allStates = states;
    }

    public void changeState() {
        currentStates = allStates.get(nextStateNum);
        nextStateNum += 1;
    }

    public void runStates() {
        while (nextStateNum < allStates.size()){
            changeState();
            for(int i = 0; i < currentStates.size(); i++) {
                currentStates.get(i).start();
            }
            while(!currentStates.isEmpty()) {
                for(int i = 0; i < currentStates.size(); i++) {
                    if(currentStates.get(i).checkDone()) {
                        currentStates.get(i).stop();
                    }
                }
            }
//            while (!currentState.checkDone()) {}
//            currentState.stop();
        }
    }


}