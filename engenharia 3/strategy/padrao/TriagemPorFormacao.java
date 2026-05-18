package padrao;

public class TriagemPorFormacao implements EstrategiaTriagem {
    @Override
    public void triar(String tituloVaga) {
        System.out.println("Triando candidatos para a vaga '" + tituloVaga + "' baseando-se na Formação Acadêmica.");
        // Apenas a assinatura e um log simples para demonstrar o pattern
    }
}
