package org.example.Server.Model;

public class Battlefield {
    int width;
    int height;
    String[] map;


    //Konstruktor
    public Battlefield(int height, int width) {
        this.width = width;
        this.height = height;
        this.map = new String[width * height];
    }

    //Getter
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[] getMap() {
        return map;
    }

    //Setter
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMap(String[] map) {
        this.map = map;
    }
}
