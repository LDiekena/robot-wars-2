package org.example.Database.Service;

import org.example.Database.Interface.IDBRobotService;
import org.example.Database.RobotEntity;
import org.example.Server.Model.Robot;
import org.hibernate.Session;

public class DBRobotService implements IDBRobotService {

    @Override
    public void createRobot(Session session, Robot robot) {
        RobotEntity robotEntity = new RobotEntity();
        robotEntity.setName(robot.getName());
        robotEntity.setHealth(robot.getHealth());
        robotEntity.setAttackDamage(robot.getAttackDamage());
        robotEntity.setAttackRange(robot.getAttackRange());
        robotEntity.setMovementRate(robot.getMovementRate());

        session.persist(robotEntity);
        session.getTransaction().commit();
    }

    public RobotEntity getRobot(Session session, int robotID) {
        RobotEntity robot = session.get(RobotEntity.class,robotID);
        return robot;
    }
    
    public RobotEntity[] getRobots(Session session, int gameID) {
        RobotEntity[] robots = new RobotEntity[0];

        //TODO: Count wie viele Roboter sich in dem Spiel befinden und ziehe jeden davon aus der DB und füge sie in eine Liste ein, die dann zurückgegeben wird

        return robots;
    }
}
