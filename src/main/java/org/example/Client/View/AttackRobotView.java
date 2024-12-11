package org.example.Client.View;

import org.example.Server.Model.Robot;

import java.util.Scanner;

public class AttackRobotView {
    //Ausgabe Angriffsmöglichkeit
    public char printEnemyInRangeMessage(Robot currentRobot, Robot enemyRobot) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + enemyRobot.getName() + " befindet sich in der Reichweite von " + currentRobot.getName() + ". Möchtest du deinen Gegner angreifen " +
                "oder dich weiter auf dem Spielfeld bewegen. Um deinen Gegner anzugreifen gebe bitte die 1 ein, um dich weiter fortzubewegen gebe bitte die 2 ein.");
        return sc.next().charAt(0);
    }

    //Fehlerausgabe Eingabe inkorrekt
    public char printErrorMessageAttackOrMoveChoiceAndAskAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fehlerhafte Eingabe, bitte versuche es erneut: ");
        return sc.next().charAt(0);
    }

    public void printAttackSuccessfulMessage(Robot currentRobot, Robot enemyRobot) {
        System.out.println(currentRobot.getName() + " hat " + currentRobot.getAttackDamage() + " schaden an " + enemyRobot.getName() + " verursacht! Damit sink das verbleibende" +
                " Leben von " + enemyRobot.getName() + " auf " + enemyRobot.getHealth() + ".");
    }
}
