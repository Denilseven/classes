import java.util.ArrayList;
import java.util.Scanner;

public class Lanche {
    private String nome;
    private int preco;

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }

    public void setPreco(int preco) { if (precoValido(preco)) this.preco = preco; }
    public int getPreco() { return this.preco; }

    public Lanche(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void exibir() {
        System.out.println(this.nome + " --- R$ " + this.preco);
    }

    public static boolean precoValido(int preco) {
        return (preco >= 0);
    }
}

public class Pedido {
    public ArrayList<Lanche> lanches;

    public Pedido() {
        this.lanches = new ArrayList<Lanche>();
    }

    public void adicionarLanche(Lanche lanche) {
        lanches.add(lanche);
    }
}

public class Main {
    public static ArrayList<Lanche> lanches = new ArrayList<Lanche>();
    public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public static void main(String[] args) {
        lanches.add(new Lanche("Baguncinha", 7));
        lanches.add(new Lanche("Açaí Pote", 20));
        lanches.add(new Lanche("Água de Coco", 4));
        lanches.add(new Lanche("Mini-pizza", 5));

        boolean repetir = true;
        int input = -1;
        while (repetir) {
            imprimirTitulo("LANCHONETE");
            System.out.println("1) Cadastrar lanche");
            System.out.println("2) Listar lanches");
            System.out.println("3) Registrar pedido");
            System.out.println("4) Listar pedidos");
            System.out.println("5) Sair");

            input = lerNumero("");
            switch (input) {
                case 1:
                    cadastrarLanche();
                    break;
                case 2:
                    imprimirTitulo("LANCHES");
                    lanches.forEach(lanche -> lanche.exibir());
                    aguardarEnter();
                    break;
                case 3:
                    imprimirTitulo("REGISTAR PEDIDO");
                    registrarPedido();
                    break;
                case 4:
                    imprimirTitulo("LISTA DE PEDIDOS");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println("\nPEDIDO #" + i);
                        pedidos.get(i).lanches.forEach(lanche -> lanche.exibir());
                    }
                    System.out.println("\n" + pedidos.size() + " pedidos no total.");
                    aguardarEnter();
                    break;
                case 5:
                    repetir = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    aguardarEnter();
                    break;
            }
        }
    }

    public static void cadastrarLanche() {
        imprimirTitulo("CADASTRAR LANCHE");

        String nome = lerTexto("Nome:");
        int preco = lerNumero("Preço:");

        if (Lanche.precoValido(preco)) {
            Lanche novoLanche = new Lanche(nome, preco);
            lanches.add(novoLanche);
            System.out.println("\nNovo lanche cadastrado com sucesso!");
        }
        else {
            System.out.println("Preço inválido; deve ser um valor positivo");
        }
        aguardarEnter();
    }

    public static void registrarPedido() {
        Pedido novoPedido = new Pedido();

        boolean repetir = true;
        int input = -1;
        while (repetir) {
            System.out.println("\nEscolha um lanche para adicionar ao pedido:");

            int i = 0;
            for (; i < lanches.size(); i++) {
                System.out.println(i + ") " + lanches.get(i).getNome() + " --- R$ " + lanches.get(i).getPreco());
            }
            System.out.println(i + ") FINALIZAR PEDIDO");

            input = lerNumero("");
            if (input >= 0 && input < lanches.size()) {
                novoPedido.adicionarLanche(lanches.get(input));
                System.out.println("Um(a) \"" + lanches.get(input).getNome() + "\" adicionado(a).");
                aguardarEnter();
            }
            else if (input == lanches.size()) {
                repetir = false;
                pedidos.add(novoPedido);
                System.out.println("\nNovo pedido cadastrado com sucesso!");
                aguardarEnter();
            }
            else {
                System.out.println("Opção inválida");
                aguardarEnter();
            }
        }
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
}
