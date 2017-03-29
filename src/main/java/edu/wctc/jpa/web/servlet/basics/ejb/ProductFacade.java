package edu.wctc.jpa.web.servlet.basics.ejb;

import edu.wctc.jpa.web.servlet.basics.model.Product;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * This class is an imlementation of the AbstractFacade, typed to handle
 * Product entities. It is also a Stateless EJB Session Bean. EJBs have
 * many sophisticated features, but for this demo it's the ability to
 * auto handle JTA transactions (the EJB container does this).
 * 
 * @author jlombardo
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {
    @PersistenceContext(unitName = "sample_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public final int deleteById(String id){
        String jpql = "delete p from Product p where p.productId = :id";
        Query q = getEntityManager().createQuery(jpql);
        q.setParameter("id", id);
        return q.executeUpdate();
    
// If in cache, operation will not take so long. 
//        Product pEntity = getEntityManager().find(Product.class, id);
//        getEntityManager().remove(pEntity);
    }
    
    public final int changePurchaseCostById(String id, String newCost){
        String jpql = "update Product p set p.purchaseCost = :newCost where p.productId = :id";        
        Query q = getEntityManager().createQuery(jpql);
        q.setParameter("newPrice", new BigDecimal(newCost));
        q.setParameter("id", id);
        return q.executeUpdate();
    }    
    
    public ProductFacade() {
        super(Product.class);
    }
    
}
