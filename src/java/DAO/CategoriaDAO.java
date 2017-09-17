/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import java.util.List;

/**
 *
 * @author Apollo
 */
public interface CategoriaDAO {
    List<Categoria> ListarCategorias();    
    
    void crearCategoria(Categoria cat);
    
    Categoria BuscarCategoria(String catNombre);
    
    void ModificarCategoria (Categoria esc);
    
    void EliminarCategoria (Categoria esc);
}
