package thegame.charapters;

import thegame.BattleHistory;

public abstract class Character implements SuperAbility {

    protected int damage;
    protected int healthPoint;
    protected String name;
    protected boolean id;

    protected Character(int damage, int healthPoint, String name) {
        this.damage = damage;
        this.healthPoint = healthPoint;
        this.name = name;
    }

    protected int getDamage() {
        return damage;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    protected void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public void representCharacter() {
        System.out.println("He has such characteristics: " +
                "\nHealth point: " + this.healthPoint +
                "\nDamage: " + this.damage);
    }

    public void hit(Character enemy) {
        if (randomSuperAbility()) {
            this.applySuperAbility(enemy);
        }
        int healthPoint = enemy.getHealthPoint();
        enemy.setHealthPoint(healthPoint - this.damage);
        System.out.println(this.name + " hits " + enemy.name + " for " + this.damage + " points.");
    }
    private static boolean randomSuperAbility() {
        return BattleHistory.random.nextInt(4) == 0;
    }
}
