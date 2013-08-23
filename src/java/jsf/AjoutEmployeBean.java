package jsf;

import ejb.DepartementFacade;
import ejb.EmployeFacade;
import entite.Departement;
import entite.Employe;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing bean pour la page ajout.xhtml.
 */
@Named
//@RequestScoped
@ViewScoped
public class AjoutEmployeBean implements Serializable {

  @Inject
  private EmployeFacade employeFacade;
  @Inject
  private DepartementFacade departementFacade;
 
  private Employe employeEnCours;

  public Employe getEmployeEnCours() {
    return employeEnCours;
  }

  public List<Departement> getTousLesDepartements() {
    return departementFacade.findAll();
  }
  
  public String enregistrer() {
    employeFacade.create(employeEnCours);
    addFlashMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, 
            "Employé d'id " + employeEnCours.getId() + " et de nom " + employeEnCours.getNom() + " modifié.", null));
    return "ajout?faces-redirect=true";
  }
  
  public void initEmploye() {
    employeEnCours = new Employe();
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
