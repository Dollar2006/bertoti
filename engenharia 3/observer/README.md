# Observer Pattern - Documentação Completa

## 📋 Visão Geral

O padrão **Observer** é um padrão comportamental que define uma relação **um-para-muitos** entre objetos, onde quando um objeto (subject) muda de estado, todos os seus dependentes (observers) são notificados automaticamente.

---

## 🔴 Anti-padrão: Acoplamento Forte e Violação do Princípio de Inversão de Dependência

### Conceito de Anti-padrão

O anti-padrão do Observer demonstra o conceito de **acoplamento forte (tight coupling)**, que viola o **Princípio da Inversão de Dependência (DIP)** do SOLID:

- **Princípio da Inversão de Dependência**: Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações.

### Código Anti-padrão: `anti_padrao/ContaBancaria.java`

```java
public class ContaBancaria {
    private double saldo = 0.0;
    
    // ❌ PROBLEMA: Forte acoplamento direto com classes concretas
    private NotificadorEmail notificadorEmail;
    private NotificadorSMS notificadorSMS;

    public ContaBancaria(NotificadorEmail notificadorEmail, NotificadorSMS notificadorSMS) {
        this.notificadorEmail = notificadorEmail;
        this.notificadorSMS = notificadorSMS;
    }

    private void notificarDependentes() {
        // ❌ PROBLEMA: ContaBancaria "conhece" implementações específicas
        if (notificadorEmail != null) {
            notificadorEmail.enviarEmailCorrentista(this.saldo);
        }
        if (notificadorSMS != null) {
            notificadorSMS.enviarSMSCliente(this.saldo);
        }
    }
}
```

### Problemas Identificados

| Problema | Descrição | Impacto |
|----------|-----------|--------|
| **Acoplamento Forte** | Dependência direta de classes concretas | Mudanças em `NotificadorEmail` afetam `ContaBancaria` |
| **Violação do DIP** | Depende de implementações, não de abstrações | Difícil de estender e testar |
| **Explosão de Dependências** | Cada novo tipo de notificador exige nova variável | Código cresce sem limite |
| **Modificação Contínua** | Adicionar notificador exige alterar `ContaBancaria` | Violação do princípio Open/Closed |
| **Métodos Específicos** | `enviarEmailCorrentista()` vs `enviarSMSCliente()` | Sem interface uniforme, código heterogêneo |
| **Difícil de Testar** | Precisa instanciar múltiplas dependências | Testes complexos e frágeis |
| **Escalabilidade Zero** | Sistema não escala com novos notificadores | Design inadequado para crescimento |

### Estrutura do Anti-padrão

```
ContaBancaria (classe modelo)
    ├── has-a NotificadorEmail (acoplado forte)
    ├── has-a NotificadorSMS (acoplado forte)
    └── novos notificadores? precisa modificar aqui!
```

### Fluxo do Problema

```
1. Evento: depositar() ou sacar()
2. ContaBancaria chama notificarDependentes()
3. NotificadorEmail? Chama enviarEmailCorrentista()
4. NotificadorSMS? Chama enviarSMSCliente()
5. Novo notificador? MODIFIQUE ContaBancaria! ❌
```

---

## 🟢 Padrão Observer Correto: Desacoplamento Completo

### Como Funciona

O padrão Observer elimina o acoplamento ao criar:

1. **Interface `Observer`**: Define contrato para todos os observadores
2. **Interface `Subject`**: Define operações que o observado oferece
3. **Implementações Concretas**: Cada notificador é um observer independente
4. **Lista Genérica**: Subject mantém lista de observers abstratos
5. **Notificação Polimórfica**: Todos recebem o mesmo método `atualizar()`

### Arquivo: `padrao/Observer.java`

```java
public interface Observer {
    void atualizar(double saldo);  // Contrato único para todos!
}
```

### Arquivo: `padrao/Subject.java`

```java
public interface Subject {
    void adicionarObservador(Observer o);
    void removerObservador(Observer o);
    void notificarObservadores();
}
```

### Implementações Concretas

**`padrao/NotificadorEmail.java`**
```java
public class NotificadorEmail implements Observer {
    @Override
    public void atualizar(double saldo) {
        System.out.println("[Email] Notificação: O saldo da sua conta mudou. Novo saldo: R$ " + saldo);
    }
}
```

**`padrao/NotificadorSMS.java`**
```java
public class NotificadorSMS implements Observer {
    @Override
    public void atualizar(double saldo) {
        System.out.println("[SMS] Notificação: O saldo da sua conta mudou. Novo saldo: R$ " + saldo);
    }
}
```

### Classe Principal: `padrao/ContaBancaria.java`

```java
public class ContaBancaria implements Subject {
    private List<Observer> observadores = new ArrayList<>();  // ✅ Lista genérica
    private double saldo = 0.0;

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado. Saldo atual: R$ " + this.saldo);
        notificarObservadores();  // ✅ Notifica todos os observadores
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + this.saldo);
            notificarObservadores();  // ✅ Notifica todos os observadores
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
        // ✅ Polimorfismo: todos recebem atualizar()
        for(Observer o : observadores) {
            o.atualizar(this.saldo);
        }
    }
}
```

### Estrutura do Padrão

```
    ┌──────────────────┐
    │  Subject         │
    │  (Interface)     │
    │ + adicionar()    │
    │ + remover()      │
    │ + notificar()    │
    └────────┬─────────┘
             │
             │ implements
             │
    ┌────────▼──────────────┐
    │  ContaBancaria       │
    │  - observadores[]    │
    │  - saldo             │
    └────────┬──────────────┘
             │
    ┌────────▼──────────────┐
    │  notificarObservadores│
    │  para cada observer   │
    │  chamar atualizar()   │
    └──────────────────────┘
             │
    ┌────────┴────────┬──────────────┐
    │                 │              │
    ▼                 ▼              ▼
┌─────────┐      ┌─────────┐   ┌──────────┐
│Observer │      │Observer │   │Observer  │
│(Interf.)│      │(Interf.)│   │(Interf.)│
└────┬────┘      └────┬────┘   └────┬─────┘
     │                │             │
     │                │             │
┌────▼──────────┐ ┌──▼──────────┐ ┌──▼────────────┐
│Email          │ │SMS          │ │Notificador X  │
│+ atualizar()  │ │+ atualizar()│ │+ atualizar()  │
└───────────────┘ └─────────────┘ └───────────────┘
```

---

## 📊 Comparação: Anti-padrão vs Padrão

| Aspecto | Anti-padrão | Padrão Observer |
|---------|-------------|-----------------|
| **Novo notificador** | Modifica `ContaBancaria` ❌ | Cria novo `Observer` ✅ |
| **Métodos Heterogêneos** | `enviarEmail()`, `enviarSMS()` | Único `atualizar()` |
| **Acoplamento** | Alto (depende de concretos) | Baixo (depende de abstrações) |
| **Princípio DIP** | Violado ❌ | Respeitado ✅ |
| **Escalabilidade** | Não escala | Escala infinitamente |
| **Testabilidade** | Difícil | Fácil (mock observers) |
| **Manutenibilidade** | Baixa | Alta |
| **Reusabilidade** | Baixa | Alta |
| **Princípio OCP** | Violado | Respeitado ✅ |

---

## 🎯 Exemplo de Uso

### Anti-padrão
```java
// ❌ Problema: Precisa conhecer todas as implementações
NotificadorEmail email = new NotificadorEmail();
NotificadorSMS sms = new NotificadorSMS();

ContaBancaria conta = new ContaBancaria(email, sms);

conta.depositar(100.0);
conta.sacar(30.0);

// Novo notificador? Modifique ContaBancaria!
```

### Padrão Observer
```java
// ✅ Solução: Desacoplado completamente
ContaBancaria conta = new ContaBancaria();

// Adicionar quantos observers quiser
conta.adicionarObservador(new NotificadorEmail());
conta.adicionarObservador(new NotificadorSMS());

// Novo notificador? Apenas adicione!
conta.adicionarObservador(new NotificadorWhatsApp());
conta.adicionarObservador(new NotificadorPush());

conta.depositar(100.0);  // Todos são notificados automaticamente!
conta.sacar(30.0);        // Sem modificar ContaBancaria!
```

### Adicionando Novo Notificador (Fácil!)

```java
public class NotificadorWhatsApp implements Observer {
    @Override
    public void atualizar(double saldo) {
        System.out.println("[WhatsApp] Seu saldo: R$ " + saldo);
    }
}

// Uso imediato, sem modificar nada!
conta.adicionarObservador(new NotificadorWhatsApp());
```

---

## ✅ Benefícios do Padrão Observer

1. **Desacoplamento Completo**: Subject não conhece implementações concretas
2. **Extensibilidade**: Adicione observers sem modificar código existente
3. **Dinamicidade**: Adicione/remova observers em tempo de execução
4. **Reusabilidade**: Mesmo observer funciona com qualquer subject
5. **Manutenibilidade**: Cada observer é independente
6. **Testabilidade**: Fácil criar mock observers para testes
7. **SOLID Compliance**: Respeita DIP e Open/Closed

---

## 📝 Anti-padrão Aplicado: Tight Coupling

O anti-padrão aqui demonstra o **anti-padrão chamado "Tight Coupling" ou "Acoplamento Forte"**. Este é um indicador de que você deveria usar o padrão Observer.

**Sinais de Alerta** (Code Smells):
- ❌ Classe modelo conhece detalhes de notificadores
- ❌ Múltiplas variáveis de dependências diferentes
- ❌ Métodos com nomes específicos (`enviarEmail`, `enviarSMS`)
- ❌ Modificação contínua para novos tipos

**Regra de Ouro**: Se você tem uma classe que precisa notificar múltiplos interessados, **use Observer Pattern**.

---

## 🔄 Fluxo de Execução

### Anti-padrão
```
1. conta.depositar(100)
2. saldo += 100
3. if (notificadorEmail != null) → enviarEmailCorrentista()
4. if (notificadorSMS != null) → enviarSMSCliente()
5. Novo tipo? Modifique contaBancaria.java
```

### Padrão Observer
```
1. conta.depositar(100)
2. saldo += 100
3. notificarObservadores()
   ├─ email.atualizar(saldo)
   ├─ sms.atualizar(saldo)
   ├─ whatsapp.atualizar(saldo)  ← Sem modificar ContaBancaria!
   └─ push.atualizar(saldo)     ← Sem modificar ContaBancaria!
```

---

## 🎓 Conclusão

O padrão Observer transforma uma arquitetura rígida e acoplada em um sistema flexível, extensível e mantível. É essencial para criar sistemas que crescem sem dor.

