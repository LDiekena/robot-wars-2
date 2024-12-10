package org.example.Server.Controller;

import org.example.Server.Model.Battlefield;
import org.example.Server.Model.Robot;
import org.example.Client.View.DisplayRobotStatsView;

public class RobotController {
    //Methode zur Abfrage ob Usereingabe gültig ist
    public boolean isValidAttribute(int attributeChoice) {
        if (attributeChoice >= 1 && attributeChoice <= 4) {
            return true;
        } else {
            return false;
        }
    }

    //Methode zur Rückgabe eines Attributes anhand der Usereingabe
    public int getAttribute(int input, Robot player) {
        if (input == 1) {
            return player.getHealth();
        } else if (input == 2) {
            return player.getAttackDamage();
        } else if (input == 3) {
            return player.getAttackRange();
        } else if (input == 4) {
            return player.getMovementRate();
        }  else {
            return 0;
        }
    }

    //Methode Skillsteigerung
    public void skillIncrease(int attribute, int numberToIncrease, Robot player, DisplayRobotStatsView displayRobotStatsView) {
        if (attribute == 1) {
            player.setHealth(player.getHealth() + numberToIncrease);
            player.setSkillpoints(player.getSkillpoints() - numberToIncrease);
        } else if (attribute == 2) {
            player.setAttackDamage(player.getAttackDamage() + numberToIncrease);
            player.setSkillpoints(player.getSkillpoints() - numberToIncrease);
        } else if (attribute == 3) {
            player.setAttackRange(player.getAttackRange() + numberToIncrease);
            player.setSkillpoints(player.getSkillpoints() - numberToIncrease);
        } else if (attribute == 4) {
            player.setMovementRate(player.getMovementRate() + numberToIncrease);
            player.setSkillpoints(player.getSkillpoints() - numberToIncrease);
        } else {
            displayRobotStatsView.printErrorIncreaseOrDecreaseAndAskAgain();
        }
    }

    //Methode Skillminderung
    public void skillDecrease(int attribute, int numberToDecrease, Robot player, DisplayRobotStatsView displayRobotStatsView) {
        if (attribute == 1) {
            player.setHealth(player.getHealth() - numberToDecrease);
            player.setSkillpoints(player.getSkillpoints() + numberToDecrease);
        } else if (attribute == 2) {
            player.setAttackDamage(player.getAttackDamage() - numberToDecrease);
            player.setSkillpoints(player.getSkillpoints() + numberToDecrease);
        } else if (attribute == 3) {
            player.setAttackRange(player.getAttackRange() - numberToDecrease);
            player.setSkillpoints(player.getSkillpoints() + numberToDecrease);
        } else if (attribute == 4) {
            player.setMovementRate(player.getMovementRate() - numberToDecrease);
            player.setSkillpoints(player.getSkillpoints() + numberToDecrease);
        }  else {
            displayRobotStatsView.printErrorIncreaseOrDecreaseAndAskAgain();
        }
    }

    //Methode zur Skillveränderung
    public void changeStats(Robot player, DisplayRobotStatsView displayRobotStatsView) {
        //Eingabe Attributauswahl
        int attributeAuswahl = displayRobotStatsView.askPlayerWhichAttribute();

        //Wiederholung der Eingabe Attributauswahl falls diese falsch ist
        while (!isValidAttribute(attributeAuswahl)) {
            attributeAuswahl = displayRobotStatsView.printErrorInputAttributeChoiceAndAskAgain();
        }

        //Eingabe Steigerung oder Senkung
        char attributChangeType = displayRobotStatsView.askIncreaseOrDecrease();

        //Wiederholung der Eingabe Steigerung/ Senkung falls diese falsch ist
        while (attributChangeType != '+' && attributChangeType != '-') {
            attributChangeType = displayRobotStatsView.printErrorIncreaseOrDecreaseAndAskAgain();
        }

        //Eingabe Veränderungswert
        int numberToChange = displayRobotStatsView.askNumberForSkillchange();

        //Wiederholung der Eingabe je nach Fehlerfall
        while (numberToChange > player.getSkillpoints() && attributChangeType == '+' || attributChangeType == '-' && getAttribute(attributeAuswahl, player) == 1 ||
                attributChangeType == '-' && getAttribute(attributeAuswahl, player) - numberToChange < 1) {

            //Abfrage Eingabe übersteigt Skillpunkte
            if (numberToChange > player.getSkillpoints() && attributChangeType == '+') {
                displayRobotStatsView.printErrorInputHigherThanSkillpointsAndAskAggain();

                //Abfrage gewähltes Attribut hat bereits Minimalwert
            } else if (attributChangeType == '-' && getAttribute(attributeAuswahl, player) == 1) {
                displayRobotStatsView.printErrorAtributeIsMinimalAndAskAgain();
                attributChangeType = '+'; //Veränderung der Auswahl da keine Senkung möglich

                //Abfrage Senkung unterschreitet nicht den Minimalwert
            } else if (attributChangeType == '-' && getAttribute(attributeAuswahl, player) - numberToChange < 1) {
                displayRobotStatsView.printErrorInvalidDecreaseAndAskAgein();
            }
        }

        //Wertsteigerung des Attributes
        if (attributChangeType == '+') {
            skillIncrease(attributeAuswahl, numberToChange, player, displayRobotStatsView);
            displayRobotStatsView.printSkillIncreaseSuccessful(numberToChange);
            displayRobotStatsView.printStats(player);

            //Wertminderung des Attributes
        } else if (attributChangeType == '-') {
            skillDecrease(attributeAuswahl, numberToChange, player, displayRobotStatsView);
            displayRobotStatsView.printSkillDecreaseSuccessful(numberToChange);
            displayRobotStatsView.printStats(player);

            //Fehler Skillchange
        } else {
            displayRobotStatsView.printErrorSkillchange();
        }
    }

    public void move(char moveInput, Robot robot, Battlefield battlefield, BattlefieldController battlefieldController) {
        battlefield.getMap()[battlefieldController.getRobotPositionOnBattlefield(robot, battlefield)] = " [ ]";

        if (moveInput == '8') {
            robot.setY(robot.getY() - 1);
            battlefield.getMap()[battlefieldController.getRobotPositionOnBattlefield(robot, battlefield)] = " [" + robot.getSymbol() + "]";
        } else if (moveInput == '4') {
            robot.setX(robot.getX() - 1);
            battlefield.getMap()[battlefieldController.getRobotPositionOnBattlefield(robot, battlefield)] = " [" + robot.getSymbol() + "]";
        } else if (moveInput == '5') {
            battlefield.getMap()[battlefieldController.getRobotPositionOnBattlefield(robot, battlefield)] = " [" + robot.getSymbol() + "]";
        } else if (moveInput == '6') {
            robot.setX(robot.getX() + 1);
            battlefield.getMap()[battlefieldController.getRobotPositionOnBattlefield(robot, battlefield)] = " [" + robot.getSymbol() + "]";
        } else if (moveInput == '2') {
            robot.setY(robot.getY() + 1);
            battlefield.getMap()[battlefieldController.getRobotPositionOnBattlefield(robot, battlefield)] = " [" + robot.getSymbol() + "]";
        }
    }
}
