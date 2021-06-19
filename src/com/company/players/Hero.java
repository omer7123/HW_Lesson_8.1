package com.company.players;

public abstract class Hero extends GameEntity implements HavingSuperAbility {

    private SuperAbility ability;

    public Hero(int health, int damage, SuperAbility ability) {
        super(health, damage);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void setAbility(SuperAbility ability) {
        this.ability = ability;
    }
}
