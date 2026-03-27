import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    public final int Max_historial = 100;
    public int[] hitorialNumeros = new int[Max_historial];
    public int[] hitorialApuestas = new int[Max_historial];
    public boolean[] historialAciertos = new boolean[Max_historial];
    public int historialSize = 0;

    public Random rng = new Random();
    public int[] numerosRojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    public void main(String[] args) {
        menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion(scanner);
            ejecutarOpcion(opcion, scanner);
        } while (opcion != 4);

    }

    public void mostrarMenu() {

        System.out.println("Opciones a elegir: ");
        System.out.println("1. Iniciar ronda");
        System.out.println("2. Mostrar resultado");
        System.out.println("3. Mostrar estadística");
        System.out.println("4. Salir");
    }

    public int leerOpcion(Scanner scanner) {
        String[] seleccion = new String[5];
        int i = opcion;


        return 0;
    }
    public static void ejecutarOpcion(int opcion, Scanner in) {


    }




}


