import java.util.Scanner;

public class Main {
    static Cookie currentCookie = new Cookie();

    public static void main(String[] args) {
        printTitle("PET-SHOP");
        int input = readFromOptions(new String[]{"Login", "Convidado", "Sair"});
        switch (input) {
            case 1:
                System.err.println("Erro: Não implementado!");
                break;
            case 2:
                currentCookie.loginType = Cookie.LoginType.GUEST;
                System.out.println(":: ENTROU COMO CONVIDADO ::");
                mainScreen(currentCookie);
                break;
            case 3:
                System.err.println("Erro: Não implementado!");
                break;
            default:
                break;
        }
    }

    public static void mainScreen(Cookie cookie) {
        int input = readFromOptions(new String[]{"Solicitar atendimento.", "Sair."});
        switch (input) {
            case 1:
                System.out.println(":: SOLICITAR ATENDIMENTO ::");
                solicitarAtendimento();
                break;
            case 2:
                currentCookie.logout();
                break;
            default:
                break;
        }
    }

    public static void solicitarAtendimento() {
        Pet newPet = new Pet();
        newPet.name = readText("Nome do pet?");
        newPet.peso = readNumber("Peso do pet? (em kg)");
    }

    public static void printTitle(String title) {
        int width = 40;
        printSeparator();
        System.out.println(" ".repeat((width / 2) - (title.length() / 2)) + title);
        printSeparator();
    }

    public static int readFromOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + " - " + options[i]);
        }
        return readNumber(1, options.length);
    }

    public static String readText(String message) {
        if (!message.isEmpty()) System.out.println(message);
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

    public static int readNumber() {
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

    public static int readNumber(String message) {
        System.out.println(message);
        return readNumber();
    }

    public static int readNumber(int rangeStartInclusive, int rangeEndInclusive) {
        /* TODO: DRY this function */
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        while (input == -1) {
            try {
                System.out.print("--> ");
                input = scanner.nextInt();
                if (input < rangeStartInclusive || input > rangeEndInclusive) {
                    input = -1;
                }
            } catch (Exception e) {
                scanner.next();
            }
        }
        return input;
    }

    public static void printSeparator() {
        int width = 40; /* TODO: DRY */
        System.out.println("=".repeat(width));
    }

    public static void printAndWait(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        scanner.nextLine();
    }
}