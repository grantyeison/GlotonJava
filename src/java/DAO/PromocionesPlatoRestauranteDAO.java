/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PromocioneslPlatoRestaurante;
import java.util.List;

/**
 *
 * @author Apollo
 */
public interface PromocionesPlatoRestauranteDAO {
    
    List<PromocioneslPlatoRestaurante> ListarPromocionesCombosHasTblPlatoRestaurante();    
    
    void crearPromocionesCombosHasTblPlatoRestaurante(PromocioneslPlatoRestaurante promo);
    
    PromocioneslPlatoRestaurante BuscarPromocionesCombosHasTblPlatoRestaurante(int id);
    
    void ModificarPromocionesCombosHasTblPlatoRestaurante (PromocioneslPlatoRestaurante promo);
    
    void EliminarPromocionesCombosHasTblPlatoRestaurante (PromocioneslPlatoRestaurante promo);
  
}
