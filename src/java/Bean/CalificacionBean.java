/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;
import DAO.CalificacionDAO;
import DAO.CalificacionJPADAO;
import DAO.PlatoRestauranteJPADAO;
import Modelo.Calificacion;
import Modelo.Plato;
import Modelo.PlatoRestaurante;
import Modelo.Restaurante;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Prometheus
 */
public class CalificacionBean 
{
     @EJB
    private final CalificacionDAO dao;

    public CalificacionBean() 
    {
            dao = new CalificacionJPADAO();
    }
    
    public List<Calificacion> Listar(PlatoRestaurante plato)
    {
        List<Calificacion> calificaciones = dao.ListarCalificacion();
        List<Calificacion> califPlato = new LinkedList<>();
        for (Calificacion cal : calificaciones)
        {
            if (cal.getTblPlatoRestauranteplatId() == plato)
            {
                califPlato.add(cal);
            }
        }
        return califPlato;
    }
    
    public List<Calificacion> GenerarReporteRestaurante(Restaurante rest)
    {
        List<Calificacion> calificaciones = dao.ListarCalificacion();
        List<Calificacion> califPlato = new LinkedList<>();
        for (Calificacion cal : calificaciones)
        {
            if (cal.getTblPlatoRestauranteplatId().getTblRestauranteresid() == rest)
            {
                califPlato.add(cal);
            }
        }
        return califPlato;
    }
    
    public List<Calificacion> GenerarReporteCalificaciones()
    {
        List<Calificacion> calificaciones = dao.ListarCalificacion();
        List<Calificacion> califPlato = new LinkedList<>();
        List<PlatoRestaurante> platos = new PlatoRestauranteJPADAO().ListarPlatoRestaurante();
        for (PlatoRestaurante plato : platos)
        {
            int suma = 0;
            int votantes = 0;
            int promedio = 0;
            for (Calificacion cal : calificaciones)
            {
                if (cal.getTblPlatoRestauranteplatId() == plato)
                {
                    suma += cal.getCalPuntuacion();
                    votantes ++;
                }
            }
            promedio = suma/votantes;
            Calificacion calif = new Calificacion();
            calif.setTblPlatoRestauranteplatId(plato);
            calif.setCalPuntuacion(promedio);
            califPlato.add(calif);
        }
        return califPlato;
    }
    
    public void Crear(Calificacion cal)
    {
        dao.crearCalificacion(cal);
    }
    
    public void Eliminar(Calificacion cal)
    {
        dao.EliminarCalificacion(cal);
    }
    
    public void Modificar(Calificacion cal)
    {
        dao.ModificarCalificacion(cal);
    }
    public Calificacion Buscar(int idPro)
    {
        return dao.BuscarCalificacion(idPro);
    }
    
}
