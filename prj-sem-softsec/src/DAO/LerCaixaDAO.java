// LerCaixaDAO têm a função de capturar todos os emails respectivos ao usuário, e ordernar em uma lista de objetos "message"

package DAO;

import Model.Message;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LerCaixaDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs = null;
    int id;

    public LerCaixaDAO(){
        this.conexao = Conexao.getInstancia();
    }

    public ArrayList<Message> capturar(int email_id){
        ArrayList<Message> caixa_postal = new ArrayList<>();

        try{
            this.query = "SELECT * FROM messages WHERE recipient_id = '" + email_id + "'";
            this.ps = this.conexao.getConn().prepareStatement(this.query);
            rs = this.ps.executeQuery();

            // Captura todos os emails recebidos do usuário e ordena em ArrayList
            while (rs.next()) {
                caixa_postal.add(new Message(
                        Integer.parseInt(rs.getString("sender_id")),
                        Integer.parseInt(rs.getString("recipient_id")),
                        rs.getString("subject"),
                        rs.getString("body")));
            }

            rs.close();
            this.ps.close();

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return caixa_postal;
    }
}

