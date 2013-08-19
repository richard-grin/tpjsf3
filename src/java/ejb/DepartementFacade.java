/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entite.Departement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author richard
 */
@Stateless
public class DepartementFacade extends AbstractFacade<Departement> {
  @PersistenceContext(unitName = "tpJsf3ApolloPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public DepartementFacade() {
    super(Departement.class);
  }
  
}
