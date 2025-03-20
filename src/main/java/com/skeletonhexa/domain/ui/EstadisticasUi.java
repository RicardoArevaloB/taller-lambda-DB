package com.skeletonhexa.domain.ui;

import java.util.List;
import java.util.Scanner;

import com.skeletonhexa.application.usecase.EstadisticasUsecase;
import com.skeletonhexa.domain.entities.Estadisticas;

public class EstadisticasUi {
    private final EstadisticasUsecase estadisticasUsecase;
    private final Scanner sc;

    public EstadisticasUi(EstadisticasUsecase estadisticasUsecase, Scanner sc) {
        this.estadisticasUsecase = estadisticasUsecase;
        this.sc = sc;
    }

    public void gestionarEstadisticas() {
        int estadisticasOption;
        do {
            System.out.println("\n////////////////////////////");
            System.out.println("/  Gestión de Estadísticas  /");
            System.out.println("////////////////////////////");
            System.out.println("\n1. Registrar Estadísticas");
            System.out.println("2. Actualizar Estadísticas");
            System.out.println("3. Eliminar Estadísticas");
            System.out.println("4. Listar Estadísticas");
            System.out.println("5. Buscar Estadísticas por ID");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            estadisticasOption = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (estadisticasOption) {
                case 1:
                    registrarEstadisticas();
                    break;
                case 2:
                    actualizarEstadisticas();
                    break;
                case 3:
                    eliminarEstadisticas();
                    break;
                case 4:
                    listarEstadisticas();
                    break;
                case 5:
                    buscarEstadisticasPorId();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (estadisticasOption != 0);
    }

    private void registrarEstadisticas() {
        System.out.print("Ingrese ID de las Estadísticas: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese ID del Equipo: ");
        int equipoId = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese Partidos Jugados (PJ): ");
        String pj = sc.nextLine();
        System.out.print("Ingrese Partidos Ganados (PG): ");
        String pg = sc.nextLine();
        System.out.print("Ingrese Partidos Empatados (PE): ");
        String pe = sc.nextLine();
        System.out.print("Ingrese Partidos Perdidos (PP): ");
        String pp = sc.nextLine();
        System.out.print("Ingrese Goles a Favor (GF): ");
        String gf = sc.nextLine();
        System.out.print("Ingrese Goles en Contra (GC): ");
        String gc = sc.nextLine();
        System.out.print("Ingrese Puntos Totales (TP): ");
        String tp = sc.nextLine();

        estadisticasUsecase.registrarEstadistica(id, equipoId, pj, pg, pe, pp, gf, gc, tp);
        System.out.println("Estadísticas registradas exitosamente.");
    }

    private void actualizarEstadisticas() {
        System.out.print("Ingrese ID de las Estadísticas a actualizar: ");
        int idActualizar = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese Nuevo ID del Equipo: ");
        int nuevoEquipoId = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese Nuevos Partidos Jugados (PJ): ");
        String nuevoPj = sc.nextLine();
        System.out.print("Ingrese Nuevos Partidos Ganados (PG): ");
        String nuevoPg = sc.nextLine();
        System.out.print("Ingrese Nuevos Partidos Empatados (PE): ");
        String nuevoPe = sc.nextLine();
        System.out.print("Ingrese Nuevos Partidos Perdidos (PP): ");
        String nuevoPp = sc.nextLine();
        System.out.print("Ingrese Nuevos Goles a Favor (GF): ");
        String nuevoGf = sc.nextLine();
        System.out.print("Ingrese Nuevos Goles en Contra (GC): ");
        String nuevoGc = sc.nextLine();
        System.out.print("Ingrese Nuevos Puntos Totales (TP): ");
        String nuevoTp = sc.nextLine();

        estadisticasUsecase.actualizarEstadistica(idActualizar, nuevoEquipoId, nuevoPj, nuevoPg, nuevoPe, nuevoPp, nuevoGf, nuevoGc, nuevoTp);
        System.out.println("Estadísticas actualizadas exitosamente.");
    }

    private void eliminarEstadisticas() {
        System.out.print("\nIngrese ID de las Estadísticas a eliminar: ");
        int idEliminar = sc.nextInt();
        estadisticasUsecase.EliminarEstadistica(idEliminar);
        System.out.println("\nEstadísticas eliminadas exitosamente.");
    }

    public void listarEstadisticas() {
        List<Estadisticas> estadisticasList = estadisticasUsecase.listarEstadiscas();

        if (estadisticasList.isEmpty()) {
            System.out.println("\nNo hay estadísticas registradas.");
            System.out.println("Por favor, ingrese estadísticas para poder listarlas.");
        } else {
            System.out.println("\nLista de Estadísticas:");
            System.out.println("+------+----------+-----+-----+-----+-----+-----+-----+-----+");
            System.out.println("|  ID  | Equipo ID| PJ  | PG  | PE  | PP  | GF  | GC  | TP  |");
            System.out.println("+------+----------+-----+-----+-----+-----+-----+-----+-----+");

            for (Estadisticas estadisticas : estadisticasList) {
                System.out.printf("| %-4d | %-8d | %-3s | %-3s | %-3s | %-3s | %-3s | %-3s | %-3s |\n",
                        estadisticas.getId(), estadisticas.getEquipo_id(), estadisticas.getPj(),
                        estadisticas.getPg(), estadisticas.getPe(), estadisticas.getPp(),
                        estadisticas.getGf(), estadisticas.getGc(), estadisticas.getTp());
            }

            System.out.println("+------+----------+-----+-----+-----+-----+-----+-----+-----+");
        }
    }

    private void buscarEstadisticasPorId() {
        try {
            System.out.print("Ingrese el ID de las estadísticas a buscar: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            // Buscar las estadísticas por ID
            Estadisticas estadisticas = estadisticasUsecase.buscarporId(id);

            if (estadisticas != null) {
                System.out.println("\nEstadísticas encontradas:");
                System.out.println("+------+----------+-----+-----+-----+-----+-----+-----+-----+");
                System.out.println("|  ID  | Equipo ID| PJ  | PG  | PE  | PP  | GF  | GC  | TP  |");
                System.out.println("+------+----------+-----+-----+-----+-----+-----+-----+-----+");
                System.out.printf("| %-4d | %-8d | %-3s | %-3s | %-3s | %-3s | %-3s | %-3s | %-3s |\n",
                        estadisticas.getId(), estadisticas.getEquipo_id(), estadisticas.getPj(),
                        estadisticas.getPg(), estadisticas.getPe(), estadisticas.getPp(),
                        estadisticas.getGf(), estadisticas.getGc(), estadisticas.getTp());
                System.out.println("+------+----------+-----+-----+-----+-----+-----+-----+-----+");
            } else {
                System.out.println("No se encontraron estadísticas con el ID " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar las estadísticas: " + e.getMessage());
        }
    }
}