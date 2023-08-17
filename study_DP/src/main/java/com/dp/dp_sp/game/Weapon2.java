package com.dp.dp_sp.game;

public class Weapon2 extends WeaponStrategy {

    public Weapon2(String name, int baseDamage, String weaponName, String bossName) {
        super(name, baseDamage, weaponName, bossName);
    }

    @Override
    public String getWeapon() {
        return this.name + "获得了武器：" + this.weaponName;
    }

    @Override
    public String attackBoss() {
        return this.name + "攻击了" +this.bossName + this.baseDamage + "点血";
    }
}
