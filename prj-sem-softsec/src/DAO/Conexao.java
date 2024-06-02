package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

    private static Conexao instancia;
    private Connection conn;

    private Conexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/mail_sender_prj?useSSL=false";
            String user = "root";
            String password = "kali";
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // ERR00-J: Não suprimir ou ignorar exceções verificadas
            throw new RuntimeException("Erro ao conectar ao banco de dados, usuário ou senha incorretos...", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized Conexao getInstancia() {
        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }

    public Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                // Reconectar se a conexão estiver fechada
                String url = "jdbc:mysql://127.0.0.1:3306/mail_sender_prj?useSSL=false";
                String user = "root";
                String password = "kali";
                this.conn = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            // ERR00-J: Não suprimir ou ignorar exceções verificadas
            throw new RuntimeException("Erro ao reconectar ao banco de dados", e);
        }
        return conn;
    }
}
