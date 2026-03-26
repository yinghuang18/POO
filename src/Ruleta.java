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

        System.out.println("Opciones a elegir: ");
        System.out.println("1. Tipo de apuesta");
        System.out.println("2. ");

    }

    public int mostrarMenu() {
        String respuesta = scanner.nextLine();
        int opcion = Integer.parseInt(respuesta);
        return opcion;
    }

    public int leerOpcion(Scanner in) {
        String[] seleccion = new String[5];
        int i = opcion;


        return 0;
    }
    public static void ejecutarOpcion(int opcion, Scanner in) {


    }




}


