package anti_padrao;

public class Main {
    public static void main(String[] args) {
        NotificadorEmail email = new NotificadorEmail();
        NotificadorSMS sms = new NotificadorSMS();
        
        ContaBancaria conta = new ContaBancaria(email, sms);
        
        conta.depositar(100.0);
        conta.sacar(30.0);
    }
}
