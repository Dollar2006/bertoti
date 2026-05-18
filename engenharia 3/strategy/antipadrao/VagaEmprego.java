package antipadrao;

public class VagaEmprego {
    private String titulo;
    private TipoTriagem tipoTriagem;

    public VagaEmprego(String titulo, TipoTriagem tipoTriagem) {
        this.titulo = titulo;
        this.tipoTriagem = tipoTriagem;
    }

    public void setTipoTriagem(TipoTriagem tipoTriagem) {
        this.tipoTriagem = tipoTriagem;
    }

    public void triarCandidatos() {
        if (tipoTriagem == TipoTriagem.EXPERIENCIA) {
            System.out.println("Triando candidatos para a vaga '" + titulo + "' baseando-se na Experiência.");
            // Assinatura/Lógica de triagem por experiência (apenas demonstração do pattern)
        } else if (tipoTriagem == TipoTriagem.FORMACAO) {
            System.out.println("Triando candidatos para a vaga '" + titulo + "' baseando-se na Formação Acadêmica.");
            // Assinatura/Lógica de triagem por formação (apenas demonstração do pattern)
        } else if (tipoTriagem == TipoTriagem.TESTE_PRATICO) {
            System.out.println("Triando candidatos para a vaga '" + titulo + "' baseando-se em Teste Prático.");
            // Assinatura/Lógica de triagem por teste prático (apenas demonstração do pattern)
        } else {
            System.out.println("Nenhum tipo de triagem definido para a vaga '" + titulo + "'.");
        }
    }
}
