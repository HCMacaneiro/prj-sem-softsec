package DAO;

import Model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LerCaixaDAO { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

    private static LerCaixaDAO instance; // MSC07-J: Implementação do padrão Singleton
    private Conexao conexao;

    private LerCaixaDAO() {
        this.conexao = Conexao.getInstancia();
    }

    public static synchronized LerCaixaDAO getInstance() {
        if (instance == null) {
            instance = new LerCaixaDAO();
        }
        return instance;
    }

    public ArrayList<Message> capturar(int email_id) throws SQLException {
        ArrayList<Message> caixa_postal = new ArrayList<>();
        String query = "SELECT * FROM messages WHERE recipient_id = ?";
        try (Connection conn = this.conexao.getConn();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // IDS00-J: Prevenção de SQL Injection ao usar PreparedStatement
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
            // ERR00-J: Não suprimir ou ignorar exceções verificadas
            throw ex;
        }
        return caixa_postal;
    }
}
