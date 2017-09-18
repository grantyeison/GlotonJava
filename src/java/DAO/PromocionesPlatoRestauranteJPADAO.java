/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PromocionesCombosHasTblPlatoRestaurante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Apollo
 */
public class PromocionesPlatoRestauranteJPADAO implements PromocionesPlatoRestauranteDAO{
    EntityManager em;
    EntityManagerFactory emf;

    public PromocionesPlatoRestauranteJPADAO() 
    {
        emf = Persistence.createEntityManagerFactory("Glot-onPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<PromocionesCombosHasTblPlatoRestaurante> ListarPromocionesCombosHasTblPlatoRestaurante() {
        List<PromocionesCombosHasTblPlatoRestaurante> lst = null;
        Query q = em.createQuery("SELECT a FROM PromocionesCombosHasTblPlatoRestaurante a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearPromocionesCombosHasTblPlatoRestaurante(PromocionesCombosHasTblPlatoRestaurante promo) {
        em.getTransaction().begin();
        em.persist(promo);
        em.getTransaction().commit();
    }

    @Override
    public PromocionesCombosHasTblPlatoRestaurante BuscarPromocionesCombosHasTblPlatoRestaurante(int id) {
        PromocionesCombosHasTblPlatoRestaurante promo = null;
        promo = em.find(promo.getClass(), id);
        return promo;
    }

    @Override
    public void ModificarPromocionesCombosHasTblPlatoRestaurante(PromocionesCombosHasTblPlatoRestaurante promo) {
        if (BuscarPromocionesCombosHasTblPlatoRestaurante(promo.getId()) != null)
            EliminarPromocionesCombosHasTblPlatoRestaurante(promo);
        crearPromocionesCombosHasTblPlatoRestaurante(promo);
    }

    @Override
    public void EliminarPromocionesCombosHasTblPlatoRestaurante(PromocionesCombosHasTblPlatoRestaurante promo) {
        em.getTransaction().begin();
        em.remove(promo);
        em.getTransaction().commit();
    }
    
}
