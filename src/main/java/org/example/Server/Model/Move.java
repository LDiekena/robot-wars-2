package org.example.Server.Model;

public class Move {
    Robot robot;
    Battlefield battlefield;
    String movementType;
    String align;

    //Konstruktor
    public Move(Robot robot, Battlefield battlefield, String movementType, String align) {
        this.robot = robot;
        this.battlefield = battlefield;
        this.movementType = movementType;
        this.align = align;
    }

    //Getter
    public Robot getRobot() {
        return robot;
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public String getMovementType() {
        return movementType;
    }

    public String getAlign() {
        return align;
    }

    //Setter
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public void setAlign(String align) {
        this.align = align;
    }
}
