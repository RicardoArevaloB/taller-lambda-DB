package com.skeletonhexa.infrastructure.persistence;

import com.skeletonhexa.domain.entities.Estadisticas;
import com.skeletonhexa.domain.repository.EstadisticasRepository;
import com.skeletonhexa.infrastructure.database.ConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadisticasrepositoryImpl implements EstadisticasRepository {
    private final ConnectionDb connection;

    // Constructor
    public EstadisticasrepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }

    @Override
    public void guardar(Estadisticas estadisticas) {
        String sql = "INSERT INTO estadisticas (id, equipo_id, pj, pg, pe, pp, gf, gc, tp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, estadisticas.getId());
            stmt.setInt(2, estadisticas.getEquipo_id());
            stmt.setString(3, estadisticas.getPj());
            stmt.setString(4, estadisticas.getPg());
            stmt.setString(5, estadisticas.getPe());
            stmt.setString(6, estadisticas.getPp());
            stmt.setString(7, estadisticas.getGf());
            stmt.setString(8, estadisticas.getGc());
            stmt.setString(9, estadisticas.getTp());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Estadisticas buscarPorId(int id) {
        String sql = "SELECT * FROM estadisticas WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estadisticas(
                    rs.getInt("id"),
                    rs.getInt("equipo_id"),
                    rs.getString("pj"),
                    rs.getString("pg"),
                    rs.getString("pe"),
                    rs.getString("pp"),
                    rs.getString("gf"),
                    rs.getString("gc"),
                    rs.getString("tp")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estadisticas> listarTodos() {
        List<Estadisticas> estadisticasList = new ArrayList<>();
        String sql = "SELECT * FROM estadisticas";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                estadisticasList.add(new Estadisticas(
                    rs.getInt("id"),
                    rs.getInt("equipo_id"),
                    rs.getString("pj"),
                    rs.getString("pg"),
                    rs.getString("pe"),
                    rs.getString("pp"),
                    rs.getString("gf"),
                    rs.getString("gc"),
                    rs.getString("tp")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estadisticasList;
    }

    @Override
    public void atualizar(Estadisticas estadisticas) {  // Usar "atualizar" en lugar de "actualizar"
        String sql = "UPDATE estadisticas SET equipo_id = ?, pj = ?, pg = ?, pe = ?, pp = ?, gf = ?, gc = ?, tp = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, estadisticas.getEquipo_id());
            stmt.setString(2, estadisticas.getPj());
            stmt.setString(3, estadisticas.getPg());
            stmt.setString(4, estadisticas.getPe());
            stmt.setString(5, estadisticas.getPp());
            stmt.setString(6, estadisticas.getGf());
            stmt.setString(7, estadisticas.getGc());
            stmt.setString(8, estadisticas.getTp());
            stmt.setInt(9, estadisticas.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM estadisticas WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}