/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Calificacion;
import java.util.List;

/**
 *
 * @author Apollo
 */
public interface CalificacionDAO {
    List<Calificacion> ListarCalificacion();    
    
    void crearCalificacion(Calificacion cal);
    
    Calificacion BuscarCalificacion(int codigoCal);
    
    void ModificarCalificacion (Calificacion cal);
    
    void EliminarCalificacion (Calificacion cal);
}
