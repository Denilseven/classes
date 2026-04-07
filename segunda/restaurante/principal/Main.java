package principal;
import customizado.CustomizadoIO;
import java.util.ArrayList;

public class Main {
    public static Banco banco = new Banco();
    public static Usuario usuarioLogado = null;
    public static ArrayList<String> cardapio = new ArrayList<String>();

    public static void main(String[] args) {
        banco.cadastrarUsuario("admin", "admin"); // "Cheat code"

        cardapio.add("Cachorro-Quente");
        cardapio.add("Sushi");
        cardapio.add("Pizza");
        cardapio.add("Baguncinha");

        CustomizadoIO.imprimirTitulo("LOGIN");

        boolean repetir = true;
        while (repetir) {
            String nome = CustomizadoIO.lerTexto("Usuário:");

            usuarioLogado = banco.getUsuario(nome);
            if (usuarioLogado == null)
                System.out.println("Usuário não encontrado!");
            else
                repetir = false; // Usuário encontrado, continue a execução
        }

        repetir = true;
        while (repetir) {
            String senha = CustomizadoIO.lerTexto("Senha:");

            if (usuarioLogado.validar(senha) == false) {
                System.out.println("Senha inválida!");
            }
            else {
                System.out.println("\nBem-vindo(a) de volta, " + usuarioLogado.getNome().toUpperCase() + "!");
                CustomizadoIO.aguardarEnter();
                repetir = false; // Senha validada, continue a execução
            }
        }

        repetir = true;
        while (repetir) {
            CustomizadoIO.imprimirTitulo("MENU");
            System.out.println("0) Sair");
            System.out.println("1) Exibir cardápio");
            System.out.println("2) Exibir meu carrinho");
            System.out.println("3) Adicionar item ao carrinho");
            System.out.println("4) Remover item do carrinho");

            int input = CustomizadoIO.lerNumero();
            switch (input) {
            case 0:
                usuarioLogado = null;
                repetir = false;
                break;
            case 1:
                CustomizadoIO.imprimirTitulo("CARDÁPIO");
                imprimirCardapio();
                CustomizadoIO.aguardarEnter();
                break;
            case 2:
                CustomizadoIO.imprimirTitulo("MEU CARRINHO");
                usuarioLogado.getCarrinho().forEach(item -> System.out.println(item));
                CustomizadoIO.aguardarEnter();
                break;
            case 3:
                CustomizadoIO.imprimirTitulo("ADICIONAR AO CARRINHO");
                imprimirCardapio();
                int adicionarItemIndex = CustomizadoIO.lerNumero();
                if (adicionarItemIndex >= 0 && adicionarItemIndex < cardapio.size()) {
                    usuarioLogado.adicionarAoCarrinho(cardapio.get(adicionarItemIndex));
                    System.out.println(cardapio.get(adicionarItemIndex) + " adicionado(a) ao carrinho!");
                }
                else {
                    System.out.println("Escolha inválida!");
                }
                CustomizadoIO.aguardarEnter();
                break;
            case 4:
                CustomizadoIO.imprimirTitulo("REMOVER DO CARRINHO");
                for (int i = 0; i < usuarioLogado.getCarrinho().size(); i++)
                    System.out.println(i + ") " + usuarioLogado.getCarrinho().get(i));
                int removerItemIndex = CustomizadoIO.lerNumero();
                String itemRemovido = usuarioLogado.removerDoCarrinho(removerItemIndex);
                if (itemRemovido != null)
                    System.out.println(itemRemovido + " removido com sucesso!");
                else
                    System.out.println("Escolha inválida!");
                CustomizadoIO.aguardarEnter();
                break;
            default:
                System.out.println("Opção inválida!");
                CustomizadoIO.aguardarEnter();
                break;
            }
        }
    }

    public static void imprimirCardapio() {
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println(i + " --- " + cardapio.get(i));
        }
    }
}
