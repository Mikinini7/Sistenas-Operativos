/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaoperativo;


import java.util.Scanner;

/**
 * Programa de gestión simple de una lista usando un arreglo estático.
 * Permite agregar, eliminar, editar y mostrar elementos en memoria.
 * 
 * @author 
 */
public class SistemasOperativos {

    // Variables estáticas para manejar la lista
    static int tam;          // Tamaño máximo de la lista
    static int cont;         // Número actual de elementos en la lista
    static int opt;          // Opción del menú
    static String[] lista;   // Arreglo que almacena los elementos

    /**
     * Constructor que inicializa la lista con el tamaño especificado.
     * @param tam tamaño máximo de la lista
     */
    public SistemasOperativos(int tam) {
        SistemasOperativos.tam = tam; // Se accede a la variable estática
        lista = new String[tam];
        cont = 0;
    }

    /**
     * Método principal que despliega un menú interactivo.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el tamaño de la lista:");
        int t = sc.nextInt();

        // Crear objeto con la capacidad indicada
        SistemasOperativos so = new SistemasOperativos(t);

        String p; // variable auxiliar

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1 - Agregar");
            System.out.println("2 - Eliminar");
            System.out.println("3 - Editar");
            System.out.println("4 - Mostrar");
            System.out.println("5 - Salir");
            System.out.print("Selecciona una opción: ");

            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    if (cont < tam) {
                        System.out.print("Valor a agregar: ");
                        p = sc.next();
                        agregar(p);
                    } else {
                        System.out.println("La lista está llena, no se puede agregar más.");
                    }
                    break;
                case 2:
                    if (cont > 0) {
                        eliminar();
                    } else {
                        System.out.println("La lista está vacía, no hay nada que eliminar.");
                    }
                    break;
                case 3:
                    if (cont > 0) {
                        System.out.print("Posición a editar (0 a " + (cont - 1) + "): ");
                        int pos = sc.nextInt();
                        if (pos >= 0 && pos < cont) {
                            System.out.print("Nuevo valor: ");
                            p = sc.next();
                            editar(pos, p);
                        } else {
                            System.out.println("Posición inválida.");
                        }
                    } else {
                        System.out.println("No hay elementos para editar.");
                    }
                    break;
                case 4:
                    mostrar();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opt != 5);

        sc.close();
    }

    /**
     * Agrega un elemento al final de la lista.
     * @param p elemento a agregar
     */
    public static void agregar(String p) {
        lista[cont] = p;
        System.out.println("Dato agregado: " + p + " en posición: " + cont);
        cont++;
    }

    /**
     * Elimina el primer elemento de la lista, recorriendo los demás.
     */
    public static void eliminar() {
        System.out.println("Dato eliminado: " + lista[0]);
        for (int i = 0; i < cont - 1; i++) { 
            lista[i] = lista[i + 1];
        }
        lista[cont - 1] = null; // Limpieza de último espacio
        cont--;
    }

    /**
     * Edita un elemento en una posición específica.
     * @param pos posición en el arreglo
     * @param p nuevo valor
     */
    public static void editar(int pos, String p) {
        lista[pos] = p;
        System.out.println("Posición " + pos + " actualizada con: " + p);
    }

    /**
     * Muestra todos los elementos de la lista.
     */
    public static void mostrar() {
        if (cont == 0) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Contenido de la lista:");
            for (int i = 0; i < cont; i++) {
                System.out.println(i + " → " + lista[i]);
            }
        }
    }
}