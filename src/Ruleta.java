import java.util.Random;
import java.util.Scanner;
public class Ruleta {
    public static final int Max_historial = 100;
    public static int[] historialNumeros= new int[Max_historial];
    public static int[] historialApuestas = new int[Max_historial];
    public static boolean[] historialAciertos = new boolean[Max_historial];
    public static int historialSize = 0;

    public static Random random = new Random();
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
                girarRuleta();
                break;
            case 3:
                break;
            case 4:
                break;
        }


    }
    public static void iniciarRonda(Scanner scanner) {
        char opcionApuesta = leerTipoApuesta(scanner);
        System.out.println("Ingrese el monto que desea apostar:");
        int monto = scanner.nextInt();
        int numeroRandom = girarRuleta();
        boolean acierto = evaluarResultado(numeroRandom, opcionApuesta);
        registrarResultado(numeroRandom, monto, acierto);


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
    public static int girarRuleta() {
        int numeroRandom = random.nextInt(37);

        return numeroRandom;
    }

    public static boolean evaluarResultado(int numeroRandom, char opcionApuesta) {
        switch (opcionApuesta) {
            case 'P':
                return numeroRandom % 2 == 0;
            case 'I':
                return numeroRandom % 2 != 0;
            case 'R':
                for (int recorrer = 0; recorrer < numerosRojos.length; recorrer++) {
                    if (numerosRojos[recorrer] == numeroRandom) {
                        return true;
                    }
                }
                return false;
            case 'N':
                for (int recorrer = 0; recorrer < numerosRojos.length; recorrer++) {
                    if (numerosRojos[recorrer] == numeroRandom) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }

    }
    public static boolean esRojo(int numeroRandom) {

        for (int recorrer = 0; recorrer < numerosRojos.length; recorrer++){
            if (numeroRandom == numerosRojos[recorrer]) {
                return true;
            }
        }
        return false;
    }
    public static void registrarResultado(int numeroRandom, int monto, boolean acierto) {
        if (historialSize < Max_historial){
            historialAciertos[historialSize] = acierto;
            historialApuestas[historialSize] = monto;
            historialNumeros[historialSize] = numeroRandom;
            historialSize++;
        }


    }
    public static void mostrarResultado(int numeroRandom, char opcionApuesta, int monto, boolean acierto) {

        System.out.println("El número obtenido en la ruleta es: " + numeroRandom);
        System.out.println("El tipo de apuesta realizada es: " + opcionApuesta);
        System.out.println("El monto apostado es: " + monto);
        System.out.println("El resultado de la apuesta es:");
        if (acierto == true) {
            System.out.println("Ganaste");
        } else {
            System.out.println("Perdiste");
        }
    }





}


