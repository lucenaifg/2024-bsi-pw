package br.edu.ifg.luziania.model.entity;

import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import jakarta.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column
    private String senha;
    @Transient
    private Boolean teste;

    //Construtores
    public Usuario() {}

    public Usuario(UsuarioDTO dto) {
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getTeste() {
        return teste;
    }

    public void setTeste(Boolean teste) {
        this.teste = teste;
    }
}