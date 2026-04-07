package principal;
import customizado.CustomizadoIO;

public class Main {
    public static Banco banco = new Banco();
    public static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        banco.cadastrarUsuario("admin", "admin"); // "Cheat code"

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

            int input = CustomizadoIO.lerNumero();
            switch (input) {
            case 0:
                usuarioLogado = null;
                repetir = false;
                break;
            default:
                System.out.println("Opção inválida!");
                CustomizadoIO.aguardarEnter();
                break;
            }
        }
    }
}
