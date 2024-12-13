package org.example.Database;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="GameEntity")
public class GameEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gameID")
    private int gameID;

    @Column(name = "map")
    private int map;

    @Column(name = "robots")
    private RobotEntity[] robotEntities;

    @Column(name = "move")
    private MoveEntity[] moveEntities;

    @Column(name = "status")
    private String status;

    public int getGameID() {
        return gameID;
    }

    public int getMap() {
        return map;
    }

    public RobotEntity[] getRobots() {
        return robotEntities;
    }

    public MoveEntity[] getMoves() {
        return moveEntities;
    }

    public String getStatus() {
        return status;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setMap(int map) {
        this.map = map;
    }

    public void setRobotEntities(RobotEntity[] robotEntities) {
        this.robotEntities = robotEntities;
    }

    public void setMoveEntities(MoveEntity[] moveEntities) {
        this.moveEntities = moveEntities;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
