package com.skeletonhexa;

import java.util.Scanner;
import com.skeletonhexa.infrastructure.database.ConnectMysqlFactory;
import com.skeletonhexa.application.usecase.EquipoUsecase;
import com.skeletonhexa.application.usecase.EstadisticasUsecase;
import com.skeletonhexa.domain.repository.Equiporepository;
import com.skeletonhexa.domain.repository.EstadisticasRepository;
import com.skeletonhexa.domain.ui.Equipoui;
import com.skeletonhexa.domain.ui.EstadisticasUi;
import com.skeletonhexa.infrastructure.persistence.EquiporepositoryImpl;
import com.skeletonhexa.infrastructure.persistence.EstadisticasrepositoryImpl;

public class Main {
    public static void main(String[] args) {
        Equiporepository repositorio = new EquiporepositoryImpl(ConnectMysqlFactory.crearConexion());
        EstadisticasRepository repository = new EstadisticasrepositoryImpl(ConnectMysqlFactory.crearConexion());

        EquipoUsecase EquipoCasodeUso = new EquipoUsecase(repositorio);
        EstadisticasUsecase EstadistcasCasoDeuso = new EstadisticasUsecase(repository);

        try (Scanner sc = new Scanner(System.in)) {
            Equipoui interfazEquipo = new Equipoui(EquipoCasodeUso, sc);
            EstadisticasUi interfazEstadisticas =new EstadisticasUi(EstadistcasCasoDeuso, sc);

            int option;

            do{
                System.out.println("**********************");
                System.out.println("*   Menu principal   *");
                System.out.println("**********************");
                System.out.println("\n1. Menu crud Equipos");
                System.out.println("2. Gestion de estadisticas por Equipo");
                System.out.println("3. Salir");
                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        interfazEquipo.gestionarEquipos();
                        break;
                        
                    case 2:
                        interfazEstadisticas.gestionarEstadisticas();
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema.....");
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema.....");
                        break;
                
                    default:
                        break;
                }




            }while (option != 4);

            sc.close();
        }
    }
}