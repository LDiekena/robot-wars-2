package org.example.Database.Interface;

import org.example.Database.Model.Robot;
import org.hibernate.Session;

public interface IRobotService {

    void createRobot(Session session, org.example.Server.Model.Robot robot);

    Robot getRobot(Session session, int robotID);

    Robot[] getRobots(Session session, int gameID);
}
