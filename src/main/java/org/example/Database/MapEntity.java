package org.example.Database;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MapEntity")
public class MapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mapID")
    private int mapID;

    @Column(name = "mapSizeX")
    private int mapSizeX;

    @Column(name = "mapSize")
    private int mapSize;

    @Column(name = "mapItems")
    private String mapItems; //TODO: Datentyp? Sting Platzhalter


    public int getMapID() {
        return mapID;
    }

    public int getMapSizeX() {
        return mapSizeX;
    }

    public int getMapSize() {
        return mapSize;
    }

    public String getMapItems() {
        return mapItems;
    }

    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    public void setMapSizeX(int mapSizeX) {
        this.mapSizeX = mapSizeX;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public void setMapItems(String mapItems) {
        this.mapItems = mapItems;
    }

}
