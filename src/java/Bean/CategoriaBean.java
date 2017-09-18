/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.CategoriaDAO;
import DAO.CategoriaJPADAO;
import Modelo.Categoria;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Prometheus
 */
public class CategoriaBean 
{
     @EJB
    private final CategoriaDAO dao;

    public CategoriaBean() 
    {
            dao = new CategoriaJPADAO();
    }
    
    public List<Categoria> Listar()
    {
        return dao.ListarCategorias();
    }
    
    public void Crear(Categoria cat)
    {
        dao.crearCategoria(cat);
    }
    
    public void Eliminar(Categoria cat)
    {
        dao.EliminarCategoria(cat);
    }
    
    public void Modificar(Categoria cat)
    {
        dao.ModificarCategoria(cat);
    }
    public Categoria Buscar(int id)
    {
        return dao.BuscarCategoria(id);
    }
    
}
