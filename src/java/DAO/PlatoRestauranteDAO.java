/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PlatoRestaurante;
import Modelo.Plato;
import Modelo.Restaurante;
import java.util.List;

/**
 *
 * @author Apollo
 */
public interface PlatoRestauranteDAO {
    List<PlatoRestaurante> ListarPlatoRestaurante();    
    
    void crearPlatoRestaurante(PlatoRestaurante carPla);
    
    PlatoRestaurante BuscarPlatoRestaurante(int id);
    
    void ModificarPlatoRestaurante (PlatoRestaurante carPla);
    
    void EliminarPlatoRestaurante (PlatoRestaurante carPla);
}
