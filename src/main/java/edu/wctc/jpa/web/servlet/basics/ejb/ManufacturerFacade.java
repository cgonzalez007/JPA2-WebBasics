package edu.wctc.jpa.web.servlet.basics.ejb;

import edu.wctc.jpa.web.servlet.basics.model.Manufacturer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * This class is an imlementation of the AbstractFacade, typed to handle
 * Manufacturer entities. It is also a Stateless EJB Session Bean. EJBs have
 * many sophisticated features, but for this demo it's the ability to
 * auto handle JTA transactions (the EJB container does this).
 * 
 * @author jlombardo
 */
@Stateless
public class ManufacturerFacade extends AbstractFacade<Manufacturer> {
    @PersistenceContext(unitName = "sample_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
        /**
     * Find by state
     * @param state - the target state
     * @return all manufacturers in that state
     */
    public List<Manufacturer> findByState(String state) {
//        String jpql = "select m from Manufacturer m where m.state = ?1";
//        TypedQuery<Manufacturer> q = 
//                getEntityManager().createQuery(jpql, Manufacturer.class);
//        q.setParameter(1, state);
//        q.setMaxResults(10); // optional
//        return q.getResultList();

//        String jpql = "select m from Manufacturer m where m.state = :state";
//        TypedQuery<Manufacturer> q = 
//                getEntityManager().createQuery(jpql, Manufacturer.class);
//        q.setParameter("state", state);        
//        return q.getResultList();

        TypedQuery<Manufacturer> q = 
              getEntityManager().createNamedQuery("Manufacturer.findByState", 
                      Manufacturer.class);
        q.setParameter("state", state);
        return q.getResultList();
    }
    
    public int deleteById(String id){
        String jpql = "delete from Manufacturer m where m.manufacturerId = :id";
        Query q = getEntityManager().createQuery(jpql);
        return q.executeUpdate();
        
//// If in cache, operation will not take so long. 
//        Manufacturer mfgEntity = getEntityManager().find(Manufacturer.class, id);
//        getEntityManager().remove(mfgEntity);
     }
    
    public int changeManufacturerNameToUpperCase(String id){
        String jpql = "UPDATE Manufacturer m SET m.name = UPPER(m.name)" +
                "WHERE m.manufacturerId = :id";
        Query q = getEntityManager().createQuery(jpql);
        q.setParameter("id", new Integer(id));
        return q.executeUpdate();
    }
    
    public ManufacturerFacade() {
        super(Manufacturer.class);
    }
    
}
