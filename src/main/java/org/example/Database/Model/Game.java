package org.example.Database.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gameID")
    private int gameID;

    @Column(name = "battlefield")
    private int battlefield;

    @Column(name = "robots")
    private Robot[] robots;

    @Column(name = "move")
    private Move[] moves;

    @Column(name = "status")
    private String status;

    //Getter
    public int getGameID() {
        return gameID;
    }

    public int getMap() {
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
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setBattlefield(int battlefield) {
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
