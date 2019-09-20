package thegame.charapters;

public class Jason extends Character {

    public Jason() {
        super(20, 100, "Jason");
    }

    @Override
    public void applySuperAbility(Character enemy) {
        int enemyHP = enemy.getHealthPoint();
        enemy.setHealthPoint(enemyHP - 20);
        System.out.println(this.name + " used his Super Ability! Now " + enemy.getName() + " has " + enemy.getHealthPoint() + " health points.");
    }

}
