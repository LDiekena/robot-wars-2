package org.example.View;

public class BattlefieldView {

    //Ausgabe Battlefield
    public void printBattlefield(String[][] battlefield) {
        for (int i = 0; i < battlefield.length; i++) {
            for (int j = 0; j < battlefield[i].length; j++) {
                System.out.print(battlefield[i][j]);
            }
            System.out.println();
        }
    }

    //Ausgabe Spielfeldvorbereitung
    public void printPrepareMessage() {
        System.out.println("Das Spielfeld wird für das Spiel vorbereitet.\n");
    }
}
