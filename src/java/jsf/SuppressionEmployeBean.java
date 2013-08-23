package jsf;

import ejb.EmployeFacade;
import entite.Employe;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

/**
 * Backing bean pour supprimer un employé
 *
 * @author richard
 */
@Model // stéréotype pour @Named et @RequestScope
public class SuppressionEmployeBean {

  @Inject
  private EmployeFacade employeFacade;

  public String supprimer(int id) {
    Employe employe = employeFacade.find(id);
    if (employe == null) {
      addFlashMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "L'employé d'id " + id + " a déjà été supprimé.", null));
    } else {
      employeFacade.remove(employe);
    }
    return "listeemployes?faces-redirect=true";
  }

  /**
   * Ajouter le message passé en paramètre dans le cas d'une redirection.
   *
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
