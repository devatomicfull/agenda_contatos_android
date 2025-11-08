package github.devatomicfull.agenda_contatos.data.model;

import java.io.Serializable;

public class Contato implements Serializable {
    private int id;
    private String email;
    private String nome;
    private String telefone;
    private String imagem;
    private int excluido;

    public Contato() {

    }

    public Contato(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public Contato(int id, String email, String nome, String telefone, String imagem, int excluido) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = imagem;
        this.excluido = excluido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getExcluido() {
        return excluido;
    }

    public void setExcluido(int excluido) {
        this.excluido = excluido;
    }
}
