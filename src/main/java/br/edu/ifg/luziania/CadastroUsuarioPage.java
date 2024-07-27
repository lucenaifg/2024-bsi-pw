package br.edu.ifg.luziania;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("page/usuario")
public class CadastroUsuarioPage {

    @Inject
    Template usuario;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getPage() {
        return usuario.instance();
    }
}
