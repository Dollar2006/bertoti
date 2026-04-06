package padrao;

public class SwordAttack implements AttackStrategy {
    @Override
    public void execute(String characterName) {
        System.out.println(characterName + " attacks with a sword! Slash!");
    }
}
