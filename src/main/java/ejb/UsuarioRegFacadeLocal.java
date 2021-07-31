/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.UsuarioReg;

/**
 *
 * @author Camilo
 */
@Local
public interface UsuarioRegFacadeLocal {

    void create(UsuarioReg usuarioReg);

    void edit(UsuarioReg usuarioReg);

    void remove(UsuarioReg usuarioReg);

    UsuarioReg find(Object id);

    List<UsuarioReg> findAll();

    List<UsuarioReg> findRange(int[] range);

    int count();
    
}
