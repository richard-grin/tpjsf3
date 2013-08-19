/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author richard
 */
@Entity
@Table(name = "DEPARTEMENT")
@NamedQueries({
  @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
  @NamedQuery(name = "Departement.findById", query = "SELECT d FROM Departement d WHERE d.id = :id"),
  @NamedQuery(name = "Departement.findByNom", query = "SELECT d FROM Departement d WHERE d.nom = :nom"),
  @NamedQuery(name = "Departement.findByLieu", query = "SELECT d FROM Departement d WHERE d.lieu = :lieu")})
public class Departement implements Serializable {
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
  @Size(max = 80)
  @Column(name = "LIEU")
  private String lieu;
  @OneToMany(mappedBy = "departement")
  private Collection<Employe> employeCollection;

  public Departement() {
  }

  public Departement(Integer id) {
    this.id = id;
  }

  public Departement(Integer id, String nom) {
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

  public String getLieu() {
    return lieu;
  }

  public void setLieu(String lieu) {
    this.lieu = lieu;
  }

  public Collection<Employe> getEmployeCollection() {
    return employeCollection;
  }

  public void setEmployeCollection(Collection<Employe> employeCollection) {
    this.employeCollection = employeCollection;
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
    if (!(object instanceof Departement)) {
      return false;
    }
    Departement other = (Departement) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entite.Departement[ id=" + id + " ]";
  }
  
}
