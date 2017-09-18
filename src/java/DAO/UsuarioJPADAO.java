/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
public class UsuarioJPADAO  implements UsuarioDAO{

    EntityManager em;
    EntityManagerFactory emf;
    
    public UsuarioJPADAO(){
        emf = Persistence.createEntityManagerFactory("Glot-onPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Usuario> ListarUsuario() {
        
        List<Usuario> lst = null;
        Query q = em.createQuery("SELECT a FROM Usuario a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearUsuario(Usuario usu) {
        em.getTransaction().begin();
        em.persist(usu);
        em.getTransaction().commit();
    }

    @Override
    public Usuario BuscarUsuario(int id) {
        Usuario usu = null;
        usu = em.find(usu.getClass(),id);
        return usu;
    }

    @Override
    public void ModificarUsuario(Usuario usu) {
        
       if (BuscarUsuario(usu.getDueId()) != null)
            EliminarUsuario(usu);
        crearUsuario(usu);
    }

    @Override
    public void EliminarUsuario(Usuario usu) {
        em.getTransaction().begin();
        em.remove(usu);
        em.getTransaction().commit();
    }
    
}
