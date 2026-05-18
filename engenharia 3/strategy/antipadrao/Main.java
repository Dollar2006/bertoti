package antipadrao;

public class Main {
    public static void main(String[] args) {
        VagaEmprego vaga = new VagaEmprego("Desenvolvedor Java", TipoTriagem.EXPERIENCIA);
        vaga.triarCandidatos();

        System.out.println("--- Alterando a forma de triagem ---");
        vaga.setTipoTriagem(TipoTriagem.FORMACAO);
        vaga.triarCandidatos();
    }
}
