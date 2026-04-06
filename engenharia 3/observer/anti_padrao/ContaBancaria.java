package anti_padrao;

public class ContaBancaria {
    private double saldo = 0.0;
    
    // Classes fortemente acopladas. Precisamos alterar a ContaBancaria
    // sempre que um novo notificador surgir.
    private NotificadorEmail notificadorEmail;
    private NotificadorSMS notificadorSMS;

    public ContaBancaria(NotificadorEmail notificadorEmail, NotificadorSMS notificadorSMS) {
        this.notificadorEmail = notificadorEmail;
        this.notificadorSMS = notificadorSMS;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado. Saldo atual: R$ " + this.saldo);
        notificarDependentes();
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + this.saldo);
            notificarDependentes();
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }
    
    private void notificarDependentes() {
        // Forte acoplamento! Qualquer novo tipo de notificação exigirá alteração aqui na classe modelo.
        // Além disso, métodos específicos e dependência direta das instâncias ferem os princípios do SOLID (Open/Closed, Inversão de dependência).
        if (notificadorEmail != null) {
            notificadorEmail.enviarEmailCorrentista(this.saldo);
        }
        if (notificadorSMS != null) {
            notificadorSMS.enviarSMSCliente(this.saldo);
        }
    }
}
