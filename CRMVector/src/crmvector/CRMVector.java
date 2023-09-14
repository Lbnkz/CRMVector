
package crmvector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class CRMVector {
    private final Connection conexao;

    public CRMVector(Connection conexao) {
        this.conexao = conexao;
    }

    public void insereCliente(String nomeCompleto, String dataNascimento, String cpf, String email, String senha) {
        String sql = "INSERT INTO cliente (id_cliente, nomecompleto, datanascimento, cpf, email, senha) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = this.conexao.prepareStatement(sql);
            UUID idCliente = UUID.randomUUID(); // Gere um UUID único para o cliente
            stm.setObject(1, idCliente);
            stm.setString(2, nomeCompleto);
            stm.setString(3, dataNascimento);
            stm.setString(4, cpf);
            stm.setString(5, email);
            stm.setString(6, senha);

            stm.executeUpdate();
            System.out.println("Inserção de cliente bem-sucedida!");
        } catch (SQLException error) {
            System.out.println("Erro ao inserir cliente: " + error.getMessage());
        }
    }

    public static void main(String[] args) {
        // Substitua estas informações com as configurações do seu banco de dados PostgreSQL
        String url = "jdbc:postgresql://localhost:5432/crmvector";
        String usuario = "postgres";
        String senha = "senai";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            CRMVector crmVector = new CRMVector(conexao);

            // Exemplo de inserção de cliente
            crmVector.insereCliente("Nome Completo", "2000/10/29", "12345678901", "email@example.com", "senha123");

            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
