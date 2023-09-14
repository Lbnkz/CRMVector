package crmvector;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
    private static Connection conexao;
    
    public static Connection getConexao() {
        if(conexao == null){
            try {
                String URL = "jdbc:postgresql://localhost:5432/crmvector";
                String user = "postgres";
                String password = "senai";
                
                conexao = DriverManager.getConnection(URL, user, password);
                System.out.println("SUCESSO!");
            }catch(SQLException e){
                System.out.println("DEU RUIM");
            }
        }
        return conexao;
    }
}