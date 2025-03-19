package com.skeletonhexa.application.usecase;

import java.util.List;

import com.skeletonhexa.domain.entities.Equipo;
import com.skeletonhexa.domain.repository.Equiporepository;

public class EquipoUsecase {
    private final Equiporepository repository;
    

    public EquipoUsecase(Equiporepository repository){
        this.repository = repository;
    }

    public void registrarEquipo(int id, String name, String yearfoundation, String coach){
        Equipo equipo = new Equipo(id, name, yearfoundation, coach);
        repository.guardar(equipo);
    }

    public Equipo obtenerEquipo(int id){
        return repository.buscarPorId(id);
    }

    public List<Equipo> listarEquipos(){
        return repository.listarTodos();
    }

    public void actualizarEquipo(int id, String name, String yearfoundation, String coach){
        Equipo equipo = new Equipo(id, name, yearfoundation, coach);
        repository.actualizar(equipo);
    }

}
