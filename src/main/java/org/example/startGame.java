package org.example;

import org.example.Client.View.*;
import org.example.Database.Interface.IDBRobotService;
import org.example.Database.Service.DBRobotService;
import org.example.Server.Controller.BattlefieldController;
import org.example.Server.Controller.GameController;
import org.example.Server.Controller.RobotController;
import org.example.Server.Model.Battlefield;
import org.example.Server.Model.Robot;

public class startGame {
    public static void main(String[] args) {

        //Database
        IDBRobotService idbRobotService = new DBRobotService(); // ???

        //Server

        //Controller
        BattlefieldController battlefieldController = new BattlefieldController();
        RobotController robotController= new RobotController();
        GameController gameController = new GameController();

        //Model
        Battlefield battlefield = new Battlefield(10,15);
        Robot player1 = new Robot("", battlefieldController.randomNumberRow(), battlefieldController.randomNumberColumn(), 1,1,1,1,10, "X", false, true);
        Robot player2 = new Robot("", battlefieldController.randomNumberRow(), battlefieldController.randomNumberColumn(), 1,1,1,1,10, "O",false, false);

        //Client

        //View
        IntroScreenView introScreenView = new IntroScreenView();
        AskRobotNameView askRobotNameView = new AskRobotNameView();
        BattlefieldView battlefieldView = new BattlefieldView();
        DisplayRobotStatsView displayRobotStatsView = new DisplayRobotStatsView();
        DisplayWinnerView displayWinnerView = new DisplayWinnerView();
        MoveRobotView moveRobotView = new MoveRobotView();
        AttackRobotView attackRobotView = new AttackRobotView();


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
        battlefieldController.fillBattlefield(battlefield);
        battlefieldController.placeRobots(player1, player2, battlefield);

        //Ausgabe Startspielfeld
        battlefieldView.printBattlefield(battlefield);

        //Spielstart
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {

            if (player1.getHealth() <= 0) {
                displayWinnerView.printWinner(player2, player1);
            } else {

                while (player1.getTurn()) {

                    if (battlefieldController.robotInAttackRange(player1, player2, battlefield)) {
                        int choice = attackRobotView.printEnemyInRangeMessage(player1, player2);

                        while (choice != '1' && choice != '2') {
                            choice = attackRobotView.printErrorMessageAttackOrMoveChoiceAndAskAgain();
                        }

                        if (choice == '1') {
                            robotController.attack(player1, player2);
                            attackRobotView.printAttackSuccessfulMessage(player1, player2);
                            player1.setTurn(false);
                            player2.setTurn(true);
                        } else {
                            gameController.playerTurn(player1, player2, moveRobotView, battlefieldController, robotController, battlefieldView, battlefield);
                        }

                    } else {
                        gameController.playerTurn(player1, player2, moveRobotView, battlefieldController, robotController, battlefieldView, battlefield);
                    }
                }
            }

            if(player2.getHealth() <= 0) {
                displayWinnerView.printWinner(player1, player2);
            } else {
                while (player2.getTurn()) {

                    if (battlefieldController.robotInAttackRange(player2, player1, battlefield)) {
                        int choice = attackRobotView.printEnemyInRangeMessage(player2, player1);

                        while (choice != '1' && choice != '2') {
                            choice = attackRobotView.printErrorMessageAttackOrMoveChoiceAndAskAgain();
                        }

                        if (choice == '1') {
                            robotController.attack(player2, player1);
                            attackRobotView.printAttackSuccessfulMessage(player2, player1);
                            player2.setTurn(false);
                            player1.setTurn(true);
                        } else {
                            gameController.playerTurn(player1, player1, moveRobotView, battlefieldController, robotController, battlefieldView, battlefield);
                        }

                    } else {
                        gameController.playerTurn(player2, player1, moveRobotView, battlefieldController, robotController, battlefieldView, battlefield);
                    }
                }
            }
        }
    }
}
