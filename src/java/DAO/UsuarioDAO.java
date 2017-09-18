/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Daniel
 */
public interface UsuarioDAO {
    
    List<Usuario> ListarUsuario();    
    
    void crearUsuario(Usuario usu);
    
    Usuario BuscarUsuario(int id);
    
    void ModificarUsuario (Usuario usu);
    
    void EliminarUsuario (Usuario usu);
    
}
