/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Promociones;
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
    public List<Promociones> ListarPromocionesCombos() {
        List<Promociones> lst = null;
        Query q = em.createQuery("SELECT a FROM PromocionesCombos a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearPromocionesCombos(Promociones promo) {
        em.getTransaction().begin();
        em.persist(promo);
        em.getTransaction().commit();
    }

    @Override
    public Promociones BuscarPromocionesCombos(int id) {
        Promociones promo = null;
        promo = em.find(promo.getClass(), id);
        return promo;
    }

    @Override
    public void ModificarPromocionesCombos(Promociones promo) {
        if (BuscarPromocionesCombos(promo.getPromoId()) != null)
            EliminarPromocionesCombos(promo);
        crearPromocionesCombos(promo);
    }

    @Override
    public void EliminarPromocionesCombos(Promociones promo) {
        em.getTransaction().begin();
        em.remove(promo);
        em.getTransaction().commit();
    }
    
}
