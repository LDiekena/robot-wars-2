package org.example.Server.Controller;

import org.example.Server.Model.Battlefield;
import org.example.Server.Model.Robot;

import java.util.Random;

public class BattlefieldController {

    //Methode für zufällige Zeile
    public int randomNumberRow() {
        Random r = new Random();
        return r.nextInt(9);
    }

    //Methode für zufällige Spalte
    public int randomNumberColumn() {
        Random r = new Random();
        return r.nextInt(14);
    }

    //Generiere leeres Spielfeld
    public void fillBattlefield(Battlefield battlefield) {
        for (int i = 0; i < battlefield.getMap().length; i++) {
            battlefield.getMap()[i] = " [ ]";

        }
    }

    public int getRobotPositionOnBattlefield(Robot robot, Battlefield battlefield) {
        return robot.getY() * battlefield.getWidth() + robot.getX();
    }

    //Platziere Spieler und Gegner auf dem Spielfeld
    public void placeRobots(Robot player1, Robot player2,Battlefield battlefield) {
        for (int i = 0; i < battlefield.getMap().length; i++) {
            battlefield.getMap()[getRobotPositionOnBattlefield(player1, battlefield)] = " [" + player1.getSymbol() + "]";

        }

        for (int i = 0; i < battlefield.getMap().length; i++) {
            if (player1.getY() == player2.getY() && player1.getX() == player2.getX()) {
                player2.setX(player2.getX() + 1);
                player2.setY(player2.getY() + 1);
                battlefield.getMap()[getRobotPositionOnBattlefield(player2, battlefield)] = " [" + player2.getSymbol() + "]";
            } else {
                battlefield.getMap()[getRobotPositionOnBattlefield(player2, battlefield)] = " [" + player2.getSymbol() + "]";
            }
        }
    }

    //Methode Zuggültigkeit
    public boolean isMoveValid(Robot robot, char turnInput, Battlefield battlefield) {
        int robotPosition = robot.getY() * battlefield.getWidth() + robot.getX();
        if (robotPosition <= battlefield.getMap().length && robotPosition >= (battlefield.getMap().length - battlefield.getWidth()) && turnInput == '2') {
            return false;
        } else if (robotPosition <= (battlefield.getWidth()) && robotPosition >= 0 && turnInput == '8') {
            return false;
        } else if ((robotPosition % battlefield.getWidth()) == (battlefield.getWidth() - 1) && turnInput == '6') {
            return false;
        } else if ((robotPosition % battlefield.getWidth()) == 0 && turnInput == '4') {
            return false;
        } else if (turnInput != '2' && turnInput != '4' && turnInput != '5' && turnInput != '6' && turnInput != '8') {
            return false;
        } else {
            return true;
        }
    }

    //TODO: Bugfix Reichweite auch bei range > 1
    //Methode Gegner ist in Angriffsreichweite
    public boolean robotInAttackRange(Robot currentRobot, Robot enemyRobot, Battlefield battlefield) {
        int diff = Math.abs(getRobotPositionOnBattlefield(currentRobot, battlefield) - getRobotPositionOnBattlefield(enemyRobot, battlefield));
        if (diff <= (currentRobot.getAttackRange() * battlefield.getWidth() + currentRobot.getAttackRange()) &&
                diff >= (currentRobot.getAttackRange() * battlefield.getWidth() - currentRobot.getAttackRange()) || diff <= currentRobot.getAttackRange()) {
            return true;
        } else {
            return false;
        }
    }

}
