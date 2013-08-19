/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author richard
 */
@Entity
@Table(name = "EMPLOYE")
@NamedQueries({
  @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
  @NamedQuery(name = "Employe.findById", query = "SELECT e FROM Employe e WHERE e.id = :id"),
  @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employe e WHERE e.nom = :nom"),
  @NamedQuery(name = "Employe.findBySalaire", query = "SELECT e FROM Employe e WHERE e.salaire = :salaire"),
  @NamedQuery(name = "Employe.findByRue", query = "SELECT e FROM Employe e WHERE e.rue = :rue"),
  @NamedQuery(name = "Employe.findByVille", query = "SELECT e FROM Employe e WHERE e.ville = :ville"),
  @NamedQuery(name = "Employe.findByPays", query = "SELECT e FROM Employe e WHERE e.pays = :pays")})
public class Employe implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 80)
  @Column(name = "NOM")
  private String nom;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "SALAIRE")
  private BigDecimal salaire;
  @Size(max = 80)
  @Column(name = "RUE")
  private String rue;
  @Size(max = 80)
  @Column(name = "VILLE")
  private String ville;
  @Size(max = 80)
  @Column(name = "PAYS")
  private String pays;
  @JoinColumn(name = "DEPARTEMENT_ID", referencedColumnName = "ID")
  @ManyToOne
  private Departement departement;

  public Employe() {
  }

  public Employe(Integer id) {
    this.id = id;
  }

  public Employe(Integer id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Employe)) {
      return false;
    }
    Employe other = (Employe) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entite.Employe[ id=" + id + " ]";
  }
  
}
