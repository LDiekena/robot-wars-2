package org.example.Controller;

import org.example.Model.Robot;

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
    public void fillBattlefield(String [][] battlefield) {
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[i].length; j++) {
                battlefield[i][j] = " [ ]";
            }
        }
    }

    //Platziere Spieler und Gegner auf dem Spielfeld
    public void placeRobots(Robot player1, Robot player2, String[][] battlefield) {
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[i].length; j++) {
                if (i == player1.getX() && j == player1.getY()) {
                    battlefield[i][j] = " [" + player1.getSymbol() + "]";
                }
            }
        }

        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[i].length; j++) {
                if (i == player2.getX() && j == player2.getY()) {
                    if (!battlefield[i][j].equals(" [" + player1.getSymbol() + "]")) {
                        battlefield[i][j] = " [" + player2.getSymbol() + "]";
                    } else {
                        player2.setX(i + 1);
                        player2.setY(j + 1);
                        battlefield[i + 1][j + 1] = " [" + player2.getSymbol() + "]";
                    }
                }
            }
        }
    }

    //Methode Zuggültigkeit
    public boolean isMoveValid(int posZeile, int posSpalte, char zugEingabe) {
        if (posZeile == 9 && zugEingabe == '2') {
            return false;
        } else if (posZeile == 0 && zugEingabe == '8') {
            return false;
        } else if (posSpalte == 14 && zugEingabe == '6') {
            return false;
        } else if (posSpalte == 0 && zugEingabe == '4') {
            return false;
        } else if (zugEingabe != '2' && zugEingabe != '4' && zugEingabe != '5' && zugEingabe != '6' && zugEingabe != '8') {
            return false;
        } else {
            return true;
        }
    }

    //TODO robotInAttackRange()
}
