/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.PlatoDAO;
import DAO.PlatoJPADAO;
import Modelo.Categoria;
import Modelo.Plato;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Prometheus
 */
public class PlatoBean 
{
     @EJB
    private final PlatoDAO dao;

    public PlatoBean() 
    {
            dao = new PlatoJPADAO();
    }
    
    public List<Plato> Listar()
    {
        return dao.ListarPlato();
    }
    
     public List<Plato> ListarPorCategoria(Categoria cat)
    {
        List<Plato> listaPla = dao.ListarPlato();
        List<Plato> lista = new LinkedList<>();
        for (Plato plat : listaPla)
        {
            if (plat.getTblCategoriacatId() == cat)
                lista.add(plat);
        }
        return lista;
    }
    
    public void Crear(Plato pla)
    {
        dao.crearPlato(pla);
    }
    
    public void Eliminar(Plato pla)
    {
        dao.EliminarPlato(pla);
    }
    
    public void Modificar(Plato pla)
    {
        dao.ModificarPlato(pla);
    }
    public Plato Buscar(int id)
    {
        return dao.BuscarPlato(id);
    }
    
}
