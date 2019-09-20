package thegame.charapters;

public class NinjaTurtle extends Character {

    public NinjaTurtle() {
        super(17, 110, "Ninja Turtle Donatello");
    }

    @Override
    public void applySuperAbility(Character enemy) {
        int enemyDamage = enemy.getDamage();
        enemy.setDamage(enemyDamage - 5);
        if (enemy.getDamage() <= 0) {
            enemy.setDamage(2);
        }
        System.out.println(this.name + " used his Super Ability! Now " + enemy.getName() + "'s damage is " + enemy.getDamage() + ".");
    }

}

