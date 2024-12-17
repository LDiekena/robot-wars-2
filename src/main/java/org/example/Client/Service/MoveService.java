package org.example.Client.Service;

import org.example.Client.Interface.IMoveService;
import org.example.Client.Model.Move;

public class MoveService implements IMoveService {
    @Override
    public int createMove() {
        return 0; //Platzhalter für moveID
    }

    @Override
    public Move[] getMoves() {
        return new Move[0];
    }
}
