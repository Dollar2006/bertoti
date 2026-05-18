package padrao;

public class VagaEmprego {
    private String titulo;
    private EstrategiaTriagem estrategiaTriagem;

    public VagaEmprego(String titulo, EstrategiaTriagem estrategiaTriagem) {
        this.titulo = titulo;
        this.estrategiaTriagem = estrategiaTriagem;
    }

    public void setEstrategiaTriagem(EstrategiaTriagem estrategiaTriagem) {
        this.estrategiaTriagem = estrategiaTriagem;
    }

    public void triarCandidatos() {
        if (estrategiaTriagem != null) {
            estrategiaTriagem.triar(titulo);
        } else {
            System.out.println("Nenhuma estratégia de triagem definida para a vaga '" + titulo + "'.");
        }
    }
}
