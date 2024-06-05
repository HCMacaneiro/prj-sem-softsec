// é necessário inserir um novo usuário também no B.D,
//      para que este tenha um ID que será anexado aos emails

package DAO;

import Model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDAO {

    public static SignUpDAO instancia;
    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public SignUpDAO(){
        this.conexao = Conexao.getInstancia();
    }

    public static synchronized SignUpDAO getInstancia() {
        if (instancia == null) {
            instancia = new SignUpDAO();
        }
        return instancia;
    }

    public void inserir(Usuario usuario){

        try{
            this.query = "INSERT INTO users(email) VALUES (?)";
            this.ps = this.conexao.getConn().prepareStatement(this.query);
            this.ps.setString(1, usuario.getEmail());
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
