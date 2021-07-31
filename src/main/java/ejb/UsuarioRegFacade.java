/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.UsuarioReg;

/**
 *
 * @author Camilo
 */
@Stateless
public class UsuarioRegFacade extends AbstractFacade<UsuarioReg> implements UsuarioRegFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRegFacade() {
        super(UsuarioReg.class);
    }
    
}
