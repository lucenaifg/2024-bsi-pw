package br.edu.ifg.luziania.model.bo;

import br.edu.ifg.luziania.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import br.edu.ifg.luziania.model.dto.list.UsuarioListDTO;
import br.edu.ifg.luziania.model.entity.Usuario;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Dependent
public class UsuarioBO {

    @Inject
    UsuarioDAO dao;

    public List<UsuarioListDTO> getUsuarios() {
        return dao.getAllUsuario();
    }

    @Transactional
    public Response saveUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        dao.save(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario.getId()).build();
    }
}
