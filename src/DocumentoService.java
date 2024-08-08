package com.ia.asistente.service;

import com.ia.asistente.dao.DocumentoDAO;
import com.ia.asistente.model.Documento;
import com.ia.asistente.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DocumentoService {
    private DocumentoDAO documentoDAO;
    private Connection conexion;

    public DocumentoService() throws SQLException {
        this.conexion = DatabaseUtil.getConnection();
        this.documentoDAO = new DocumentoDAO(conexion);
    }

    public void agregarDocumento(Documento documento) throws SQLException {
        documentoDAO.insertarDocumento(documento);
    }

    public Documento obtenerDocumento(int id) throws SQLException {
        return documentoDAO.obtenerDocumento(id);
    }

    public void actualizarDocumento(Documento documento) throws SQLException {
        documentoDAO.actualizarDocumento(documento);
    }

    public void eliminarDocumento(int id) throws SQLException {
        documentoDAO.eliminarDocumento(id);
    }

    public List<Documento> obtenerTodosLosDocumentos() throws SQLException {
        return documentoDAO.obtenerTodosLosDocumentos();
    }

    public void cerrarConexion() throws SQLException {
        DatabaseUtil.closeConnection(conexion);
    }
}
