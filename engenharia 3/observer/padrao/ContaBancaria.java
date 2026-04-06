package padrao;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria implements Subject {
    private List<Observer> observadores = new ArrayList<>();
    private double saldo = 0.0;

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado. Saldo atual: R$ " + this.saldo);
        notificarObservadores();
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + this.saldo);
            notificarObservadores();
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void adicionarObservador(Observer o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for(Observer o : observadores) {
            o.atualizar(this.saldo);
        }
    }
}
