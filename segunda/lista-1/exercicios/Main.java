/*
 * Lista de Exercícios - POO
 * Prof: Diego Alves
 * Aluno: Denilson
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Carro> carros = new ArrayList<Carro>();
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public static void main(String[] args) {
        carros.add(new Carro("Wolfsagen", "AT09", 2010));
        carros.add(new Carro("Tóiot", "Horizon", 2017));
        carros.add(new Carro("Ronday", "Koloral", 1930));
        carros.add(new Carro("Wamaha", "Miku", 2007));
        carros.add(new Carro("Wario's", "Bowser", 1985));

        carros.forEach(carro -> carro.exibir());
        // Esse `forEach` é bem parecido com isso:
        // https://github.com/Denilseven/breakout-cppcon2014/blob/9e3c0501ea61c9fc66f6c6a5618a0dd92c3874cc/main.cxx#L363

        Carro.imprimirTotal();



        int x;
        { // (Dá pra definir escopos só usando {} mas parece bem estranho kk)
            x = 10; // Essa variável é acessível aqui
            int g; // Variável definida dentro desse escopo, e será destruída no final dele ...
        }
        // ... A variável `g` já não é mais acessível aqui
        System.out.println(x);



        int a = 10;
        int b = a; // Definindo o valor de `b` para o valor que está em `a`, 10
        b = 99;
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 99
        // Alterar `b` não alterou o valor de `a`



        Carro c1 = new Carro("Fiat", "Uno", 2020);
        Carro c2 = c1; // Definindo o valor de `c2` para o endereço de `c1`
        c2.setModelo("Palio");
        System.out.println(c1.getModelo()); // Palio
        System.out.println(c2.getModelo()); // Palio
        // `Carro` não é um objeto primitivo como `int`, ele é alocado no Heap
        // A variável `c2` passa a apontar para o mesmo endereço Heap que `c1`
        // Sendo assim, ambos `c1` e `c2` compartilham do mesmo objeto, referenciando à mesma coisa
        // (Objetos primitivos são alocados no Stack ao invés do Heap)



        Carro meuCarro = new Carro("VW", "Gol", 2015);
        trocarModelo(meuCarro); // Aqui nós estamos passando uma referência para `meuCarro`
        System.out.println(meuCarro.getModelo()); // Fusca



        clientes.add(new Cliente("Yudi", "yudi@email.com", "4002-8922"));
        clientes.add(new Cliente("Benjamin", "benjamin@email.com"));
        clientes.add(new Cliente("Carmen"));

        clientes.forEach(cliente -> cliente.exibir());



        boolean repetir = true;
        int input = -1;
        while (repetir) {
            imprimirTitulo("MENU PRINCIPAL");
            System.out.println("1) Cadastrar Carro");
            System.out.println("2) Listar todos");
            System.out.println("3) Total cadastrado");
            System.out.println("4) Sair");

            input = lerNumero("");
            switch (input) {
                case 1:
                    cadastrarCarro();
                    break;
                case 2:
                    carros.forEach(carro -> carro.exibir());
                    aguardarEnter();
                    break;
                case 3:
                    Carro.imprimirTotal();
                    aguardarEnter();
                    break;
                case 4:
                    repetir = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    aguardarEnter();
                    break;
            }
        }
    }

    public static void trocarModelo(Carro c) {
        c.setModelo("Fusca");
        // `c` aponta para uma referência do objeto passado, e não à uma cópia dele
    }

    public static void imprimirTitulo(String titulo) {
        System.out.println("=".repeat(titulo.length() + 2));
        System.out.println(" " + titulo + " ");
        System.out.println("=".repeat(titulo.length() + 2));
    }

    public static void aguardarEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\u001B[47m"); // Código ANSI para deixar o fundo em branco
        System.out.print("\u001B[30m"); // Código ANSI para deixar o texto em preto
        System.out.print("Pressione ENTER para continuar ...");
        System.out.print("\u001B[0m\n"); // Código ANSI para limpar as formatações
        scanner.nextLine();
    }

    // Reutilizando esse aqui:
    // https://github.com/Denilseven/classes/blob/722ea081c27d224d542ea1a543171494101675d4/segunda/atividade-pet-shop/Main.java#L133
    public static int lerNumero(String mensagem) {
        if (!mensagem.isEmpty())
            System.out.println(mensagem);
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        while (input == -1) {
            try {
                System.out.print("--> ");
                input = scanner.nextInt();
            } catch (Exception e) {
                scanner.next();
            }
        }
        return input;
    }

    // Reutilizando esse aqui:
    // https://github.com/Denilseven/classes/blob/722ea081c27d224d542ea1a543171494101675d4/segunda/pet-shop-2/Main.java#L147-L160
    public static String lerTexto(String mensagem) {
        if (!mensagem.isEmpty())
            System.out.println(mensagem);
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (input.isEmpty()) {
            try {
                System.out.print("--> ");
                input = scanner.nextLine();
            } catch (Exception e) {
                scanner.next();
            }
        }
        return input;
    }

    public static void cadastrarCarro() {
        imprimirTitulo("CADASTRAR CARRO");

        String marca = lerTexto("Marca:");
        String modelo = lerTexto("Modelo:");
        int ano = lerNumero("Ano:");

        if (Carro.anoValido(ano)) {
            Carro novoCarro = new Carro(marca, modelo, ano);
            carros.add(novoCarro);
            System.out.println("\nNovo carro cadastrado com sucesso!");
            novoCarro.exibir();
        }
        else {
            System.out.println("Erro: ano inválido, deve ser entre " + Carro.ANO_MUITO_ANTIGO + " e " + Carro.ANO_MUITO_RECENTE);
        }

        aguardarEnter();
    }
}
