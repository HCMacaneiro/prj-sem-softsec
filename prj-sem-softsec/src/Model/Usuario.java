package Model;

import DAO.Conexao;

public class Usuario {

    private String email;

    public Usuario(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
}