import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    public static final int Max_historial = 100;
    public static int[] hitorialNumeros = new int[Max_historial];
    public static int[] hitorialApuestas = new int[Max_historial];
    public static boolean[] historialAciertos = new boolean[Max_historial];
    public static int historialSize = 0;

    public static Random rng = new Random();
    public static int[] numerosRojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcionMenu;
        do {
            mostrarMenu();
            opcionMenu = leerOpcion(scanner);
            ejecutarOpcion(opcionMenu, scanner);
        } while (opcionMenu != 4);

    }

    public static void mostrarMenu() {

        System.out.println("Opciones a elegir: ");
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Mostrar resultado");
        System.out.println("3. Mostrar estadística");
        System.out.println("4. Salir");
    }

    public static int leerOpcion(Scanner scanner) {
        int opcionMenuSelecionada = scanner.nextInt();
        return opcionMenuSelecionada;
    }

    public static void ejecutarOpcion(int opcionMenu, Scanner scanner) {
        switch(opcionMenu) {
            case 1:
                iniciarRonda(scanner);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }


    }
    public static void iniciarRonda(Scanner scanner) {
        leerTipoApuesta(scanner);


    }
    public static char leerTipoApuesta(Scanner scanner) {
        System.out.println("Seleccione tipo de apuesta:");
        System.out.println("P. Par");
        System.out.println("I. Impar");
        System.out.println("R. Rojo");
        System.out.println("N. Negro");
        char opcionApuesta = scanner.next().toUpperCase().charAt(0);
        return opcionApuesta;

    }




}


