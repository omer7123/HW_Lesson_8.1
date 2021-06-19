package com.company.players;

public class Medic extends Hero {

    private int healthPoints;

    public Medic(int health, int damage, int healthPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healthPoints = healthPoints;
    }


    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (!heroes[i].getAbility().equals(SuperAbility.HEAL)){
                heroes[i].setHealth(heroes[i].getHealth() + healthPoints);
            }
        }
    }
}
