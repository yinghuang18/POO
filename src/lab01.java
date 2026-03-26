import java.util.Random;
import java.util.Scanner;
public class Ruleta {
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

public static void main(String[] args) {
    menu();
}