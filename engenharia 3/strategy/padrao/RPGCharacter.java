package padrao;

public class RPGCharacter {
    private String name;
    private AttackStrategy attackStrategy;

    public RPGCharacter(String name, AttackStrategy attackStrategy) {
        this.name = name;
        this.attackStrategy = attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void performAttack() {
        if (attackStrategy != null) {
            attackStrategy.execute(name);
        } else {
            System.out.println(name + " has no strategy and waits...");
        }
    }
}
