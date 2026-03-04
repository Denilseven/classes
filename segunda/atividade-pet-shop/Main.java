import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String separator = "#######";
    static List<Pet> pets = new ArrayList<Pet>();
    static List<String> racas = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        racas.add("Desconhecido");
        racas.add("Pincher");
        racas.add("Bulldog");
        racas.add("Hot-dog");

        System.out.println(separator);
        System.out.println("Bem-vindo(a) ao pet-shop!");
        System.out.println("OPÇÕES:");
        System.out.println("\t1 - Cadastrar pet.");
        System.out.println("\t2 - Listar pets.");
        System.out.println("\t3 - Editar raças.");
        System.out.println("\t4 - Sair do sistema.");

        switch (lerNumero()) {
            case 1:
                novoCadastro();
                break;
            case 2:
                System.out.println(separator);
                System.out.println("LISTAR");
                break;
            case 3:
                editarRacas();
                break;
            case 4:
                System.out.println(separator);
                System.out.println("SAIR");
                break;
            default:
                System.out.println(separator);
                System.out.println("OPÇÃO INVÁLIDA");
                scanner.nextLine();
                break;
        }
    }

    public static void novoCadastro() {
        Pet newPet = new Pet();
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;

        /* Definir o nome. */
        System.out.println(separator + "\nNOVO CADASTRO");
        System.out.print("Nome do novo pet: ");
        newPet.name = scanner.nextLine();

        /* Definir a raça. */
        while (repeat) {
            System.out.println("Raça do novo pet:");
            int i = 0;
            for (; i < racas.size(); i++)
                System.out.println("\t" + i + " - " + racas.get(i));
            System.out.println("\t" + i + " - EDITAR RAÇAS");

            int input = lerNumero();
            if (input == i) {
                editarRacas();
            } else if (input < racas.size()) {
                newPet.raca = racas.get(input);
                repeat = false;
            } else {
                System.out.println("OPÇÃO INVÁLIDA");
                scanner.nextLine();
            }
        }
    }

    public static void editarRacas() {
        Scanner scanner = new Scanner(System.in);

        boolean repeat = true;
        while (repeat) {
            System.out.println(separator + "\nEDITAR RAÇAS");
            System.out.println("OPÇÕES:");
            System.out.println("\t1 - Adicionar.");
            System.out.println("\t2 - Listar.");
            System.out.println("\t3 - Remover.");
            System.out.println("\t4 - Voltar.");

            switch (lerNumero()) {
                case 1:
                    System.out.print("Nome: ");
                    String novaRaca = scanner.nextLine();
                    racas.add(novaRaca);
                    System.out.println("Nova raça \"" + novaRaca + "\" adicionada.");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Raças:");
                    for (int i = 0; i < racas.size(); i++)
                        System.out.println("\t" + i + " - " + racas.get(i));
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("REMOVER:");
                    for (int i = 0; i < racas.size(); i++) {
                        System.out.println("\t" + i + " - " + racas.get(i));
                    }
                    int removerRacaIndex = lerNumero();
                    if (removerRacaIndex >= racas.size()) {
                        System.out.println("OPÇÃO INVÁLIDA.");
                        scanner.nextLine();
                        continue;
                    }
                    String removerRacaNome = racas.get(removerRacaIndex);
                    racas.remove(removerRacaIndex);
                    System.out.println("Raça \"" + removerRacaNome + "\" removida.");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    scanner.nextLine();
                    break;
                case 4:
                    repeat = false;
                    break;
            }
        }
    }

    public static int lerNumero() {
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
}
