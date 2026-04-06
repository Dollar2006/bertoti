package padrao;

public class BowAttack implements AttackStrategy {
    @Override
    public void execute(String characterName) {
        System.out.println(characterName + " shoots an arrow! Whiz!");
    }
}
