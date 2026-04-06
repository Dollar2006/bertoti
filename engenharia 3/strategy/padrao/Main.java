package padrao;

public class Main {
    public static void main(String[] args) {
        RPGCharacter warrior = new RPGCharacter("Aragorn", new SwordAttack());
        warrior.performAttack();

        System.out.println("--- Changing strategy dynamically ---");
        warrior.setAttackStrategy(new BowAttack());
        warrior.performAttack();

        System.out.println("--- Changing strategy dynamically ---");
        warrior.setAttackStrategy(new MagicAttack());
        warrior.performAttack();
    }
}
