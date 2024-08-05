package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.Usuario;
import br.edu.ifg.luziania.model.UsuarioModel;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("usuario")
public class UsuarioController {

    @Inject
    Template usuarioView;

    private static UsuarioModel usuarioModel = new UsuarioModel();

    @GET
    @Path("view")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getView() {
        return usuarioView.instance();
    }

    @GET
    @Path("listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsuarios(){
        return usuarioModel.getUsuarios();
    }

    @POST
    @Path("salvar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarUsuario(Usuario usuario){
        return usuarioModel.addUsuario(usuario);
    }
}
