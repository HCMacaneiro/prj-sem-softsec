// captura todos os usuários e seus ID's, para listar em "EnviarEmailView"

package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CapturaRecipients {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;
    private ResultSet rs = null;

    public CapturaRecipients(){
        this.conexao = Conexao.getInstancia();
    }

    public ArrayList<Integer> getId(){
        ArrayList<Integer> id_array = new ArrayList<>();

        try{

            this.query = "SELECT user_id FROM USERS";
            this.ps = this.conexao.getConn().prepareStatement(this.query);
            rs = this.ps.executeQuery();

            while (rs.next()) {
                id_array.add(Integer.parseInt(rs.getString("user_id")));
            }
            System.out.printf(String.valueOf(id_array));

            rs.close();
            this.ps.close();

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return id_array;
    }

    public ArrayList<String> getEmail(){
        ArrayList<String> email_array = new ArrayList<String>();

        try{
            this.query = "SELECT email FROM USERS";
            this.ps = this.conexao.getConn().prepareStatement(this.query);
            rs = this.ps.executeQuery();

            while (rs.next()) {
                email_array.add(rs.getString("email"));
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

        return email_array;
    }
}