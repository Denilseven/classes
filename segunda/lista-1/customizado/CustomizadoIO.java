package customizado;
import java.util.Scanner;

public class CustomizadoIO {
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