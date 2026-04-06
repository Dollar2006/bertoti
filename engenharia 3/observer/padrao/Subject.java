package padrao;

public interface Subject {
    void adicionarObservador(Observer o);
    void removerObservador(Observer o);
    void notificarObservadores();
}
