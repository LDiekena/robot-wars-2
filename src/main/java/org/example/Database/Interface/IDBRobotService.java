package org.example.Database.Interface;

import org.example.Database.RobotEntity;
import org.example.Server.Model.Robot;
import org.hibernate.Session;

public interface IDBRobotService {

    void createRobot(Session session, Robot robot);

    RobotEntity getRobot(Session session, int robotID);

    RobotEntity[] getRobots(Session session, int gameID);
}
