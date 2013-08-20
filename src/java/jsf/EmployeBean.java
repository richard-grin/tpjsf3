package jsf;

import ejb.EmployeFacade;
import entite.Employe;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing bean pour les pages listeemployes et details.
 */
@Named
@ViewScoped
public class EmployeBean implements Serializable {
  @Inject
  private EmployeFacade employeFacade;
  
  private List<Employe> listeEmployes;
  
  public List<Employe> getTousLesEmployes() {
    if (listeEmployes == null) {
      listeEmployes = employeFacade.findAll();
    }
    return listeEmployes;
  }
}
