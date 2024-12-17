package org.example.Client.Service;

import org.example.Client.Interface.IGameService;

public class GameService implements IGameService {


    @Override
    public int createGame() {

        return 0; //Platzhalter für gameID;
    }

    @Override
    public int joinGame(int gameID, int RobotID) {

        return 0; //Platzhalter playerIndex
    }

    @Override
    public void leaveGame() {

    }

    @Override
    public void deleteGame() {

    }

    @Override
    public String getGameStatus() {
        return "Platzhalter für gameStatus";
    }
}
