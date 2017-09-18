/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Restaurante;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface RestauranteDAO {
    
    List<Restaurante> ListarRestaurante();    
    
    void crearRestaurante(Restaurante res);
    
    Restaurante BuscarRestaurante(int id);
    
    void ModificarRestaurante (Restaurante res);
    
    void EliminarRestaurante (Restaurante res);
    
}
