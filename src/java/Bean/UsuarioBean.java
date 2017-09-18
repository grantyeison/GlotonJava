/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.UsuarioDAO;
import DAO.UsuarioJPADAO;
import Modelo.Usuario;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Daniel
 */
public class UsuarioBean {
    @EJB
    private final UsuarioDAO dao;
    
    public UsuarioBean(){
        dao = new UsuarioJPADAO();
    }
    public List<Usuario> Listar(){
        return dao.ListarUsuario();
    }
    public void Crear(Usuario usu){
        dao.crearUsuario(usu);
    }
    public void Eliminar(Usuario usu){
        dao.EliminarUsuario(usu);
    }
    public void Modificar(Usuario usu){
        dao.ModificarUsuario(usu);
    }
    public Usuario Buscar(int idUs){
        return dao.BuscarUsuario(idUs);
    }
}
