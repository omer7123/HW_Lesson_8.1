package com.company.players;

import java.util.Random;

public class Warrior extends Hero {
    private static int change;

    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random ran1 = new Random();
        change = ran1.nextInt(4 - 2 + 1) + 2;

        boss.setHealth(boss.getHealth() - (heroes[0].getDamage() * change));

    }

    public static int getChange() {
        return change;
    }

    public static void setChange(int change) {
        Warrior.change = change;
    }
}
