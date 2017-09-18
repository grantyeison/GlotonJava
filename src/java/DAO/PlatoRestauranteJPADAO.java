/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PlatoRestaurante;
import Modelo.Categoria;
import Modelo.Plato;
import Modelo.Restaurante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Apollo
 */
public class PlatoRestauranteJPADAO implements PlatoRestauranteDAO{
    EntityManager em;
    EntityManagerFactory emf;

    public PlatoRestauranteJPADAO() 
    {
        emf = Persistence.createEntityManagerFactory("Glot-onPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<PlatoRestaurante> ListarPlatoRestaurante() {
        List<PlatoRestaurante> lst = null;
        Query q = em.createQuery("SELECT a FROM PlatoRestaurante a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearPlatoRestaurante(PlatoRestaurante carPla) {
        em.getTransaction().begin();
        em.persist(carPla);
        em.getTransaction().commit();
    }

    @Override
    public PlatoRestaurante BuscarPlatoRestaurante(int id) {
        PlatoRestaurante carPla = null;
        carPla = em.find(carPla.getClass(), id);
        return carPla;
    }

    @Override
    public void ModificarPlatoRestaurante(PlatoRestaurante carPla) {
        if (BuscarPlatoRestaurante(carPla.getPlatId()) != null)
            EliminarPlatoRestaurante(carPla);
        crearPlatoRestaurante(carPla);
    }

    @Override
    public void EliminarPlatoRestaurante(PlatoRestaurante carPla) {
        em.getTransaction().begin();
        em.remove(carPla);
        em.getTransaction().commit();
    }
    
}
