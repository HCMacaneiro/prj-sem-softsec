package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CapturaRecipients {

    private Conexao conexao;

    public CapturaRecipients() {
        this.conexao = Conexao.getInstancia();
    }

    public ArrayList<Integer> getId() throws SQLException {
        ArrayList<Integer> ids = new ArrayList<>();
        String query = "SELECT user_id FROM Users";
        try (Connection conn = this.conexao.getConn();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ids.add(rs.getInt("user_id"));
            }
        }
        return ids;
    }

    public ArrayList<String> getEmail() throws SQLException {
        ArrayList<String> emails = new ArrayList<>();
        String query = "SELECT email FROM Users";
        try (Connection conn = this.conexao.getConn();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                emails.add(rs.getString("email"));
            }
        }
        return emails;
    }
}
