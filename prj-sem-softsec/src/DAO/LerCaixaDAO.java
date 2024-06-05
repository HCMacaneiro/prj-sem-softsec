package DAO;

import Model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LerCaixaDAO {

    private static LerCaixaDAO instancia; // MSC07-J: uso do Singleton
    private Conexao conexao;

    private LerCaixaDAO() {
        this.conexao = Conexao.getInstancia();
    }

    public static synchronized LerCaixaDAO getInstancia() {
        if (instancia == null) {
            instancia = new LerCaixaDAO();
        }
        return instancia;
    }

    public ArrayList<Message> capturar(int email_id) throws SQLException {
        ArrayList<Message> caixa_postal = new ArrayList<>();
        String query = "SELECT * FROM messages WHERE recipient_id = ?";
        try (Connection conn = this.conexao.getConn();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // IDS00-J: uso do PreparedStatement evitando SQLI
            ps.setInt(1, email_id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    caixa_postal.add(new Message(
                            rs.getInt("sender_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("subject"),
                            rs.getString("body")));
                }
            }
        } catch (SQLException ex) {
            // ERR00-J: não suprimir ou ignorar exceções verificadas
            throw ex;
        }
        return caixa_postal;
    }
}
