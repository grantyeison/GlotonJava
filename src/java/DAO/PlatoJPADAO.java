/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Plato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Apollo
 */
public class PlatoJPADAO implements PlatoDAO{
    EntityManager em;
    EntityManagerFactory emf;

    public PlatoJPADAO() 
    {
        emf = Persistence.createEntityManagerFactory("Glot-onPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Plato> ListarPlato() {
        List<Plato> lst = null;
        Query q = em.createQuery("SELECT a FROM Plato a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearPlato(Plato carPla) {
        em.getTransaction().begin();
        em.persist(carPla);
        em.getTransaction().commit();
    }

    @Override
    public Plato BuscarPlato(int id) {
        Plato carPla = null;
        carPla = em.find(carPla.getClass(), id);
        return carPla;
    }

    @Override
    public void ModificarPlato(Plato carPla) {
        if (BuscarPlato(carPla.getPlaId()) != null)
            EliminarPlato(carPla);
        crearPlato(carPla);
    }

    @Override
    public void EliminarPlato(Plato carPla) {
        em.getTransaction().begin();
        em.remove(carPla);
        em.getTransaction().commit();
    }
    
}
