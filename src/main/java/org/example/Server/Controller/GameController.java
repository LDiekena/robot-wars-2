package org.example.Server.Controller;

import org.example.Client.View.*;
import org.example.Server.Model.Battlefield;
import org.example.Server.Model.Robot;

public class GameController {
    public static void main(String[] args) {

        //Controller
        BattlefieldController battlefieldController = new BattlefieldController();
        RobotController robotController= new RobotController();

        //Model
        Battlefield battlefield = new Battlefield(10,15);
        Robot player1 = new Robot("", battlefieldController.randomNumberRow(), battlefieldController.randomNumberColumn(), 1,1,1,1,10, "X", false);
        Robot player2 = new Robot("", battlefieldController.randomNumberRow(), battlefieldController.randomNumberColumn(), 1,1,1,1,10, "O",false);

        //View
        IntroScreenView introScreenView = new IntroScreenView();
        AskRobotNameView askRobotNameView = new AskRobotNameView();
        BattlefieldView battlefieldView = new BattlefieldView();
        DisplayRobotStatsView displayRobotStatsView = new DisplayRobotStatsView();
        DisplayWinnerView displayWinnerView = new DisplayWinnerView();
        MoveRobotView moveRobotView = new MoveRobotView();

        /*
        //Intro und Spielvorbereitung
        introScreenView.displayIntroScreen();
        player1.setName(askRobotNameView.askPlayerName("Spieler 1"));
        player2.setName(askRobotNameView.askPlayerName("Spieler 2"));

        //Spieler 1 Skillverteilung
        displayRobotStatsView.printStartSkillpointDistributionMessage(player1);
        displayRobotStatsView.printStats(player1);
        while (player1.getSkillpoints() > 0) {
            robotController.changeStats(player1, displayRobotStatsView);
        }
        displayRobotStatsView.printChangeSkillsCompleteMessage(player1);

        //Spieler 2 Skillverteilung
        displayRobotStatsView.printStartSkillpointDistributionMessage(player2);
        displayRobotStatsView.printStats(player2);
        while (player2.getSkillpoints() > 0) {
            robotController.changeStats(player2, displayRobotStatsView);
        }
        displayRobotStatsView.printChangeSkillsCompleteMessage(player2);
         */

        //Spielfeldvorbereitungen
        battlefieldView.printPrepareMessage();
        battlefieldController.fillBattlefield(battlefield);
        System.out.println("Die Position von " + player1.getSymbol() + " ist bei (Z " + (player1.getY() + 1) + "/S " + (player1.getX() + 1) + ").");
        System.out.println("Die Position von " + player2.getSymbol() + " ist bei (Z " + (player2.getY() + 1) + "/S " + (player2.getX() + 1) + ").");
        battlefieldController.placeRobots(player1, player2, battlefield);

        //Ausgabe Startspielfeld
        battlefieldView.printBattlefield(battlefield);

        //Spielstart
        //TODO Spielrunde

        boolean player1Turn = true;

        while (player1Turn == true) {
            int moveCounter = player1.getMovementRate();

            while (moveCounter > 0) {
                char moveChoice = moveRobotView.printTurnMessageAndAskInput(player1);

                if (battlefieldController.isMoveValid(player1, moveChoice, battlefield)) {
                    robotController.move(moveChoice, player1, battlefield, battlefieldController);
                    moveCounter--;

                    moveRobotView.printPlayerTurnMessage(player1);
                    battlefieldView.printBattlefield(battlefield);
                } else {
                    moveRobotView.printErrorMoveMessage();
                }
            }

        }
            player1Turn = false;

    }

}


