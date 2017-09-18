/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PromocionesCombos;
import java.util.List;

/**
 *
 * @author Apollo
 */
public interface PromocionesDAO {
    List<PromocionesCombos> ListarPromocionesCombos();    
    
    void crearPromocionesCombos(PromocionesCombos promo);
    
    PromocionesCombos BuscarPromocionesCombos(int id);
    
    void ModificarPromocionesCombos (PromocionesCombos promo);
    
    void EliminarPromocionesCombos (PromocionesCombos promo);
  
    
}
