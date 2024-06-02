package Model;

import DAO.Conexao;

public class Usuario { // DCL01-J: Não reutilizar identificadores públicos da Java Standard Library

    private String email;

    public Usuario(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
}