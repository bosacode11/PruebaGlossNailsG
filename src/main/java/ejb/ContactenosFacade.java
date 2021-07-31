/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Contactenos;

/**
 *
 * @author Camilo
 */
@Stateless
public class ContactenosFacade extends AbstractFacade<Contactenos> implements ContactenosFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactenosFacade() {
        super(Contactenos.class);
    }
    
}
