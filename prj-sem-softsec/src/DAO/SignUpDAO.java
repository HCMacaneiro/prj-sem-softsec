package DAO;

import Model.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpDAO {

    private Conexao conexao;
    private String query;
    private PreparedStatement ps;

    public SignUpDAO(){
        this.conexao = Conexao.getInstancia();
    }

    public void inserir(Usuario usuario){

        try{
            this.query = "INSERT INTO users(email) VALUES (?)";
            this.ps = this.conexao.getConn().prepareStatement(this.query);
            this.ps.setString(1, usuario.getEmail());
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

    }

}
