package anti_padrao;

public class NotificadorSMS {
    public void enviarSMSCliente(double novoSaldo) {
        System.out.println("[SMS] Notificação: O saldo da sua conta mudou. Novo saldo: R$ " + novoSaldo);
    }
}
