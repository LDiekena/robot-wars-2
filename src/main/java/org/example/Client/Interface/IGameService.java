package org.example.Client.Interface;

public interface IGameService {

    int createGame();

    int joinGame(int gameID, int RobotID);

    void leaveGame();

    void deleteGame();

    String getGameStatus();
}
