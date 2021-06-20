package com.company.general;

import com.company.players.*;

public class RPG_Game {

    private static int numberRound = 0;

    public static void start() {
        Boss boss = new Boss(400, 50);
        Warrior warrior = new Warrior(250, 10);
        Tank tank = new Tank(250, 10);
        Magic magic = new Magic(250, 10, 5);
        Medic medic = new Medic(300, 5, 15);
        Medic youngMedic = new Medic(300, 8, 10);
        Hero[] heroes = {warrior, tank, magic, medic, youngMedic};

        printStatistic(boss, heroes);
        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }

    }

    private static void printStatistic(Boss boss, Hero[] heroes) {
        System.out.println("____________________________________");

        if (numberRound == 0) {
            System.out.println("Начальная информация");
        } else {
            System.out.println("Round " + numberRound);
        }
        numberRound++;

        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " " + "health: " + heroes[i].getHealth());
        }

        System.out.println("____________________________________");
        System.out.println("Танк отразил и перенаправил удар босса: " + boss.getDamage());

        for (int i = 1; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " " + "damage: " + heroes[i].getDamage());
        }

        //System.out.println("Warrior нанес критический удар: " + heroes[0].getDamage() * Warrior.getChange());
    }

    private static void round(Boss boss, Hero[] heroes) {
        heroesHit(boss, heroes);
        bossHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistic(boss, heroes);
    }


    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won");
            return true;

        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                return false;
            }
            break;

        }
        if (allHeroesDied) {
            System.out.println("Boss Won");
        }
        return allHeroesDied;
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 1; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 1; i < heroes.length; i++) {
            if (boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }

    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperAbility(boss, heroes);
        }
        if (boss.getHealth() < 0) {
            boss.setHealth(0);
        }

    }

    public int getNumberRound() {
        return numberRound;
    }

    public void setNumberRound(int numberRound) {
        this.numberRound = numberRound;
    }
}
