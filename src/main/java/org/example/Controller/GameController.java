package org.example.Controller;

import org.example.Model.Battlefield;
import org.example.Model.Robot;
import org.example.View.*;

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

        //Spielfeldvorbereitungen
        battlefieldView.printPrepareMessage();
        battlefieldController.fillBattlefield(battlefield.getMap());
        battlefieldController.placeRobots(player1, player2, battlefield.getMap());

        //Ausgabe Startspielfeld
        battlefieldView.printBattlefield(battlefield.getMap());

        //Spielstart
        //TODO Spielrunde

    }




}
