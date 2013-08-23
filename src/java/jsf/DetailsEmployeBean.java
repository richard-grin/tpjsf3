package jsf;

import ejb.EmployeFacade;
import entite.Employe;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing bean pour la page details.
 */
@Named
@RequestScoped
public class DetailsEmployeBean {

  @Inject
  private EmployeFacade employeFacade;
  /**
   * id de l'employé dont on veut voir les détails.
   */
  private int idEmployeEnCours;
  private Employe employeEnCours;

  public int getIdEmployeEnCours() {
    return idEmployeEnCours;
  }

  public void setIdEmployeEnCours(int idEmployeEnCours) {
    System.out.println("setIdEmployeEnCours; id=" + idEmployeEnCours);
    this.idEmployeEnCours = idEmployeEnCours;
  }

  public String chargerEmploye() {
    employeEnCours = employeFacade.find(idEmployeEnCours);
    if (employeEnCours == null) {
      FacesContext.getCurrentInstance().addMessage(null,
              new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aucun employé n'a l'id " + idEmployeEnCours, null));
      return "erreur";
    }
    return null;
  }

  public Employe getEmployeEnCours() {
    return employeEnCours;
  }
}
