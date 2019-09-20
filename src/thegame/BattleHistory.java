package thegame;

import java.util.*;

import thegame.charapters.Batman;
import thegame.charapters.Character;
import thegame.charapters.Jason;
import thegame.charapters.NinjaTurtle;
import thegame.charapters.RussianTourist;

public class BattleHistory {

    public final static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    static void playTheGame() {
        System.out.println("Choose the character: " +
                "\n 0 \t Jason;" +
                "\n 1 \t Ninja Turtle;" +
                "\n 2 \t Russian Tourist;" +
                "\n 3 \t Batman.");
        int index = checkIndex();
        Character current = doCharacter(index);
        System.out.println("You choose the " + current.getName() + ".");
        current.representCharacter();

        System.out.println("\nGive the name to your character:");
        scanner.nextLine();
        String nameCharacter = scanner.nextLine();
        current.setName(nameCharacter);
        current.setId(true);

        Character enemy = doCharacter(createIndexEnemy());
        System.out.println("\nYour enemy is " + enemy.getName() + ".");
        enemy.representCharacter();
        CharactersPair<Character> characters = provideFirstAttacker(current, enemy);
        System.out.println("\nIf you ready - press ENTER :)");
        scanner.nextLine();
        goBattle(characters);
        tryOnceMore();
    }

    private static void tryOnceMore() {
        System.out.println("Do you want to try once more? Y/N");
        String yesOrNo = scanner.nextLine();
        switch (yesOrNo.toLowerCase()) {
            case "y":
                playTheGame();
                break;
            case "n":
                System.out.println("Have a nice day!");
                break;
            default:
                System.out.println("I don't understand!");
                tryOnceMore();
        }
    }

    private static int checkIndex() {
        int i;
        if (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Try once more!");
            i = checkIndex();
        } else {
            i = Math.abs(scanner.nextInt());
            if (i > 3) {
                System.out.println("Try once more!");
                i = checkIndex();
            }
        }
        return i;
    }

    private static Character doCharacter(int i) {
        Map<Integer, Character> charactersMap = new HashMap<>();
        charactersMap.put(0, new Jason());
        charactersMap.put(1, new NinjaTurtle());
        charactersMap.put(2, new RussianTourist());
        charactersMap.put(3, new Batman());
        return charactersMap.get(i);
    }

    private static CharactersPair<Character> provideFirstAttacker(Character current, Character enemy) {
        return randomWhoIsFirst()
                ? new CharactersPair<>(current, enemy)
                : new CharactersPair<>(enemy, current);
    }

    private static class CharactersPair<Character> {
        Character first;
        Character second;

        private CharactersPair(Character first, Character second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int createIndexEnemy() {
        return random.nextInt(4);
    }

    private static boolean randomWhoIsFirst() {
        return random.nextBoolean();
    }

    private static boolean nullHealthPoint(Character character) {
        return character.getHealthPoint() <= 0;
    }

    private static String winOrLose(Character character) {
        return character.isId()
                ? " lose! Sorry :)\n"
                : " WIN! Congratulation!!!\n";
    }

    private static void goBattle(CharactersPair<Character> charactersPair) {
        Character first = charactersPair.first;
        Character second = charactersPair.second;
        Character dead;
        int countOfStages = 1;
        System.out.println(first.getName() + " will hit the first!");
        while (true) {
            System.out.println("\n\tStage " + countOfStages);
            first.hit(second);
            if (nullHealthPoint(second)) {
                dead = second;
                break;
            }
            second.hit(first);
            if (nullHealthPoint(first)) {
                dead = first;
                break;
            }
            countOfStages++;
            System.out.println(first.getName() + " has " + first.getHealthPoint() + " health points."
                    + "\n" + second.getName() + " has " + second.getHealthPoint() + " health points.");
            System.out.println("Press ENTER to continue.");
            scanner.nextLine();
        }
        System.out.println("\n\tYou" + winOrLose(dead));
    }
}
