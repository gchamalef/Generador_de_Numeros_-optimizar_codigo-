/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generador_de_numeros_aleatorios_umg;

import java.io.*;
import java.util.*;

/**
 *
 * @author pc01
 */
public class GENERADOR_DE_NUMEROS_ALEATORIOS_UMG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("MENU:");
            System.out.println("1. Generar numeros aleatorios");
            System.out.println("2. Mostrar numeros");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    generarNumerosAleatorios();
                    break;
                case 2:
                    mostrarYOrdenarNumeros("numeros.txt");
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, ingrese una opcion valida.");
            }
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }

    public static void generarNumerosAleatorios() {
        try {
            File file = new File("numeros.txt");
            FileWriter writer = new FileWriter(file);
            Random random = new Random();

            for (int i = 0; i < 1000000; i++) {
                int numero = random.nextInt(20000001) - 10000000;
                writer.write(numero + "\n");
            }

            writer.close();
            System.out.println("Numeros aleatorios generados y almacenados en 'numeros.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarYOrdenarNumeros(String filename) {
        try {
            File inputFile = new File(filename);
            Scanner scanner = new Scanner(inputFile);
            List<Integer> numeros = new ArrayList<>();

            while (scanner.hasNextInt()) {
                numeros.add(scanner.nextInt());
            }

            scanner.close();

            Collections.sort(numeros);

            System.out.println("Numeros ordenados:");
            for (int numero : numeros) {
                System.out.println(numero);
            }

            File outputFile = new File("numerosOrdenados.txt");
            FileWriter writer = new FileWriter(outputFile);
            for (int numero : numeros) {
                writer.write(numero + "\n");
            }
            writer.close();

            System.out.println("Numeros ordenados y almacenados en 'numerosOrdenados.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
