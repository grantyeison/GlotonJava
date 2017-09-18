/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Promociones;
import java.util.List;

/**
 *
 * @author Apollo
 */
public interface PromocionesDAO {
    List<Promociones> ListarPromocionesCombos();    
    
    void crearPromocionesCombos(Promociones promo);
    
    Promociones BuscarPromocionesCombos(int id);
    
    void ModificarPromocionesCombos (Promociones promo);
    
    void EliminarPromocionesCombos (Promociones promo);
  
    
}
