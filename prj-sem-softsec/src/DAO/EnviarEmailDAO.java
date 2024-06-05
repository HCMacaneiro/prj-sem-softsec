package DAO;

import Model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnviarEmailDAO {

    private Conexao conexao;

    public EnviarEmailDAO(){
        this.conexao = Conexao.getInstancia(); // MSC07-J: uso do Singleton
    }

    public void inserir(Message message) throws SQLException {
        String query = "INSERT INTO messages(sender_id, recipient_id, subject, body) VALUES (?, ?, ?, ?)";
        try (Connection conn = this.conexao.getConn();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, message.getSender_id());
            ps.setInt(2, message.getRecipient_id());
            ps.setString(3, message.getSubject());
            ps.setString(4, message.getBody());
            ps.executeUpdate();
        } catch (SQLException ex) {
            // ERR00-J: não suprimir ou ignorar exceções verificadas
            throw ex;
        }
    }
}
