package org.example.Database.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Move")
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="moveID")
    private int moveID;

    @Column(name = "robotID")
    private int robotID;

    @Column(name = "movementType")
    private String movmentType;

    @Column(name = "battlefieldIndex")
    private int battlefieldIndex;

    @Column(name = "align")
    private String align;

    //Getter
    public int getMoveID() {
        return moveID;
    }

    public int getRobotID() {
        return robotID;
    }

    public String getMovmentType() {
        return movmentType;
    }

    public int getBattlefieldIndex() {
        return battlefieldIndex;
    }

    public String getAlign() {
        return align;
    }

    //Setter
    public void setMoveID(int moveID) {
        this.moveID = moveID;
    }

    public void setRobotID(int robotID) {
        this.robotID = robotID;
    }

    public void setMovmentType(String movmentType) {
        this.movmentType = movmentType;
    }

    public void setBattlefieldIndex(int battlefieldIndex) {
        this.battlefieldIndex = battlefieldIndex;
    }

    public void setAlign(String align) {
        this.align = align;
    }
}



//TODO: Note an mich; GET moves = alle moves die nach deinem letzten move passiert sind um den eigenen Client dahingegehend zu aktualisieren!
//TODO: Note; Zug durch END beendet und dann ist der nächste Spieler dran
