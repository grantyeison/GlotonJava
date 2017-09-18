/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Plato;
import java.util.List;

/**
 *
 * @author Apollo
 */
public interface PlatoDAO {
    List<Plato> ListarPlato();    
    
    void crearPlato(Plato carPla);
    
    Plato BuscarPlato(int id);
    
    void ModificarPlato (Plato carPla);
    
    void EliminarPlato (Plato carPla);
    
}
