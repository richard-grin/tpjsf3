package jsf;

import ejb.DepartementFacade;
import ejb.EmployeFacade;
import entite.Departement;
import entite.Employe;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing bean pour la page edit.xhtml.
 */
@Named
//@RequestScoped
@ViewScoped
public class EditEmployeBean implements Serializable {

  @Inject
  private EmployeFacade employeFacade;
  @Inject
  private DepartementFacade departementFacade;
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

  public void chargerEmploye() {
    employeEnCours = employeFacade.find(idEmployeEnCours);
    if (employeEnCours == null) {
      FacesContext.getCurrentInstance().addMessage(null,
              new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Aucun employé n'a l'id " + idEmployeEnCours, null));
    }
  }

  public Employe getEmployeEnCours() {
    return employeEnCours;
  }

  public List<Departement> getTousLesDepartements() {
    return departementFacade.findAll();
  }

  public String enregistrer() {
    employeFacade.edit(employeEnCours);
    addFlashMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, 
            "Employé d'id " + employeEnCours.getId() + " et de nom " + employeEnCours.getNom() + " modifié.", null));
    return "listeemployes?faces-redirect=true";
  }

  /**
   * Ajouter le message passé en paramètre dans le cas
   * d'une redirection.
   * @param message 
   */
  private void addFlashMessage(FacesMessage message) {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    Flash flash = facesContext.getExternalContext().getFlash();
    flash.setKeepMessages(true);
    flash.setRedirect(true);
    facesContext.addMessage(null, message);
  }
}
