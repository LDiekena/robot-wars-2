package org.example.Interface;

import org.example.Hibernate.RobotEntity;
import org.example.Server.Model.Robot;
import org.hibernate.Session;

public class IRobotService {

    public void createRobot(Session session, Robot robot) {
        RobotEntity robotEntity = new RobotEntity();
        robotEntity.setName(robot.getName());
        robotEntity.setHealth(robot.getHealth());
        robotEntity.setAttackDamage(robot.getAttackDamage());
        robotEntity.setAttackRange(robot.getAttackRange());
        robotEntity.setMovementRate(robot.getMovementRate());

        session.persist(robotEntity);
    }

    public RobotEntity getRobot(Session session, int robotID) {
        RobotEntity robot = session.get(RobotEntity.class,robotID);
        return robot;
    }
    
    public Robot[] getRobots(Session session, int gameID) {
        Robot[] robots = new Robot[0];

        //TODO: Count wie viele Roboter sich in dem Spiel befinden und ziehe jeden davon aus der DB und füge sie in eine Liste ein, die dann zurückgegeben wird

        return robots;
    }
}
