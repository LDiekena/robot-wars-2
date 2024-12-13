package org.example.Database;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MoveEntity")
public class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="moveID")
    private int moveID;

    @Column(name = "robotID")
    private int robotID;

    @Column(name = "movementType")
    private String movmentType;

    @Column(name = "mapIndex")
    private int mapIndex;

    @Column(name = "align")
    private String align;


    public int getMoveID() {
        return moveID;
    }

    public int getRobotID() {
        return robotID;
    }

    public String getMovmentType() {
        return movmentType;
    }

    public int getMapIndex() {
        return mapIndex;
    }

    public String getAlign() {
        return align;
    }

    public void setMoveID(int moveID) {
        this.moveID = moveID;
    }

    public void setRobotID(int robotID) {
        this.robotID = robotID;
    }

    public void setMovmentType(String movmentType) {
        this.movmentType = movmentType;
    }

    public void setMapIndex(int mapIndex) {
        this.mapIndex = mapIndex;
    }

    public void setAlign(String align) {
        this.align = align;
    }
}
