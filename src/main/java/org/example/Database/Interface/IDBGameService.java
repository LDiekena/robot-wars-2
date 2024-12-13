package org.example.Database.Interface;

import org.example.Database.MoveEntity;
import org.example.Server.Model.Robot;
import org.hibernate.Session;

public interface IDBGameService {

    void createGame(Session session, int battlefieldID, Robot[] robots, MoveEntity[] moves, String status);

    void updateGameJoinRobot(Session session, int robotID, int gameID); //???

    void createMove(Session session, int robotID, String movementType, int mapIndex, String align);

    MoveEntity getMove(Session session, int moveID);
}
