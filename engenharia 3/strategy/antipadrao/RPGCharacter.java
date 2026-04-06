package antipadrao;

public class RPGCharacter {
    private String name;
    private WeaponType weapon;

    public RPGCharacter(String name, WeaponType weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public void setWeapon(WeaponType weapon) {
        this.weapon = weapon;
    }

    public void attack() {
        if (weapon == WeaponType.SWORD) {
            System.out.println(name + " attacks with a sword! Slash!");
        } else if (weapon == WeaponType.BOW) {
            System.out.println(name + " shoots an arrow! Whiz!");
        } else if (weapon == WeaponType.MAGIC) {
            System.out.println(name + " casts a fireball! Boom!");
        } else if (weapon == WeaponType.AXE) {
            System.out.println(name + " swings a heavy axe! Smash!");
        } else {
            System.out.println(name + " is unarmed and waits...");
        }
    }
}
