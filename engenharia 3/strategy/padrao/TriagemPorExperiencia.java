package padrao;

public class TriagemPorExperiencia implements EstrategiaTriagem {
    @Override
    public void triar(String tituloVaga) {
        System.out.println("Triando candidatos para a vaga '" + tituloVaga + "' baseando-se na Experiência.");
        // Apenas a assinatura e um log simples para demonstrar o pattern
    }
}
