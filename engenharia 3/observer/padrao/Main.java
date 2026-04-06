package padrao;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        
        Observer email = new NotificadorEmail();
        Observer sms = new NotificadorSMS();
        
        conta.adicionarObservador(email);
        conta.adicionarObservador(sms);
        
        conta.depositar(100.0);
        conta.sacar(30.0);
    }
}
