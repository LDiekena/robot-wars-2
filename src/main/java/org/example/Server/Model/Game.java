package org.example.Server.Model;

public class Game {
    Battlefield battlefield;
    Robot[] robots;
    Move[] moves;
    String status;

    //Konstruktor
    public Game(Battlefield battlefield, Robot[] robots, Move[] moves, String status) {
        this.battlefield = battlefield;
        this.robots = robots;
        this.moves = moves;
        this.status = status;
    }

    //Getter
    public Battlefield getBattlefield() {
        return battlefield;
    }

    public Robot[] getRobots() {
        return robots;
    }

    public Move[] getMoves() {
        return moves;
    }

    public String getStatus() {
        return status;
    }

    //Setter
    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public void setRobots(Robot[] robots) {
        this.robots = robots;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
