package jsf;

import ejb.EmployeFacade;
import entite.Employe;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author richard
 */
@Named
@ViewScoped
public class EmployeBean {
  @Inject
  private EmployeFacade employeFacade;
  
  private List<Employe> listeEmployes;
  
  public List<Employe> getTousLesEmployes() {
    if (listeEmployes == null) {
      listeEmployes = employeFacade.findAll();
    }
//    System.out.println("employeFacase =" + employeFacade);
    return listeEmployes;
  }
  
}
