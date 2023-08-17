package com.dp.dp_sp.game;

public abstract class WeaponStrategy {

    protected String name;

    protected int baseDamage;

    protected String weaponName;
    protected String bossName;

    public abstract String getWeapon ();

    public abstract String attackBoss ();

    public WeaponStrategy(String name, int baseDamage, String weaponName, String bossName) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.weaponName = weaponName;
        this.bossName = bossName;
    }
}
