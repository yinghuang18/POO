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

    public int menu() {

        System.out.println("Seleccione una opción:");
        System.out.println("1. Elegir tipo de apuesta");
        System.out.println("2. ");
        int opcion = scanner.nextInt();
        return opcion;
    }

    public static void mostrarMenu() {


    }
     Scanner scanner = new Scanner(System.in);
    public int tipoApuesta(){
         System.out.println("Seleccione un tipo de apuesta 1 o 2: /n 1. rojo/negro /n par/impar");
         int opcion = scanner.nextInt();
         return opcion;
    }
    public String leerTipoApuesta(int opcion) {
        if (opcion == 1) {
            return "rojo/negro";
        } else {
            return "par/impar";
        }
    }
}

