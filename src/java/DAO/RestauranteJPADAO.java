/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Restaurante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
public class RestauranteJPADAO implements RestauranteDAO{
    
    EntityManager em;
    EntityManagerFactory emf;
    
    public RestauranteJPADAO(){
        emf = Persistence.createEntityManagerFactory("Glot-onPU");
        em = emf.createEntityManager();
    }

    @Override
    public List<Restaurante> ListarRestaurante() {
        List<Restaurante> lst = null;
        Query q = em.createQuery("SELECT a FROM Restaurante a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearRestaurante(Restaurante res) {
        em.getTransaction().begin();
        em.persist(res);
        em.getTransaction().commit();
    }

    @Override
    public Restaurante BuscarRestaurante(int id) {
        Restaurante res = null;
        res = em.find(res.getClass(),id);
        return res;
    }

    @Override
    public void ModificarRestaurante(Restaurante res) {
        
    }

    @Override
    public void EliminarRestaurante(Restaurante res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
