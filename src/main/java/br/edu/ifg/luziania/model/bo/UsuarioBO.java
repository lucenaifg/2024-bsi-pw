package br.edu.ifg.luziania.model.bo;

import br.edu.ifg.luziania.model.dto.UsuarioDTO;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Dependent
public class UsuarioBO {

    //Simulação de banco de dados
    private List<UsuarioDTO> usuarioDTOS = new ArrayList<UsuarioDTO>();

    public List<UsuarioDTO> getUsuarios() {
        return usuarioDTOS;
    }

    public void setUsuarios(List<UsuarioDTO> usuarioDTOS) {
        this.usuarioDTOS = usuarioDTOS;
    }

    public Response addUsuario(UsuarioDTO usuarioDTO) {
        // Simples lógica para definir um ID
        usuarioDTO.setId(usuarioDTOS.size() + 1);
        usuarioDTOS.add(usuarioDTO);
        return Response.status(Response.Status.CREATED).entity(usuarioDTO).build();
    }
}
