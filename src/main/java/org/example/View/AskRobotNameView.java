package org.example.View;

import java.util.Scanner;

public class AskRobotNameView {

    //Ausgabe Namensabfrage
    public String askPlayerName(String player) {
        System.out.println(player + " , bitte gebe deinen Namen für das Spiel ein: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
