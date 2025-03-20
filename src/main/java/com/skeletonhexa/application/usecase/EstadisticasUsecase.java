package com.skeletonhexa.application.usecase;

import java.util.List;

import com.skeletonhexa.domain.entities.Estadisticas;
import com.skeletonhexa.domain.repository.EstadisticasRepository;

public class EstadisticasUsecase {
 private final EstadisticasRepository repository;

 public EstadisticasUsecase(EstadisticasRepository repository){
    this.repository = repository;
 }

 public void registrarEstadistica(int id, int equipo_id, String pj, String pg, String pe, String pp, String gf, String gc,String tp){
    Estadisticas estadisticas = new Estadisticas(id, equipo_id, pj, pg, pe, pp, gf, gc, tp);
    repository.guardar(estadisticas);
 }

 public Estadisticas obtenerEstadisticas(int equipo_id){
    return repository.buscarPorId(equipo_id);
 }

 public List<Estadisticas> listarEstadiscas(){
    return repository.listarTodos();
 }

 public void actualizarEstadistica(int id, int equipo_id, String pj, String pg, String pe, String pp, String gf, String gc,String tp){
    Estadisticas estadisticas = new Estadisticas(id, equipo_id, pj, pg, pe, pp, gf, gc, tp);
    repository.atualizar(estadisticas);
 }

 public void EliminarEstadistica(int id){
    repository.eliminar(id);
 }

 public Estadisticas buscarporId(int id){
    return repository.buscarPorId(id);
 }

}
