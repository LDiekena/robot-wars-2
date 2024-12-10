package org.example.Server.Model;

public class Robot {
    String name;
    String symbol;
    int attackRange;
    int attackDamage;
    int health;
    int x; //column
    int y; //row
    int movementRate;
    boolean isKnockedOut;
    int skillpoints;

    //Konstruktor
    public Robot(String name, int y, int x, int health, int movementRate, int attackDamage, int attackRange, int skillpoints, String symbol, boolean isKnockedOut) {
        this.name = name;
        this.movementRate = movementRate;
        this.y = y;
        this.x = x;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.symbol = symbol;
        this.isKnockedOut = isKnockedOut;
        this.skillpoints = skillpoints;
    }

    //Getter
    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public boolean getIsKnockedOut() {
        return isKnockedOut;
    }

    public int getSkillpoints() {
        return skillpoints;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }

    public void setKnockedOut(boolean isKnockedOut) {
        this.isKnockedOut = isKnockedOut;
    }

    public void setSkillpoints(int skillpoints) {
        this.skillpoints = skillpoints;
    }

    //Methoden
    public void reduceHealth(int damage) {
        setHealth(getHealth() - damage);
    }
}
