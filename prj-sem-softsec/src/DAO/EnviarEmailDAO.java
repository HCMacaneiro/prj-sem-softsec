package DAO;

import Model.Message;
import Model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnviarEmailDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public EnviarEmailDAO(){
        this.conexao = Conexao.getInstancia();
    }

    public void inserir(Message message){

        try{
            this.query = "INSERT INTO message(sender_id, recipient_id, subject, body) VALUES (?, ?, '?', '?')";
            this.ps = this.conexao.getConn().prepareStatement(this.query);
            this.ps.setString(1, String.valueOf(message.getSender_id()));
            this.ps.setString(1, String.valueOf(message.getRecipient_id()));
            this.ps.setString(1, String.valueOf(message.getSubject()));
            this.ps.setString(1, String.valueOf(message.getBody()));
            this.ps.executeUpdate();
            this.ps.close();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
