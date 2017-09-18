/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.PromocionesDAO;
import DAO.PromocionesJPADAO;
import Modelo.Promociones;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeProvider;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Daniel
 */
public class PromocionesBean {
     @EJB
     private final PromocionesDAO dao;
     
     public PromocionesBean(){
         dao = new PromocionesJPADAO();
     }
     
    public List<Promociones> Listar(){
        return dao.ListarPromocionesCombos();
    }
    public void Crear(Promociones promo){
        dao.crearPromocionesCombos(promo);
    }
    public void Eliminar(Promociones promo){
        dao.EliminarPromocionesCombos(promo);
    }
    public void Modificar(Promociones promo){
        dao.ModificarPromocionesCombos(promo);
    }
    public Promociones Buscar(int idPromo){
        return dao.BuscarPromocionesCombos(idPromo);
    }
}
