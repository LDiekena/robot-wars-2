package org.example.Server.Controller;

import org.example.Client.View.*;
import org.example.Server.Model.Battlefield;
import org.example.Server.Model.Robot;

public class GameController {

    public void playerTurn(Robot currentRobot, Robot enemyRobot, MoveRobotView moveRobotView, BattlefieldController battlefieldController, RobotController robotController, BattlefieldView battlefieldView, Battlefield battlefield) {
        int moveCounter = currentRobot.getMovementRate();

        while (moveCounter > 0) {

            //Bewegungszug
            char moveChoice = moveRobotView.printTurnMessageAndAskInput(currentRobot);

            if (battlefieldController.isMoveValid(currentRobot, moveChoice, battlefield)) {
                robotController.move(moveChoice, currentRobot, battlefield, battlefieldController);
                moveCounter--;

                moveRobotView.printPlayerTurnMessage(currentRobot);
                battlefieldView.printBattlefield(battlefield);
            } else {
                moveRobotView.printErrorMoveMessage();
            }
            /*
            //Angriffszug
            if(battlefieldController.robotInAttackRange(currentRobot, enemyRobot, battlefield)) {
                robotController.attack(currentRobot, enemyRobot);
                moveCounter = 0; //Wenn Angriff ausgeführt wird Zug beendet auch wenn noch Züge übrig wären
            }

             */
        }
        currentRobot.setTurn(false);
        enemyRobot.setTurn(true);
    }

}


