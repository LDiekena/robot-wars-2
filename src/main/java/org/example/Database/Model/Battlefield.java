package org.example.Database.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Battlefield")
public class Battlefield {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="battlefieldID")
    private int battlefieldID;

    @Column(name = "battlefieldSizeX")
    private int battlefieldSizeX;

    @Column(name = "battlefieldSize")
    private int battlefieldSize;

    @Column(name = "battlefieldItems")
    private String battlefieldItems; //WALL, ROBOT, ITEM (Enum)

    //Getter
    public int getMapID() {
        return battlefieldID;
    }

    public int getMapSizeX() {
        return battlefieldSizeX;
    }

    public int getMapSize() {
        return battlefieldSize;
    }

    public String getMapItems() {
        return battlefieldItems;
    }

    //Setter
    public void setMapID(int mapID) {
        this.battlefieldID = mapID;
    }

    public void setMapSizeX(int mapSizeX) {
        this.battlefieldSizeX = mapSizeX;
    }

    public void setMapSize(int mapSize) {
        this.battlefieldSize = mapSize;
    }

    public void setMapItems(String mapItems) {
        this.battlefieldItems = mapItems;
    }

}
