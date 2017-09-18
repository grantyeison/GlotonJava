/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.RestauranteDAO;
import DAO.RestauranteJPADAO;
import Modelo.Restaurante;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Daniel
 */
public class RestauranteBean {
    @EJB
    private final RestauranteDAO dao;
    
    public RestauranteBean(){
        dao = new RestauranteJPADAO();
    }
    
    public List<Restaurante> Listar(){
        return dao.ListarRestaurante();
    }
    public void Crear(Restaurante res){
        dao.crearRestaurante(res);
    }
    public void Eliminar(Restaurante res){
        dao.EliminarRestaurante(res);
    }
    public void Modificar(Restaurante res){
        dao.ModificarRestaurante(res);
    }
    public Restaurante Buscar(int idRes){
        return dao.BuscarRestaurante(idRes);
    }
    
}
