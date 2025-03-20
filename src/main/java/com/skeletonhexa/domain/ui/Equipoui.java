package com.skeletonhexa.domain.ui;

import java.util.List;
import java.util.Scanner;

import com.skeletonhexa.application.usecase.*;
import com.skeletonhexa.domain.entities.Equipo;

public class Equipoui {
    private final EquipoUsecase equipoUseCase;
    private final Scanner sc;

    public Equipoui(EquipoUsecase equipoUseCase, Scanner sc) {
        this.equipoUseCase = equipoUseCase;
        this.sc = sc;
    }

    public void gestionarEquipos() {
        int equipoOption;
        do {
            System.out.println("\n////////////////////////////");
            System.out.println("/    Gestión de Equipos    /");
            System.out.println("////////////////////////////");
            System.out.println("\n1. Registrar Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Eliminar Equipo");
            System.out.println("4. Listar Equipos");
            System.out.println("5. Buscar Equipo por ID");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Ingrese su opción: ");
            equipoOption = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (equipoOption) {
                case 1:
                    registrarEquipo();
                    break;
                case 2:
                    actualizarEquipo();
                    break;
                case 3:
                    eliminarEquipo();
                    break;
                case 4:
                    listarEquipos();
                    break;
                case 5:
                    buscarEquipoPorId();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (equipoOption != 0);
    }

    private void registrarEquipo() {
        System.out.print("Ingrese ID del Equipo: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese Año de Fundación: ");
        String yearFoundation = sc.nextLine();
        System.out.print("Ingrese Nombre del Entrenador: ");
        String coach = sc.nextLine();

        equipoUseCase.registrarEquipo(id, nombre, yearFoundation, coach);
        System.out.println("Equipo registrado exitosamente.");
    }

    private void actualizarEquipo() {
        System.out.print("Ingrese ID del Equipo a actualizar: ");
        int idActualizar = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese Nuevo Nombre: ");
        String nuevoNombre = sc.nextLine();
        System.out.print("Ingrese Nuevo Año de Fundación: ");
        String nuevoYearFoundation = sc.nextLine();
        System.out.print("Ingrese Nuevo Entrenador: ");
        String nuevoCoach = sc.nextLine();

        equipoUseCase.actualizarEquipo(idActualizar, nuevoNombre, nuevoYearFoundation, nuevoCoach);
        System.out.println("Equipo actualizado exitosamente.");
    }

    private void eliminarEquipo() {
        System.out.print("\nIngrese ID del Equipo a eliminar: ");
        int idEliminar = sc.nextInt();
        equipoUseCase.eliminarEquipo(idEliminar);
        System.out.println("\nEquipo eliminado exitosamente.");
    }

    public void listarEquipos() {
        List<Equipo> equipos = equipoUseCase.listarEquipos();

        if (equipos.isEmpty()) {
            System.out.println("\nNo hay equipos registrados.");
            System.out.println("Por favor, ingrese equipos para poder listarlos.");
        } else {
            System.out.println("\nLista de Equipos:");
            System.out.println("+------+----------------------+-------------------+----------------------+");
            System.out.println("|  ID  |        Nombre        | Año Fundación     | Entrenador           |");
            System.out.println("+------+----------------------+-------------------+----------------------+");

            for (Equipo equipo : equipos) {
                System.out.printf("| %-4d | %-20s | %-17s | %-20s |\n",
                        equipo.getId(), equipo.getName(), equipo.getYearfoundation(), equipo.getCoach());
            }

            System.out.println("+------+----------------------+-------------------+----------------------+");
        }
    }

    private void buscarEquipoPorId() {
        try {
            System.out.print("Ingrese el ID del equipo a buscar: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            // Buscar el equipo por ID
            Equipo equipo = equipoUseCase.buscarPorId(id);

            if (equipo != null) {
                System.out.println("\nEquipo encontrado:");
                System.out.println("+------+----------------------+-------------------+----------------------+");
                System.out.println("|  ID  |        Nombre        | Año Fundación     | Entrenador           |");
                System.out.println("+------+----------------------+-------------------+----------------------+");
                System.out.printf("| %-4d | %-20s | %-17s | %-20s |\n",
                        equipo.getId(), equipo.getName(), equipo.getYearfoundation(), equipo.getCoach());
                System.out.println("+------+----------------------+-------------------+----------------------+");
            } else {
                System.out.println("No se encontró ningún equipo con el ID " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el equipo: " + e.getMessage());
        }
    }
}
