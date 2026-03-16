import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Cookie currentCookie = new Cookie();
    static List<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public static void main(String[] args) {
        boolean repeat = true;
        while (repeat) {
            printTitle("PET-SHOP");
            int input = readFromOptions(new String[]{"Login", "Convidado", "Sair"});
            switch (input) {
                case 1:
                    System.err.println("Erro: Não implementado!");
                    break;
                case 2:
                    currentCookie.loginType = Cookie.LoginType.GUEST;
                    mainScreen(currentCookie);
                    break;
                case 3:
                    repeat = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void mainScreen(Cookie cookie) {
        boolean repeat = true;
        while (repeat) {
            String titleMessage = "TELA PRINCIPAL";
            if (cookie.loginType == Cookie.LoginType.GUEST) titleMessage = "CONVIDADO";
            if (cookie.loginType == Cookie.LoginType.ADMIN) titleMessage = "ADMINISTRAÇÃO";
            printTitle(titleMessage);

            int input = readFromOptions(new String[]{"Solicitar atendimento.", "Sair."});
            switch (input) {
                case 1:
                    printTitle("SOLICITAR ATENDIMENTO");
                    solicitarAtendimento();
                    break;
                case 2:
                    currentCookie.logout();
                    repeat = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void solicitarAtendimento() {
        Pet newPet = new Pet();
        Atendimento newAtendimento = new Atendimento();

        newPet.name = readText("Nome do pet?");
        newPet.peso = readNumber("Peso do pet? (em kg)");

        newAtendimento.pet = newPet;
        newAtendimento.dia = readNumber("Para qual dia?", 1, 31);
        newAtendimento.mes = readNumber("Para qual mês?", 1, 12);
        newAtendimento.ano = readNumber("Para qual ano?", 2000, 3000);

        atendimentos.add(newAtendimento);

        printSeparator();
        printCentered("Atendimento registrado com sucesso.");
        System.out.println("");
        printCentered(newPet.name + " (" + newPet.peso + "kg)");
        printCentered(newAtendimento.dia + "/" + newAtendimento.mes + "/" + newAtendimento.ano);
        printSeparator();
    }

    public static void printTitle(String title) {
        int width = 40;
        printSeparator();
        printCentered(title);
        printSeparator();
    }

    public static void printCentered(String text) {
        int width = 40; /* comment: Acho q eu tô exagerando na quantidade de funções pra texto kkkkkk */
        System.out.println(" ".repeat((width / 2) - (text.length() / 2)) + text);
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

    public static int readNumber(String message, int rangeStartInclusive, int rangeEndInclusive) {
        System.out.println(message);
        return readNumber(rangeStartInclusive, rangeEndInclusive);
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