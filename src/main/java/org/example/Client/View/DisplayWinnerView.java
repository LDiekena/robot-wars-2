package org.example.Client.View;

import org.example.Server.Model.Robot;

public class DisplayWinnerView {
    public void printWinner (Robot currrentRobot, Robot enemyRobot) {
        System.out.println(currrentRobot.getName() + " hat " + enemyRobot.getName() + " besiegt, herzlichen Glückwunsch!");
    }
}
