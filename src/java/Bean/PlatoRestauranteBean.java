/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.PlatoRestauranteDAO;
import DAO.PlatoRestauranteJPADAO;
import Modelo.Categoria;
import Modelo.PlatoRestaurante;
import Modelo.Restaurante;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Prometheus
 */
public class PlatoRestauranteBean 
{
     @EJB
    private final PlatoRestauranteDAO dao;

    public PlatoRestauranteBean() 
    {
            dao = new PlatoRestauranteJPADAO();
    }
    
    public List<PlatoRestaurante> Listar()
    {
        return dao.ListarPlatoRestaurante();
    }
    
    public List<PlatoRestaurante> ListarPorRestaurante(Restaurante rest)
    {
        List<PlatoRestaurante> todos = Listar();
        List<PlatoRestaurante> retorno = new LinkedList<>();
        for (PlatoRestaurante actual : todos)
        {
            if (actual.getTblRestauranteresid() == rest)
                retorno.add(actual);
        }
        return retorno;
    }
    
    public List<PlatoRestaurante> ListarPorCategoria(Categoria cat)
    {
        List<PlatoRestaurante> todos = Listar();
        List<PlatoRestaurante> retorno = new LinkedList<>();
        for (PlatoRestaurante actual : todos)
        {
            if (actual.getTblPlatoplaId().getTblCategoriacatId() == cat)
                retorno.add(actual);
        }
        return retorno;
    }
    
    public void Crear(PlatoRestaurante plaRes)
    {
        dao.crearPlatoRestaurante(plaRes);
    }
    
    public void Eliminar(PlatoRestaurante plaRes)
    {
        dao.EliminarPlatoRestaurante(plaRes);
    }
    
    public void Modificar(PlatoRestaurante plaRes)
    {
        dao.ModificarPlatoRestaurante(plaRes);
    }
    public PlatoRestaurante Buscar(int id)
    {
        return dao.BuscarPlatoRestaurante(id);
    }
    
}
