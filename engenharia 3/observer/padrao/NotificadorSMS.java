package padrao;

public class NotificadorSMS implements Observer {
    @Override
    public void atualizar(double saldo) {
        System.out.println("[SMS] Notificação: O saldo da sua conta mudou. Novo saldo: R$ " + saldo);
    }
}
