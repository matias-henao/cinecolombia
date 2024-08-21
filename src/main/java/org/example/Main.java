package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner leerTeclado = new Scanner(System.in);

        // lista para almacenar las pelis
        ArrayList<HashMap<String, Object>> peliculas = new ArrayList<>();

        // CREANDO EL MENU DE OPCIONES
        int opcionElegida;

        do {
            //menú de opciones
            System.out.println("GESTIÓN DE PELÍCULAS");
            System.out.println("******************************************");
            System.out.println("1. Agregar película");
            System.out.println("2. Buscar todas las películas");
            System.out.println("3. Buscar película por nombre");
            System.out.println("4. Modificar información de una película");
            System.out.println("5. Salir");
            System.out.println("******************************************");


            System.out.print("Elige una opción: ");
            opcionElegida = leerTeclado.nextInt();

            //LIMPIAMOS EL BUFFER
            leerTeclado.nextLine();


            if (opcionElegida == 1) {
                System.out.println("Agregando una nueva película");

                //DATOS DE LA PELI
                System.out.print("Nombre de la película: ");
                String nombre = leerTeclado.nextLine();
                System.out.print("Duración: ");
                String duracion = leerTeclado.nextLine();
                System.out.print("Clasificación: ");
                String clasificacion = leerTeclado.nextLine();
                System.out.print("Sinopsis: ");
                String sinopsis = leerTeclado.nextLine();
                System.out.print("Fecha de estreno: ");
                String fechaPelicula = leerTeclado.nextLine();
                LocalDate fechaEstreno = LocalDate.parse(fechaPelicula);  // CONVERTI LA FECHA A LOCALDATE

                int idPelicula = new Random().nextInt(100);


                HashMap<String, Object> pelicula = new HashMap<>();
                pelicula.put("id",idPelicula);
                pelicula.put("nombre",nombre);
                pelicula.put("duracion",duracion);
                pelicula.put("clasificacion",clasificacion);
                pelicula.put("sinopsis",sinopsis);
                pelicula.put("fechaEstreno",fechaEstreno);

                //LLENANDO EL ARREGLO
                peliculas.add(pelicula);

            } else if (opcionElegida == 2) {
                //Para mostrar todas las películas
                System.out.println("Mostrando todas las películas");
                for (HashMap<String, Object> pelicula : peliculas) {
                    System.out.println(pelicula);
                }

            } else if (opcionElegida == 3) {
                //Para buscar una peli por nombre
                System.out.println("Buscar película por nombre");
                System.out.print("Ingresa el nombre de la película que quieres buscar: ");
                String nombreBuscado = leerTeclado.nextLine();

                // para encontrar la peli
                for (HashMap<String, Object> pelicula : peliculas) {
                    if (nombreBuscado.equals(pelicula.get("nombre"))) {
                        System.out.println("Película encontrada:");
                        System.out.println(pelicula);
                    }
                }

            } else if (opcionElegida == 4) {
                // Modificar la info
                System.out.println("Modificar información de una película");
                System.out.print("Ingresa el nombre de la película que quieres modificar: ");
                String nombreBuscado = leerTeclado.nextLine();


                for (HashMap<String, Object> pelicula : peliculas) {
                    if (nombreBuscado.equals(pelicula.get("nombre"))) {
                        System.out.println("Película encontrada:");
                        System.out.println(pelicula);


                        // Modificando clasificacion
                        System.out.print("Nueva clasificación: ");
                        String nuevaClasificacion = leerTeclado.nextLine();
                        if (!nuevaClasificacion.isEmpty()) {
                            pelicula.put("clasificacion", nuevaClasificacion);
                        }

                        System.out.println("Película actualizada:");
                        System.out.println(pelicula);
                    }
                }

            } else if (opcionElegida == 5) {
                System.out.println("Saliendo del programa");

            } else {

                System.out.println("Opción inválida, profe que te pasa.");
            }

        } while (opcionElegida != 5);  // El bucle se ejecuta hasta que el usuario elija salir


    }
}







