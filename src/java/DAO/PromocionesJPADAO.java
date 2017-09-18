/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PromocionesCombos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Apollo
 */
public class PromocionesJPADAO implements PromocionesDAO{
    EntityManager em;
    EntityManagerFactory emf;

    public PromocionesJPADAO() 
    {
        emf = Persistence.createEntityManagerFactory("Glot-onPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<PromocionesCombos> ListarPromocionesCombos() {
        List<PromocionesCombos> lst = null;
        Query q = em.createQuery("SELECT a FROM PromocionesCombos a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearPromocionesCombos(PromocionesCombos promo) {
        em.getTransaction().begin();
        em.persist(promo);
        em.getTransaction().commit();
    }

    @Override
    public PromocionesCombos BuscarPromocionesCombos(int id) {
        PromocionesCombos promo = null;
        promo = em.find(promo.getClass(), id);
        return promo;
    }

    @Override
    public void ModificarPromocionesCombos(PromocionesCombos promo) {
        if (BuscarPromocionesCombos(promo.getPromoId()) != null)
            EliminarPromocionesCombos(promo);
        crearPromocionesCombos(promo);
    }

    @Override
    public void EliminarPromocionesCombos(PromocionesCombos promo) {
        em.getTransaction().begin();
        em.remove(promo);
        em.getTransaction().commit();
    }
    
}
