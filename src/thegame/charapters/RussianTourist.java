package thegame.charapters;

public class RussianTourist extends Character {

    public RussianTourist() {
        super(12, 140, "Russian Tourist Valera");
    }

    @Override
    public void applySuperAbility(Character enemy) {
        int currentHP = this.healthPoint;
        this.healthPoint = currentHP + 20;
        System.out.println(this.name + " used his Super Ability! Now he has " + this.healthPoint + " health points.");
    }

}
