/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PromocionesCombosHasTblPlatoRestaurante;
import java.util.List;

/**
 *
 * @author Apollo
 */
public interface PromocionesPlatoRestauranteDAO {
    
    List<PromocionesCombosHasTblPlatoRestaurante> ListarPromocionesCombosHasTblPlatoRestaurante();    
    
    void crearPromocionesCombosHasTblPlatoRestaurante(PromocionesCombosHasTblPlatoRestaurante promo);
    
    PromocionesCombosHasTblPlatoRestaurante BuscarPromocionesCombosHasTblPlatoRestaurante(int id);
    
    void ModificarPromocionesCombosHasTblPlatoRestaurante (PromocionesCombosHasTblPlatoRestaurante promo);
    
    void EliminarPromocionesCombosHasTblPlatoRestaurante (PromocionesCombosHasTblPlatoRestaurante promo);
  
}
