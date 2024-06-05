// captura o ID do usuário respectivo ao seu email cadastrado no B.D.
// o ID é necessário para colocar qual o remetente do email

package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CapturaID {

    public static CapturaRecipients instancia;
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs = null;
    int id;

    public CapturaID(){
        this.conexao = Conexao.getInstancia();
    }

    public static synchronized CapturaRecipients getInstancia() {
        if (instancia == null) {
            instancia = new CapturaRecipients();
        }
        return instancia;
    }

    public int inserir(String email){
        try{
            this.query = "SELECT user_id FROM USERS WHERE email = '" + email + "'";
            this.ps = this.conexao.getConn().prepareStatement(this.query);
            rs = this.ps.executeQuery();

            while (rs.next()) {
                id = Integer.parseInt(rs.getString("user_id"));
            }

            rs.close();
            this.ps.close();

            return id;

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return -1;
    }
}

