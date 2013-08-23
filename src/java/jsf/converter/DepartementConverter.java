package jsf.converter;

import ejb.DepartementFacade;
import entite.Departement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author richard
 */
@FacesConverter(forClass = entite.Departement.class)
public class DepartementConverter implements Converter {
  DepartementFacade departementFacade = lookupDepartementFacadeBean();

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    return lookupDepartementFacadeBean().find(Integer.parseInt(value));
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    Departement departement = (Departement)value;
    return Integer.toString(departement.getId());
  }

  private DepartementFacade lookupDepartementFacadeBean() {
    try {
      Context c = new InitialContext();
      return (DepartementFacade) c.lookup("java:global/tpJsf3Apollo/DepartementFacade!ejb.DepartementFacade");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }
  
}
