package antipadrao;

public class Main {
    public static void main(String[] args) {
        RPGCharacter warrior = new RPGCharacter("Aragorn", WeaponType.SWORD);
        warrior.attack();

        System.out.println("--- Changing weapon ---");
        warrior.setWeapon(WeaponType.BOW);
        warrior.attack();

        System.out.println("--- Changing weapon ---");
        warrior.setWeapon(WeaponType.MAGIC);
        warrior.attack();
    }
}
