package com.company.players;

public class Magic extends Hero {

    private int magicSuper;

    public Magic(int health, int damage, int magicSuper) {
        super(health, damage, SuperAbility.BOOST);
        this.magicSuper = magicSuper;
    }

    public int getMagicSuper() {
        return magicSuper;
    }

    public void setMagicSuper(int magicSuper) {
        this.magicSuper = magicSuper;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(heroes[i].getDamage() + magicSuper);
        }
    }
}
