package padrao;

public class Main {
    public static void main(String[] args) {
        VagaEmprego vaga = new VagaEmprego("Desenvolvedor Java", new TriagemPorExperiencia());
        vaga.triarCandidatos();

        System.out.println("--- Alterando a estratégia de triagem ---");
        vaga.setEstrategiaTriagem(new TriagemPorFormacao());
        vaga.triarCandidatos();
        
        System.out.println("--- Alterando a estratégia de triagem ---");
        vaga.setEstrategiaTriagem(new TriagemPorTestePratico());
        vaga.triarCandidatos();
    }
}
