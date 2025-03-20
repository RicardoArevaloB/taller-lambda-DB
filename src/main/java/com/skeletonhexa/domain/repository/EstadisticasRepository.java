package com.skeletonhexa.domain.repository;

import java.util.List;

import com.skeletonhexa.domain.entities.Estadisticas;

public interface EstadisticasRepository {
    void guardar(Estadisticas estadisticas);
    Estadisticas buscarPorId (int equipo_id);
    List<Estadisticas>listarTodos();
    void atualizar(Estadisticas estadisticas);
    void eliminar(int id);
}
