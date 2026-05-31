# Strategy Pattern - Documentação Completa

## 📋 Visão Geral

O padrão **Strategy** é um padrão comportamental que define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. Ele permite que o cliente escolha qual estratégia usar em tempo de execução.

---

## 🔴 Anti-padrão: Violação do Princípio Open/Closed (OCP)

### Conceito de Anti-padrão

Um **anti-padrão** é uma solução que, aparentemente resolve um problema, mas introduz mais problemas do que resolve. No caso do Strategy anti-padrão, temos uma violação clara do **Princípio Open/Closed (OCP)** do SOLID:

- **Princípio Open/Closed**: Classes devem ser abertas para extensão, mas fechadas para modificação.

### Código Anti-padrão: `antipadrao/VagaEmprego.java`

```java
public void triarCandidatos() {
    if (tipoTriagem == TipoTriagem.EXPERIENCIA) {
        System.out.println("Triando candidatos para a vaga '" + titulo + "' baseando-se na Experiência.");
    } else if (tipoTriagem == TipoTriagem.FORMACAO) {
        System.out.println("Triando candidatos para a vaga '" + titulo + "' baseando-se na Formação Acadêmica.");
    } else if (tipoTriagem == TipoTriagem.TESTE_PRATICO) {
        System.out.println("Triando candidatos para a vaga '" + titulo + "' baseando-se em Teste Prático.");
    } else {
        System.out.println("Nenhum tipo de triagem definido para a vaga '" + titulo + "'.");
    }
}
```

### Problemas Identificados

| Problema | Descrição |
|----------|-----------|
| **Lógica Condicional Explodida** | Vários `if-else` aninhados tornam o código difícil de manter |
| **Violação do OCP** | Para adicionar um novo tipo de triagem, você PRECISA modificar a classe `VagaEmprego` |
| **Difícil de Testar** | Cada novo tipo exige testes adicionais na mesma classe |
| **Baixa Coesão** | A classe tem muitas responsabilidades (saber sobre todos os tipos de triagem) |
| **Dificuldade de Evolução** | Mudanças em um tipo de triagem afetam a classe principal |

### Estrutura do Anti-padrão

```
VagaEmprego (sabe TUDO sobre triagem)
    ├── if TipoTriagem.EXPERIENCIA → lógica aqui
    ├── if TipoTriagem.FORMACAO → lógica aqui
    ├── if TipoTriagem.TESTE_PRATICO → lógica aqui
    └── else → sem triagem
```

---

## 🟢 Padrão Strategy Correto: Princípio Open/Closed Aplicado

### Como Funciona

O padrão Strategy elimina a lógica condicional ao criar:

1. **Interface `EstrategiaTriagem`**: Define o contrato que toda estratégia deve seguir
2. **Implementações Concretas**: Cada tipo de triagem é uma classe separada
3. **Composição**: `VagaEmprego` recebe uma estratégia em tempo de execução
4. **Inversão de Dependência**: `VagaEmprego` depende da abstração, não de implementações

### Arquivo: `padrao/EstrategiaTriagem.java`

```java
public interface EstrategiaTriagem {
    void triar(String tituloVaga);
}
```

### Implementações Concretas

**`TriagemPorExperiencia.java`**
```java
public class TriagemPorExperiencia implements EstrategiaTriagem {
    @Override
    public void triar(String tituloVaga) {
        System.out.println("Triando candidatos para a vaga '" + tituloVaga + "' baseando-se na Experiência.");
    }
}
```

**`TriagemPorFormacao.java`**
```java
public class TriagemPorFormacao implements EstrategiaTriagem {
    @Override
    public void triar(String tituloVaga) {
        System.out.println("Triando candidatos para a vaga '" + tituloVaga + "' baseando-se na Formação Acadêmica.");
    }
}
```

**`TriagemPorTestePratico.java`**
```java
public class TriagemPorTestePratico implements EstrategiaTriagem {
    @Override
    public void triar(String tituloVaga) {
        System.out.println("Triando candidatos para a vaga '" + tituloVaga + "' baseando-se em Teste Prático.");
    }
}
```

### Classe Principal: `padrao/VagaEmprego.java`

```java
public class VagaEmprego {
    private String titulo;
    private EstrategiaTriagem estrategiaTriagem;

    public VagaEmprego(String titulo, EstrategiaTriagem estrategiaTriagem) {
        this.titulo = titulo;
        this.estrategiaTriagem = estrategiaTriagem;
    }

    public void setEstrategiaTriagem(EstrategiaTriagem estrategiaTriagem) {
        this.estrategiaTriagem = estrategiaTriagem;
    }

    public void triarCandidatos() {
        if (estrategiaTriagem != null) {
            estrategiaTriagem.triar(titulo);  // Delega para a estratégia!
        } else {
            System.out.println("Nenhuma estratégia de triagem definida para a vaga '" + titulo + "'.");
        }
    }
}
```

### Estrutura do Padrão

```
    ┌─────────────────────────────────┐
    │    EstrategiaTriagem (Interface)│
    │        + triar(String)          │
    └────────────────────┬────────────┘
                         │
         ┌───────────────┼───────────────┐
         │               │               │
    ┌────▼────┐    ┌────▼────┐    ┌────▼────┐
    │Triagem   │    │Triagem  │    │Triagem  │
    │Experiência│    │Formação │    │Teste    │
    └──────────┘    └─────────┘    └─────────┘
         ▲               ▲               ▲
         │               │               │
         └───────────────┼───────────────┘
                    (usa)
                         │
                  ┌──────▼──────┐
                  │VagaEmprego  │
                  │estratégia   │
                  └─────────────┘
```

---

## 📊 Comparação: Anti-padrão vs Padrão

| Aspecto | Anti-padrão | Padrão Strategy |
|---------|-------------|-----------------|
| **Adição de novo tipo** | Modifica classe existente ❌ | Cria nova classe ✅ |
| **Testabilidade** | Difícil (tudo junto) | Fácil (testes isolados) |
| **Linha de código** | Cresce exponencialmente | Cresce linearmente |
| **Princípio OCP** | Violado ❌ | Respeitado ✅ |
| **Acoplamento** | Alto | Baixo |
| **Manutenibilidade** | Baixa | Alta |
| **Reusabilidade** | Baixa | Alta |

---

## 🎯 Exemplo de Uso

### Anti-padrão
```java
VagaEmprego vaga = new VagaEmprego("Desenvolvedor Java", TipoTriagem.EXPERIENCIA);
vaga.triarCandidatos();

System.out.println("--- Alterando a forma de triagem ---");
vaga.setTipoTriagem(TipoTriagem.FORMACAO);  // Apenas muda enum
vaga.triarCandidatos();
```

### Padrão Strategy
```java
// Primeira estratégia
VagaEmprego vaga = new VagaEmprego(
    "Desenvolvedor Java", 
    new TriagemPorExperiencia()
);
vaga.triarCandidatos();

// Mudando de estratégia em tempo de execução
vaga.setEstrategiaTriagem(new TriagemPorFormacao());
vaga.triarCandidatos();

// Fácil adicionar nova estratégia sem modificar VagaEmprego
vaga.setEstrategiaTriagem(new TriagemPorTestePratico());
vaga.triarCandidatos();
```

---

## ✅ Benefícios do Padrão Strategy

1. **Flexibilidade**: Mude a estratégia em tempo de execução
2. **Extensibilidade**: Adicione novos tipos sem modificar código existente
3. **Testabilidade**: Cada estratégia é independente e fácil de testar
4. **Manutenibilidade**: Código mais organizado e limpo
5. **Reusabilidade**: Estratégias podem ser usadas em diferentes contextos
6. **SOLID Compliance**: Respeita Open/Closed e Liskov Substitution

---

## 📝 Anti-padrão Aplicado: Code Smell

O anti-padrão aqui demonstra o **"code smell" chamado `switch/case` excessivo**. Este é um indicador de que você deveria usar polimorfismo (Strategy) em vez de lógica condicional.

**Regra de Ouro**: Se você tem múltiplas condições `if-else` ou `switch-case` que variam com frequência, **use Strategy Pattern**.

