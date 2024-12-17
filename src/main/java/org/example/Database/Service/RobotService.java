package org.example.Database.Service;

import org.example.Database.Interface.IRobotService;
import org.example.Database.Model.Robot;
import org.hibernate.Session;

public class RobotService {

    public void createRobot(Session session, Robot robot) {
        Robot robotEntity = new Robot();
        robotEntity.setName(robot.getName());
        robotEntity.setHealth(robot.getHealth());
        robotEntity.setAttackDamage(robot.getAttackDamage());
        robotEntity.setAttackRange(robot.getAttackRange());
        robotEntity.setMovementRate(robot.getMovementRate());

        session.persist(robotEntity);
        session.getTransaction().commit();
    }

    public Robot getRobot(Session session, int robotID) {
        Robot robot = session.get(Robot.class,robotID);
        return robot;
    }
    
    public Robot[] getRobots(Session session, int gameID) {
        Robot[] robots = new Robot[0];

        //TODO: Count wie viele Roboter sich in dem Spiel befinden und ziehe jeden davon aus der DB und füge sie in eine Liste ein, die dann zurückgegeben wird

        return robots;
    }
}
