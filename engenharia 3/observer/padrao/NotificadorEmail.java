package padrao;

public class NotificadorEmail implements Observer {
    @Override
    public void atualizar(double saldo) {
        System.out.println("[Email] Notificação: O saldo da sua conta mudou. Novo saldo: R$ " + saldo);
    }
}
