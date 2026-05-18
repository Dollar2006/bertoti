package padrao;

public class TriagemPorTestePratico implements EstrategiaTriagem {
    @Override
    public void triar(String tituloVaga) {
        System.out.println("Triando candidatos para a vaga '" + tituloVaga + "' baseando-se em Teste Prático.");
        // Apenas a assinatura e um log simples para demonstrar o pattern
    }
}
