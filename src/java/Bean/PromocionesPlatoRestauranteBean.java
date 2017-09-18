/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.PromocionesPlatoRestauranteDAO;
import DAO.PromocionesPlatoRestauranteJPADAO;
import Modelo.PromocioneslPlatoRestaurante;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Daniel
 */
public class PromocionesPlatoRestauranteBean {
    @EJB
    private final PromocionesPlatoRestauranteDAO dao;
    
    public PromocionesPlatoRestauranteBean(){
        dao = new PromocionesPlatoRestauranteJPADAO();
    }
    public List<PromocioneslPlatoRestaurante> Listar(){
        return dao.ListarPromocionesCombosHasTblPlatoRestaurante();
    }
    public void Crear(PromocioneslPlatoRestaurante promoPlatRes){
        dao.crearPromocionesCombosHasTblPlatoRestaurante(promoPlatRes);
    }
    public void Eliminar(PromocioneslPlatoRestaurante promoPlatRes){
        dao.EliminarPromocionesCombosHasTblPlatoRestaurante(promoPlatRes);
    }
    public void Modificar(PromocioneslPlatoRestaurante promoPlatRes){
        dao.ModificarPromocionesCombosHasTblPlatoRestaurante(promoPlatRes);
    }
    public PromocioneslPlatoRestaurante Buscar(int idPromoPlatRes){
        return dao.BuscarPromocionesCombosHasTblPlatoRestaurante(idPromoPlatRes);
    }
    
}
