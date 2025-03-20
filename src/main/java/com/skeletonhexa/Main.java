package com.skeletonhexa;

import java.util.Scanner;
import com.skeletonhexa.infrastructure.database.ConnMySql;
import com.skeletonhexa.domain.repository.Equiporepository;
import com.skeletonhexa.repository.Equiporepository;
import com.skeletonhexa.infrastructure.persistence.ClientRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        // Crear la conexión y el repositorio para equipos
        Equiporepository equiporepository = new EquiporepositoryImpl(ConnectionMySql.crearConexion());

        // Crear el caso de uso para equipos
        EquipoUseCase equipoCasoUso = new EquipoUseCase(equipoRepositorio);

        // Scanner para la entrada de datos
        Scanner sc = new Scanner(System.in);

        // Crear la interfaz de usuario para equipos
        EquipoUI interfazEquipo = new EquipoUI(equipoCasoUso, sc);

        int opcionPrincipal;
        do {
            System.out.println("**************************");
            System.out.println("*     Menú Principal     *");
            System.out.println("**************************");
            System.out.println("\n1. Gestión de Equipos"); // Única opción
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcionPrincipal = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcionPrincipal) {
                case 1:
                    interfazEquipo.gestionarEquipos(); // Gestión de equipos
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcionPrincipal != 0);

        sc.close();
    }
}