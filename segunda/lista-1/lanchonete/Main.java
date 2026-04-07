package lanchonete;
import customizado.CustomizadoIO;
import java.util.ArrayList;

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
            CustomizadoIO.imprimirTitulo("LANCHONETE");
            System.out.println("1) Cadastrar lanche");
            System.out.println("2) Listar lanches");
            System.out.println("3) Registrar pedido");
            System.out.println("4) Listar pedidos");
            System.out.println("5) Sair");

            input = CustomizadoIO.lerNumero("");
            switch (input) {
                case 1:
                    cadastrarLanche();
                    break;
                case 2:
                    CustomizadoIO.imprimirTitulo("LANCHES");
                    lanches.forEach(lanche -> lanche.exibir());
                    CustomizadoIO.aguardarEnter();
                    break;
                case 3:
                    CustomizadoIO.imprimirTitulo("REGISTAR PEDIDO");
                    registrarPedido();
                    break;
                case 4:
                    CustomizadoIO.imprimirTitulo("LISTA DE PEDIDOS");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println("\nPEDIDO #" + i);
                        pedidos.get(i).lanches.forEach(lanche -> lanche.exibir());
                    }
                    System.out.println("\n" + pedidos.size() + " pedidos no total.");
                    CustomizadoIO.aguardarEnter();
                    break;
                case 5:
                    repetir = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    CustomizadoIO.aguardarEnter();
                    break;
            }
        }
    }

    public static void cadastrarLanche() {
        CustomizadoIO.imprimirTitulo("CADASTRAR LANCHE");

        String nome = CustomizadoIO.lerTexto("Nome:");
        int preco = CustomizadoIO.lerNumero("Preço:");

        if (Lanche.precoValido(preco)) {
            Lanche novoLanche = new Lanche(nome, preco);
            lanches.add(novoLanche);
            System.out.println("\nNovo lanche cadastrado com sucesso!");
        }
        else {
            System.out.println("Preço inválido; deve ser um valor positivo");
        }
        CustomizadoIO.aguardarEnter();
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

            input = CustomizadoIO.lerNumero("");
            if (input >= 0 && input < lanches.size()) {
                novoPedido.adicionarLanche(lanches.get(input));
                System.out.println("Um(a) \"" + lanches.get(input).getNome() + "\" adicionado(a).");
                CustomizadoIO.aguardarEnter();
            }
            else if (input == lanches.size()) {
                repetir = false;
                pedidos.add(novoPedido);
                System.out.println("\nNovo pedido cadastrado com sucesso!");
                CustomizadoIO.aguardarEnter();
            }
            else {
                System.out.println("Opção inválida");
                CustomizadoIO.aguardarEnter();
            }
        }
    }
}
