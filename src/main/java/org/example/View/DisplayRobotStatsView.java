package org.example.View;

import org.example.Model.Robot;

import java.util.Scanner;

public class DisplayRobotStatsView {

    //Ausgabe Start von der Skillverteilung
    public void printStartSkillpointDistributionMessage(Robot player) {
        System.out.println("Alle Werte deines Roboters sind zum Initial mit dem Wert 1 festgesetzt. Bitte verteile nachfolgend " +
                "die [" + player.getSkillpoints() + "] zur Verfügung stehenden Skillpunkte um dir deinen Robotor zu Individualisieren. ");
    }

    //Ausgabe der Skillpunkteverteilung eines Robots
    public void printStats(Robot robot) {
        System.out.println("1. Leben: " + robot.getHealth());
        System.out.println("2. Schaden: " + robot.getAttackDamage());
        System.out.println("3. Trefferreichweite: " + robot.getAttackRange());
        System.out.println("4. Bewegungsrate: " + robot.getMovementRate());
        System.out.println("\nVerbleibende Anzahl an Skillpunkten: " + robot.getSkillpoints() + "\n");
    }

    //Eingabeaufforderung Attributauswahl
    public int askPlayerWhichAttribute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe das Attribut an das du verändern möchtest: ");
        return sc.nextInt();
    }

    //Ausgabe Fehlermeldung bei Attributauswahl und neue Eingabeaufforderung
    public int printErrorInputAttributeChoiceAndAskAgain() {
        System.out.println("Fehlerhafte Eingabe, bitte versuchen Sie es erneut: ");
        return askPlayerWhichAttribute();
    }

    //Ausgabe Steigerung/ Senkung von Attribut
    public char askIncreaseOrDecrease() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe nun ein ob du den Wert erhöhen (+) oder senken (-) möchtest: ");
        return sc.next().charAt(0);
    }

    //Ausgabe fehlerhafte Eingabe für Steigerung/ Senkung von Attribut
    public char printErrorIncreaseOrDecreaseAndAskAgain() {
        System.out.println("Fehlerhafte Eingabe, bitte versuchen Sie es erneut und geben entweder + für eine Steigerung oder - für die Senkung des geählten" +
                "Attributes ein: ");
        return askIncreaseOrDecrease();
    }

    //Ausgabe Abfrage um welchen Wert das gewählte Attribut verändert werden soll
    public int askNumberForSkillchange() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe nun den Wert an um den du das gewählte Attribut ändern möchtest: ");
        return sc.nextInt();
    }

    //Ausgabe Fehler, Wert übersteigt vorhandene Skillpunkte
    public int printErrorInputHigherThanSkillpointsAndAskAggain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Die eingegebene Anzahl übersteigt deine noch vorhandenen Skillpunkte, bitte versuche es erneut: ");
        return sc.nextInt();
    }

    //Ausgabe Fehler, Attribut befindet sich bereits auf Minimalwert
    public int printErrorAtributeIsMinimalAndAskAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Das ausgewählte Attribut ist bereits auf dem Minimalwert und kann nicht noch weiter gesenkt werden! Bitte gebe einen Wert ein um den du erhöhen" +
                " möchtest:");
        return sc.nextInt();
    }

    //Ausgabe Fehler, Wert würde den Minimalwert unterschreiten
    public int printErrorInvalidDecreaseAndAskAgein(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Der eingegebene Wert würde den Minimalwert unterschreiten, bitte versuche es erneut: ");
        return sc.nextInt();
    }

    //Ausgabe Attribut wurde erhöht
    public void printSkillIncreaseSuccessful(int numberToChange) {
        System.out.println("Das ausgewählte Attribut wurde erfolgreich um " + numberToChange + " erhöht. Deine Verteilung" +
                " sieht nun wie folgt aus:");
    }

    //Ausgabe Attribut wurde gesenkt
    public void printSkillDecreaseSuccessful(int numberToChange) {
        System.out.println("Das ausgewählte Attribut wurde erfolgreich um " + numberToChange + " gesenkt. Deine Verteilung" +
                " sieht nun wie folgt aus:");
    }

    //Ausgabe Fehler, Veränderung des Wertes konnte nicht durchgeführt werden (Sollte nicht möglich sein)
    public void printErrorSkillchange() {
        System.out.println("Fehler bei der Nutzung der Skillpunkte.");
    }

    //Ausgabe Spieler hat alle Skillpunkte verteilt
    public void printChangeSkillsCompleteMessage(Robot player) {
        System.out.println(player.getName() + " hat alle Skillpunkte verteilt.");
    }
}
