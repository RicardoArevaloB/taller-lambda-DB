package com.skeletonhexa.infrastructure.persistence;

import com.skeletonhexa.domain.entities.Equipo;
import com.skeletonhexa.domain.repository.Equiporepository;
import com.skeletonhexa.infrastructure.database.ConnectionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquiporepositoryImpl implements Equiporepository {
    private final ConnectionDb connection;

    public EquiporepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }

    @Override
    public void guardar(Equipo equipo) {
        String sql = "INSERT INTO equipo (id, name, yearfoundation, coach) VALUES (?, ?, ?, ?)";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, equipo.getId());
            stmt.setString(2, equipo.getName());
            stmt.setString(3, equipo.getYearfoundation());
            stmt.setString(4, equipo.getCoach());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipo buscarPorId(int id) {
        String sql = "SELECT * FROM equipo WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Equipo(rs.getInt("id"), rs.getString("name"), rs.getString("yearfoundation"), rs.getString("coach"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Equipo> listarTodos() {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipo";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                equipos.add(new Equipo(rs.getInt("id"), rs.getString("name"), rs.getString("yearfoundation"), rs.getString("coach")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipos;
    }

    @Override
    public void actualizar(Equipo equipo) {
        String sql = "UPDATE equipo SET name = ?, yearfoundation = ?, coach = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, equipo.getName());
            stmt.setString(2, equipo.getYearfoundation());
            stmt.setString(3, equipo.getCoach());
            stmt.setInt(4, equipo.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM equipo WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}