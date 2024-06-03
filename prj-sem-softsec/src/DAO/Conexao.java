package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String host;
    private String usuario;
    private String senha;
    private Connection conn;
    private static Conexao conex;

    private Conexao(){
        this.host = "jdbc:mysql://127.0.0.1:3306/mail_sender_prj?useSSL=false";
        this.usuario = "root";
        this.senha = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(host, usuario, senha);
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Conexao getInstancia(){
        if (conex == null){
            conex = new Conexao();
        }
        return conex;
    }

    public Connection getConn(){
        return this.conn;
    }

}
