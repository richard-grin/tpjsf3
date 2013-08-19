/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entite.Employe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author richard
 */
@Stateless
public class EmployeFacade extends AbstractFacade<Employe> {
  @PersistenceContext(unitName = "tpJsf3ApolloPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public EmployeFacade() {
    super(Employe.class);
  }
  
}
