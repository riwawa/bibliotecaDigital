package com.mycompany.bibliotecadigital.database;

import com.mycompany.bibliotecadigital.model.Material;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoBanco {

    private final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private final String USUARIO = "bia";
    private final String SENHA = "1234";

    public Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectado com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco: " + e.getMessage());
            return null;
        }
    }

    public void salvarMaterial(Material material) {
        String sql = "INSERT INTO materiais (titulo, autor, ano_publicacao, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null) {
                System.out.println("Conexão não estabelecida.");
                return;
            }

            stmt.setString(1, material.getTitulo());
            stmt.setString(2, material.getAutor());
            stmt.setInt(3, material.getAnoPublicacao());
            stmt.setString(4, material.getClass().getSimpleName());

            stmt.executeUpdate();
            System.out.println("Material salvo com sucesso no banco!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar material: " + e.getMessage());
        }
    }
}