package br.edu.ifg.luziania.model.dao;

import br.edu.ifg.luziania.model.dto.list.UsuarioListDTO;
import br.edu.ifg.luziania.model.entity.Usuario;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

@Dependent
public class UsuarioDAO {

    @Inject
    EntityManager em;

    public void save(Usuario entity){
        em.persist(entity);
    }

    public void remove(Usuario entity){
        em.remove(entity);
    }

    public Usuario find(Integer id){
        return em.find(Usuario.class, id);
    }

    public Usuario getByEmail(String email){
        Query query = em.createQuery("from Usuario where email = :email");
        query.setParameter("email", email);
        return (Usuario) query.getSingleResult();
    }

    public Usuario getByEmailAndSenha(String email, String senha){
        Query query = em.createQuery("from Usuario where email = :email and senha = :senha");
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        return (Usuario) query.getSingleResult();
    }

    public List<UsuarioListDTO> getAllUsuario(){
        //language=hql
        String hql = "select " +
                "new br.edu.ifg.luziania.model.dto.list.UsuarioListDTO(u.id, u.nome, u.email) " +
                "from Usuario u";

        Query query = em.createQuery(hql);
        return (List<UsuarioListDTO>) query.getResultList();
    }
}