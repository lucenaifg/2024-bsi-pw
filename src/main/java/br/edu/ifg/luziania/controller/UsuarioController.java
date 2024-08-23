package br.edu.ifg.luziania.controller;

import br.edu.ifg.luziania.model.bo.UsuarioBO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import br.edu.ifg.luziania.model.dto.list.UsuarioListDTO;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("usuario")
@ApplicationScoped
public class UsuarioController {

    @Inject
    Template usuarioView;

    @Inject
    UsuarioBO usuarioBO;

    @GET
    @Path("view")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getView() {
        return usuarioView.instance();
    }

    @GET
    @Path("listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioListDTO> listarUsuarios(){
        return usuarioBO.getUsuarios();
    }

    @POST
    @Path("salvar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvarUsuario(UsuarioDTO usuarioDTO){
        return usuarioBO.saveUsuario(usuarioDTO);
    }
}
