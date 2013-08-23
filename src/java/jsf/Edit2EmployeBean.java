package jsf;

import ejb.DepartementFacade;
import ejb.EmployeFacade;
import entite.Departement;
import entite.Employe;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Backing bean pour la page edit2.xhtml.
 */
@Named
@RequestScoped
//@ViewScoped
public class Edit2EmployeBean {

  @Inject
  private EmployeFacade employeFacade;
  @Inject
  private DepartementFacade departementFacade;
  /**
   * id de l'employé dont on veut voir les détails.
   */
  private int id;
  
  private String nom;
  private BigDecimal salaire;
  private String rue;
  private String ville;
  private String pays;
  private Departement departement;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public BigDecimal getSalaire() {
    return salaire;
  }

  public void setSalaire(BigDecimal salaire) {
    this.salaire = salaire;
  }

  public String getRue() {
    return rue;
  }

  public void setRue(String rue) {
    this.rue = rue;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getPays() {
    return pays;
  }

  public void setPays(String pays) {
    this.pays = pays;
  }

  public Departement getDepartement() {
    return departement;
  }

  public void setDepartement(Departement departement) {
    this.departement = departement;
  }
  

  private Employe getEmploye() {
    Employe employeEnCours = employeFacade.find(id);
    if (employeEnCours == null) {
      FacesContext.getCurrentInstance().addMessage(null,
              new FacesMessage("Aucun employé n'a l'id " + id));
    }
    return employeEnCours;
  }

  public List<Departement> getTousLesDepartements() {
    return departementFacade.findAll();
  }
  
  public void chargerEmploye() {
    Employe employe = employeFacade.find(id);
    if (employe == null) {
      FacesContext.getCurrentInstance().addMessage(null,
              new FacesMessage("Aucun employé n'a l'id " + id));
    }
    else {
      nom = employe.getNom();
      salaire = employe.getSalaire();
      rue = employe.getRue();
      ville = employe.getVille();
      pays = employe.getPays();
      departement = employe.getDepartement();
    }
  }
  
  public String enregistrer() {
    Employe employe = getEmploye();
    employe.setNom(nom);
    employe.setSalaire(salaire);
    employe.setRue(rue);
    employe.setVille(ville);
    employe.setPays(pays);
    employe.setDepartement(departement);
    employeFacade.edit(employe);
    return "listeemployes";
  }
}
