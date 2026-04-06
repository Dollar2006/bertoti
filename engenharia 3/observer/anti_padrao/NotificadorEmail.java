package anti_padrao;

public class NotificadorEmail {
    public void enviarEmailCorrentista(double novoSaldo) {
        System.out.println("[Email] Notificação: O saldo da sua conta mudou. Novo saldo: R$ " + novoSaldo);
    }
}
