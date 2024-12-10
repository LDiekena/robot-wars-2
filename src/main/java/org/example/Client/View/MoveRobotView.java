package org.example.Client.View;

import org.example.Server.Model.Robot;

import java.util.Scanner;

public class MoveRobotView {

    //Ausgabe Richtungswahl des Spielers
    public char printTurnMessageAndAskInput(Robot robot) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + robot.getName() + " ist dran. Um dich zu bewegen nutze die Eingaben 6 = rechts, 4 = links, 8 = hoch und 2 = unten" +
                ", möchtest du auf der aktuellen Position verweilen gebe eine 5 ein.");
        return sc.next().charAt(0);
    }

    //Ausgabe Fehler, Spieler kann nicht in die ausgewählte Richtung
    public void printErrorMoveMessage() {
        System.out.println("Die Eingabe ist ungültig, bitte versuche es erneut. ");
    }

    //Textausgabe welcher Spieler ist am Zug
    public void printPlayerTurnMessage(Robot robot) {
        System.out.println("Zug von " + robot.getName());
    }
}
