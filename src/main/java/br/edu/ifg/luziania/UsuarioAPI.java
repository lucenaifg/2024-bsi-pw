package br.edu.ifg.luziania;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("api/usuario")
public class UsuarioAPI {

    //Simulação de banco de dados
    private static List<Usuario> usuarios = new ArrayList<Usuario>();

    @GET
    @Path("ola")
    @Produces(MediaType.TEXT_PLAIN)
    public String ola(){
        return "Olá";
    }

    @GET
    @Path("listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsuarios(){
        return usuarios;
    }

    @POST
    @Path("salvar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarUsuario(Usuario usuario){
        // Simples lógica para definir um ID
        usuario.setId(usuarios.size() + 1);
        usuarios.add(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }



}
