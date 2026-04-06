package padrao;

public class AxeAttack implements AttackStrategy {
    @Override
    public void execute(String characterName) {
        System.out.println(characterName + " swings a heavy axe! Smash!");
    }
}
