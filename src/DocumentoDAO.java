package com.ia.asistente.dao;

import com.ia.asistente.model.Documento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDAO {
    private Connection conexion;

    public DocumentoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarDocumento(Documento documento) throws SQLException {
        String sql = "INSERT INTO documentos (nombre, contenido) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, documento.getNombre());
            stmt.setString(2, documento.getContenido());
            stmt.executeUpdate();
        }
    }

    public Documento obtenerDocumento(int id) throws SQLException {
        String sql = "SELECT * FROM documentos WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Documento documento = new Documento();
                    documento.setId(rs.getInt("id"));
                    documento.setNombre(rs.getString("nombre"));
                    documento.setContenido(rs.getString("contenido"));
                    return documento;
                }
            }
        }
        return null;
    }

    public List<Documento> obtenerTodosLosDocumentos() throws SQLException {
        List<Documento> documentos = new ArrayList<>();
        String sql = "SELECT * FROM documentos";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Documento documento = new Documento();
                documento.setId(rs.getInt("id"));
                documento.setNombre(rs.getString("nombre"));
                documento.setContenido(rs.getString("contenido"));
                documentos.add(documento);
            }
        }
        return documentos;
    }

    public void actualizarDocumento(Documento documento) throws SQLException {
        String sql = "UPDATE documentos SET nombre = ?, contenido = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, documento.getNombre());
            stmt.setString(2, documento.getContenido());
            stmt.setInt(3, documento.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarDocumento(int id) throws SQLException {
        String sql = "DELETE FROM documentos WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void cerrarConexion() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }
}
