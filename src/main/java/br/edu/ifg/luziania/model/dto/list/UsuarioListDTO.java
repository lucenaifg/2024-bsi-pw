package br.edu.ifg.luziania.model.dto.list;

public class UsuarioListDTO {

    //Atributos
    private Integer id;
    private String nome;
    private String email;

    //Construtores
    public UsuarioListDTO() {
    }

    public UsuarioListDTO(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
