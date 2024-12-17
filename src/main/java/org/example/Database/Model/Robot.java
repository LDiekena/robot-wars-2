package org.example.Database.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Robot")
public class Robot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="robotID")
    private int robotID;

    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private int health;

    @Column(name = "attackDamage")
    private int attackDamage;

    @Column(name = "attackRange")
    private int attackRange;

    @Column(name = "movementRate")
    private int movementRate;

    //Getter
    public int getRobotID() {
        return robotID;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getMovementRate() {
        return movementRate;
    }

    //Setter
    public void setRobotID(int robotID) {
        this.robotID = robotID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }
}
