/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Apollo
 */
public class CategoriaJPADAO implements CategoriaDAO{

    EntityManager em;
    EntityManagerFactory emf;

    public CategoriaJPADAO() 
    {
        emf = Persistence.createEntityManagerFactory("Glot-onPU");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Categoria> ListarCategorias() {
        List<Categoria> lst = null;
        Query q = em.createQuery("SELECT a FROM Categoria a");
        lst = q.getResultList();
        return lst;
    }

    @Override
    public void crearCategoria(Categoria cat) {
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }

    @Override
    public Categoria BuscarCategoria(String catNombre) {
        Categoria cat = null;
        cat = em.find(cat.getClass(), catNombre);
        return cat;
    }

    @Override
    public void ModificarCategoria(Categoria esc) {
        if (BuscarCategoria(esc.getCatNombre()) != null)
            EliminarCategoria(esc);
        crearCategoria(esc);
    }

    @Override
    public void EliminarCategoria(Categoria esc) {
        em.getTransaction().begin();
        em.remove(esc);
        em.getTransaction().commit();
    }
    
}
