#Atividade 01
## Primeiro Texto
What precisely do we mean by software engineering? What distinguishes “software engineering” from “programming” or “computer science”? And why would Google have a unique perspective to add to the corpus of previous 
software engineering literature written over the past 50 years?
 
The terms “programming” and “software engineering” have been used interchangeably for quite some time in our industry, although each term has a different emphasis and different implications. University students tend 
to study computer science and get jobs writing code as “programmers.”
 
“Software engineering,” however, sounds more serious, as if it implies the application of some theoretical knowledge to build something real and precise. Mechanical engineers, civil engineers, aeronautical 
engineers, and those in other engineering disciplines all practice engineering. They all work in the real world and use the application of their theoretical knowledge to create something real. Software engineers 
also create “something real,” though it is less tangible than the things other engineers create.
 
Unlike those more established engineering professions, current software engineering theory or practice is not nearly as rigorous. Aeronautical engineers must follow rigid guidelines and practices, because errors in 
their calculations can cause real damage; programming, on the whole, has traditionally not followed such rigorous practices. But, as software becomes more integrated into our lives, we must adopt and rely on more 
rigorous engineering methods. We hope this book helps others see a path toward more reliable software practices.

## Segundo Texto
Programming Over Time
We propose that “software engineering” encompasses not just the act of writing code, but all of the tools and processes an organization uses to build and maintain that code over time. What practices can a software 
organization introduce that will best keep its code valuable over the long term? How can engineers make a codebase more sustainable and the software engineering discipline itself more rigorous? We don’t have 
fundamental answers to these questions, but we hope that Google’s collective experience over the past two decades illuminates possible paths toward finding those answers.
 
One key insight we share in this book is that software engineering can be thought of as “programming integrated over time.” What practices can we introduce to our code to make it sustainable—able to react to 
necessary change—over its life cycle, from conception to introduction to maintenance to deprecation?
 
The book emphasizes three fundamental principles that we feel software organizations should keep in mind when designing, architecting, and writing their code:
 
Time and Change
How code will need to adapt over the length of its life
 
Scale and Growth
How an organization will need to adapt as it evolves
 
Trade-offs and Costs
How an organization makes decisions, based on the lessons of Time and Change and Scale and Growth

## Resumo Primeiro texto
-Primeiro Paragrafo: O autor começa com alguns questionamentos sobre oq é significa Eng software, o que distingue ela de programação e ciencia da computação, porque a google teria uma perspectiva unica para adicionar o seu texto algo que foi escrito por 50 anos sobre eng software.
-Segundo Paragrafo: Indica que a engenharia de software diferente da programação, ela é mais séria e teórica, atuando em situações reais, já a programação você só programa.
-Terceiro Paragrafo: Diferente de outras engenharias que demandam mais seriedade e rigor em seus calculos( por serem atividades de risco), a engenharia de software é algo mais "tranquilo" pois não demanda o mesmo 
rigor, mas quanto mais essas atividades estão ligadas ao nosso dia-dia, mais elas são necessárias

## Resumo Segundo Texto
-Primeiro Paragrafo: A engenharia de software não se define apenas como "Escrever código", mas sim a manutenção e as ferrramentas para manter o código funcionando como 
posso manter o software bom e sustentavel por um longo tempo?
Os três paramêtros principais: 
    Tempo e troca: Adaptabilidade do código de acordo com o tempo
    Escalabilidade: O quanto o escopo do projeto terá que ser alterado com o tempo
    Trade-offs(Compensação): Quanto ou oque terei que perder para ganhar em algo


# Atividade 3

## Citação dos três trade-offs
Performance vs. Complexidade:

Performance: Um sistema rápido e eficiente é desejável, mas pode exigir código complexo e difícil de manter.
Complexidade: Um código simples e fácil de entender pode ser mais lento e menos eficiente.
Exemplo: Um sistema de recomendação pode usar algoritmos complexos para fornecer resultados precisos, mas isso pode tornar o sistema lento e difícil de escalar. Um sistema mais simples pode ser mais rápido, mas pode não ser tão preciso.
Segurança vs. Usabilidade:

Segurança: Proteger dados e sistemas contra acesso não autorizado é crucial, mas pode tornar o sistema mais complicado de usar.
Usabilidade: Um sistema fácil de usar e intuitivo pode ser mais vulnerável a ataques.
Exemplo: Um sistema de autenticação com várias etapas de verificação pode ser mais seguro, mas pode ser frustrante para os usuários. Um sistema de autenticação mais simples pode ser mais fácil de usar, mas pode ser mais vulnerável a ataques.
Custo vs. Tempo de entrega:

Custo: Um sistema com mais recursos e funcionalidades pode ser mais caro para desenvolver.
Tempo de entrega: Um sistema com menos recursos pode ser desenvolvido mais rapidamente e lançado no mercado mais cedo.
Exemplo: Uma aplicação com um conjunto completo de funcionalidades pode levar mais tempo e dinheiro para desenvolver. Uma aplicação com funcionalidades básicas pode ser lançada mais rapidamente, mas pode não atender às necessidades dos usuários.


Se tivermos uma pessoa, que precisa de um veiculo para chegar até determinado local, a primeira vista o primeiro veiculo que nos vem em mente é um carro, mas e se aquela pessoa não anda grandes distancias o suficiente para precisar de um carro, aquele problema pode ser resolvido com uma bicicleta, skate, patinete, etc. Mas e se a pessoa não ter carteira de motorista? Ela não pode dirigir o carro. Ela está andando em qual terreno? Na água? Se for na água um barco/navio é a melhor opção



# Atividade 04

Em resumo o slide 57 se dá o conceito de desenvolver algo que resolva o problema do usuário desde o inicio de seu desenvolvimento, representado pelo skate evoluindo gradativamente até se tornar um carro, essa metafora é utilizada no ambiente de Desenvolvimento de software, pois com ele entendemos que temos que entregar um sistema funcional para o usuário que resolva o problema dele desde o inicio mesmo que de maneira simples e primitiva. Em contraponto temos a imagem de cima com uma roda evoluindo para um carro, essa situação representa muitas equipes que desenvolvem um projeto pensando em ir adicionando parte por parte durante o projeto o que está errado, porque pense na seguinte situação: Você está com fome e precisa se alimentar e tem os ingredientes para fazer a comida, mas ao invés de ter o fogão ou algum meio para fazer a comida você só tem uma peça do produto e não consegue montar o resto do produto porque a empresa que te vendeu falou que ia entregar o produto peça por peça, resolveu seu problema? Acho que não preciso responder.

# Atividade 05 - Código teste Casa de Aposta
# Sistema de Casa de Apostas

Sistema simples de casa de apostas futebolísticas desenvolvido em Java.

## Estrutura do Projeto

### Classe Partida
```java
package estacionamento;

public class Partida {
    private String timeCasa;
    private String timeVisitante;
    private double oddVitoriaCasa;
    private double oddEmpate;
    private double oddVitoriaVisitante;
    private String resultado; // "CASA", "EMPATE", "VISITANTE" ou null se não finalizado

    public Partida(String timeCasa, String timeVisitante, double oddVitoriaCasa, double oddEmpate, double oddVitoriaVisitante) {
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.oddVitoriaCasa = oddVitoriaCasa;
        this.oddEmpate = oddEmpate;
        this.oddVitoriaVisitante = oddVitoriaVisitante;
        this.resultado = null;
    }

    // Getters e Setters
    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public double getOddVitoriaCasa() {
        return oddVitoriaCasa;
    }

    public void setOddVitoriaCasa(double oddVitoriaCasa) {
        this.oddVitoriaCasa = oddVitoriaCasa;
    }

    public double getOddEmpate() {
        return oddEmpate;
    }

    public void setOddEmpate(double oddEmpate) {
        this.oddEmpate = oddEmpate;
    }

    public double getOddVitoriaVisitante() {
        return oddVitoriaVisitante;
    }

    public void setOddVitoriaVisitante(double oddVitoriaVisitante) {
        this.oddVitoriaVisitante = oddVitoriaVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
```

### Classe CasaDeApostas
```java
package estacionamento;

import java.util.List;
import java.util.LinkedList;

public class CasaDeApostas {
    private List<Partida> partidas = new LinkedList<Partida>();
    private double saldoCaixa = 0.0;

    public void adicionarPartida(Partida partida) {
        partidas.add(partida);
    }

    public Partida buscarPartidaPorTimes(String timeCasa, String timeVisitante) {
        for(Partida partida : partidas) {
            if(partida.getTimeCasa().equals(timeCasa) && 
               partida.getTimeVisitante().equals(timeVisitante)) {
                return partida;
            }
        }
        return null;
    }

    public List<Partida> buscarPartidasPorTime(String time) {
        List<Partida> encontradas = new LinkedList<Partida>();
        for(Partida partida : partidas) {
            if(partida.getTimeCasa().equals(time) || 
               partida.getTimeVisitante().equals(time)) {
                encontradas.add(partida);
            }
        }
        return encontradas;
    }

    public void registrarAposta(double valor, Partida partida, String resultado) {
        if (partida.getResultado() != null) {
            throw new IllegalStateException("Não é possível apostar em uma partida já finalizada");
        }
        saldoCaixa += valor;
    }

    public void finalizarPartida(Partida partida, String resultado) {
        partida.setResultado(resultado);
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public double getSaldoCaixa() {
        return saldoCaixa;
    }
}
```

### Classe Main
```java
package estacionamento;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CasaDeApostas casa = new CasaDeApostas();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== CASA DE APOSTAS ===");
            System.out.println("1. Adicionar nova partida");
            System.out.println("2. Listar todas as partidas");
            System.out.println("3. Buscar partida por times");
            System.out.println("4. Registrar aposta");
            System.out.println("5. Finalizar partida");
            System.out.println("6. Ver saldo do caixa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1:
                    System.out.print("Time da casa: ");
                    String timeCasa = scanner.nextLine();
                    System.out.print("Time visitante: ");
                    String timeVisitante = scanner.nextLine();
                    System.out.print("Odd vitória casa: ");
                    double oddCasa = scanner.nextDouble();
                    System.out.print("Odd empate: ");
                    double oddEmpate = scanner.nextDouble();
                    System.out.print("Odd vitória visitante: ");
                    double oddVisitante = scanner.nextDouble();
                    
                    Partida novaPartida = new Partida(timeCasa, timeVisitante, oddCasa, oddEmpate, oddVisitante);
                    casa.adicionarPartida(novaPartida);
                    System.out.println("Partida adicionada com sucesso!");
                    break;
                    
                case 2:
                    List<Partida> partidas = casa.getPartidas();
                    if (partidas.isEmpty()) {
                        System.out.println("Não há partidas cadastradas.");
                    } else {
                        System.out.println("\nPartidas cadastradas:");
                        for (Partida p : partidas) {
                            System.out.printf("%s vs %s (Odds: %.2f/%.2f/%.2f) - Resultado: %s%n",
                                p.getTimeCasa(), p.getTimeVisitante(),
                                p.getOddVitoriaCasa(), p.getOddEmpate(), p.getOddVitoriaVisitante(),
                                p.getResultado() != null ? p.getResultado() : "Não finalizado");
                        }
                    }
                    break;
                    
                case 3:
                    System.out.print("Time da casa: ");
                    String buscaCasa = scanner.nextLine();
                    System.out.print("Time visitante: ");
                    String buscaVisitante = scanner.nextLine();
                    
                    Partida encontrada = casa.buscarPartidaPorTimes(buscaCasa, buscaVisitante);
                    if (encontrada != null) {
                        System.out.printf("Partida encontrada: %s vs %s (Odds: %.2f/%.2f/%.2f)%n",
                            encontrada.getTimeCasa(), encontrada.getTimeVisitante(),
                            encontrada.getOddVitoriaCasa(), encontrada.getOddEmpate(),
                            encontrada.getOddVitoriaVisitante());
                    } else {
                        System.out.println("Partida não encontrada.");
                    }
                    break;
                    
                case 4:
                    System.out.print("Time da casa: ");
                    String apostaCasa = scanner.nextLine();
                    System.out.print("Time visitante: ");
                    String apostaVisitante = scanner.nextLine();
                    System.out.print("Valor da aposta: R$ ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Resultado apostado (CASA/EMPATE/VISITANTE): ");
                    String resultadoAposta = scanner.nextLine();
                    
                    Partida partidaAposta = casa.buscarPartidaPorTimes(apostaCasa, apostaVisitante);
                    if (partidaAposta != null) {
                        try {
                            casa.registrarAposta(valor, partidaAposta, resultadoAposta);
                            System.out.println("Aposta registrada com sucesso!");
                        } catch (IllegalStateException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Partida não encontrada.");
                    }
                    break;
                    
                case 5:
                    System.out.print("Time da casa: ");
                    String finalCasa = scanner.nextLine();
                    System.out.print("Time visitante: ");
                    String finalVisitante = scanner.nextLine();
                    System.out.print("Resultado final (CASA/EMPATE/VISITANTE): ");
                    String resultadoFinal = scanner.nextLine();
                    
                    Partida partidaFinal = casa.buscarPartidaPorTimes(finalCasa, finalVisitante);
                    if (partidaFinal != null) {
                        casa.finalizarPartida(partidaFinal, resultadoFinal);
                        System.out.println("Partida finalizada com sucesso!");
                    } else {
                        System.out.println("Partida não encontrada.");
                    }
                    break;
                    
                case 6:
                    System.out.printf("Saldo atual do caixa: R$ %.2f%n", casa.getSaldoCaixa());
                    break;
                    
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
```

### Classe Teste
```java
package estacionamento;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

class Teste {
    @Test
    void testAdicionarPartida() {
        CasaDeApostas casa = new CasaDeApostas();
        Partida partida = new Partida("Flamengo", "Vasco", 1.5, 3.2, 4.0);
        
        casa.adicionarPartida(partida);
        assertEquals(1, casa.getPartidas().size());
    }

    @Test
    void testBuscarPartida() {
        CasaDeApostas casa = new CasaDeApostas();
        Partida partida = new Partida("Flamengo", "Vasco", 1.5, 3.2, 4.0);
        casa.adicionarPartida(partida);
        
        Partida encontrada = casa.buscarPartidaPorTimes("Flamengo", "Vasco");
        assertNotNull(encontrada);
        assertEquals("Flamengo", encontrada.getTimeCasa());
        assertEquals("Vasco", encontrada.getTimeVisitante());
    }

    @Test
    void testRegistrarAposta() {
        CasaDeApostas casa = new CasaDeApostas();
        Partida partida = new Partida("Flamengo", "Vasco", 1.5, 3.2, 4.0);
        casa.adicionarPartida(partida);
        
        casa.registrarAposta(100.0, partida, "CASA");
        assertEquals(100.0, casa.getSaldoCaixa());
    }

    @Test
    void testApostaPartidaFinalizada() {
        CasaDeApostas casa = new CasaDeApostas();
        Partida partida = new Partida("Flamengo", "Vasco", 1.5, 3.2, 4.0);
        casa.adicionarPartida(partida);
        
        casa.finalizarPartida(partida, "CASA");
        
        assertThrows(IllegalStateException.class, () -> {
            casa.registrarAposta(100.0, partida, "CASA");
        });
    }

    @Test
    void testBuscarPartidasPorTime() {
        CasaDeApostas casa = new CasaDeApostas();
        casa.adicionarPartida(new Partida("Flamengo", "Vasco", 1.5, 3.2, 4.0));
        casa.adicionarPartida(new Partida("Flamengo", "Botafogo", 1.6, 3.1, 3.9));
        casa.adicionarPartida(new Partida("Palmeiras", "São Paulo", 1.8, 3.0, 3.5));
        
        List<Partida> partidasFlamengo = casa.buscarPartidasPorTime("Flamengo");
        assertEquals(2, partidasFlamengo.size());
    }

    @Test
    void testFinalizarPartida() {
        CasaDeApostas casa = new CasaDeApostas();
        Partida partida = new Partida("Flamengo", "Vasco", 1.5, 3.2, 4.0);
        casa.adicionarPartida(partida);
        
        casa.finalizarPartida(partida, "CASA");
        assertEquals("CASA", partida.getResultado());
    }
} 

