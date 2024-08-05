package br.edu.ifg.luziania.model;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Dependent
public class UsuarioModel {

    //Simulação de banco de dados
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Response addUsuario(Usuario usuario) {
        // Simples lógica para definir um ID
        usuario.setId(usuarios.size() + 1);
        usuarios.add(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }
}
