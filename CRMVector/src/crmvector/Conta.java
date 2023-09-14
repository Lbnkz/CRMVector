package crmvector;


import java.util.UUID;

public class Conta {


    public Conta(UUID id, String senha) {
        this.id = id;

        this.senha = senha;
    }

    private UUID id;
    private String senha;


    public String getSenha() {
        return senha;
    }
    public UUID getId() {
        return id;
    }

}