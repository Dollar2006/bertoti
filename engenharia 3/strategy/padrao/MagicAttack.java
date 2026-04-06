package padrao;

public class MagicAttack implements AttackStrategy {
    @Override
    public void execute(String characterName) {
        System.out.println(characterName + " casts a fireball! Boom!");
    }
}
