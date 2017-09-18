/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Calificacion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Apollo
 */
public class CalificacionJPADAO implements CalificacionDAO{

     EntityManager em;
    EntityManagerFactory emf;

    public CalificacionJPADAO() 
    {
        emf = Persistence.createEntityManagerFactory("Glot-onPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Calificacion> ListarCalificacion() {
        List<Calificacion> lst = null;
        Query q = em.createQuery("SELECT a FROM Calificacion a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearCalificacion(Calificacion cal) {
        em.getTransaction().begin();
        em.persist(cal);
        em.getTransaction().commit();
    }

    @Override
    public Calificacion BuscarCalificacion(int codigoCal) {
        Calificacion cal = null;
        cal = em.find(cal.getClass(), codigoCal);
        return cal;
    }

    @Override
    public void ModificarCalificacion(Calificacion cal) {
        if (BuscarCalificacion(cal.getCalId()) != null)
            EliminarCalificacion(cal);
        crearCalificacion(cal);
    }

    @Override
    public void EliminarCalificacion(Calificacion cal) {
        em.getTransaction().begin();
        em.remove(cal);
        em.getTransaction().commit();
    }
    
}
