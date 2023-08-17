package com.dp.dp_sp.game;

public class GameContext {

    private WeaponStrategy weaponStrategy;

    public WeaponStrategy getWeaponStrategy() {
        return weaponStrategy;
    }

    public void setWeaponStrategy(WeaponStrategy weaponStrategy) {
        this.weaponStrategy = weaponStrategy;
    }

    public GameContext(WeaponStrategy weaponStrategy) {
        this.weaponStrategy = weaponStrategy;
    }

    public String executeGetWeapon(){
        return weaponStrategy.getWeapon();
    }

    public String executeAttackBoss(){
        return weaponStrategy.attackBoss();
    }
}
