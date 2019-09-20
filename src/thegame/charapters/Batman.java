package thegame.charapters;

public class Batman extends Character {

    public Batman() {
        super(20, 100, "Batman");
    }

    @Override
    public void applySuperAbility(Character enemy) {
        int currentDamage = this.damage;
        this.damage = currentDamage + 5;
        System.out.println(this.name + " used his Super Ability! Now his damage is " + this.damage + ".");
    }

}
