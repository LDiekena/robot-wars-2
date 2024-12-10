package org.example.Client.View;

import org.example.Server.Model.Battlefield;

public class BattlefieldView {

    //Ausgabe Battlefield
    public void printBattlefield(Battlefield battlefield) {
        for (int i = 0; i < battlefield.getMap().length; i++) {
            if (i % battlefield.getWidth() == 0) {
                System.out.println();
            }
            System.out.print(battlefield.getMap()[i]);
        }
    }

    //Ausgabe Spielfeldvorbereitung
    public void printPrepareMessage() {
        System.out.println("Das Spielfeld wird für das Spiel vorbereitet.\n");
    }
}
