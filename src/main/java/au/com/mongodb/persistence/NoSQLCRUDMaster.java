package au.com.mongodb.persistence;

import au.com.mongodb.enums.EventSearchField;
import au.com.mongodb.persistence.entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class NoSQLCRUDMaster {

    private final String PU = "NoSQLPersistenceUnit";

    private EntityManagerFactory emf;
    private EntityManager em;


    /**
     * Create the Entity Manager from the Persistence Unit
     */
    public NoSQLCRUDMaster() {
        emf = Persistence.createEntityManagerFactory(PU);
        em = emf.createEntityManager();
    }


    /**
     * Search
     *
     * @param eventSearchField
     * {@link EventSearchField}
     *
     * @param valueForSearch
     * @return
     */
    public List<Event> search(final EventSearchField eventSearchField, final String valueForSearch) {
        final String namedQuery;
        final String keyValue;
        if (eventSearchField.equals(EventSearchField.ID) && valueForSearch != null) {
            namedQuery = "event.findById";
            keyValue = EventSearchField.ID.getField();
        } else if (eventSearchField.equals(EventSearchField.ACCOUNT_ID) && valueForSearch != null) {
            namedQuery = "event.findByAccountId";
            keyValue = EventSearchField.ACCOUNT_ID.getField();
        } else if (eventSearchField.equals(EventSearchField.REFERENCE_NUMBER) && valueForSearch != null) {
            namedQuery = "event.findByReferenceNumber";
            keyValue = EventSearchField.REFERENCE_NUMBER.getField();
        } else if (eventSearchField.equals(EventSearchField.ACCOUNT_NUMBER) && valueForSearch != null) {
            namedQuery = "event.findByAccountNumber";
            keyValue = EventSearchField.ACCOUNT_NUMBER.getField();
        } else if (eventSearchField.equals(EventSearchField.SCHEME_MEMBERSHIP_NUMBER) && valueForSearch != null) {
            namedQuery = "event.findBySchemeMembershipNumber";
            keyValue = EventSearchField.SCHEME_MEMBERSHIP_NUMBER.getField();
        } else {
            namedQuery = null;
            keyValue = null;
        }

        final List<Event> toReturn;
        if (namedQuery == null) {
            toReturn = null;
        } else {
            final Query query = em.createNamedQuery(namedQuery);
            if (keyValue != null && valueForSearch != null) {
                query.setParameter(keyValue, valueForSearch);
            }
            toReturn = query.getResultList();
        }
        return toReturn;
    }



    /**
     * Generic Persistence Save
     *
     * @param entity
     * @param <T>
     * @return
     */
    public <T extends Object> T mergeData(final T entity) {
        em.getTransaction().begin();
        final T returnEntity = em.merge(entity);
        em.flush();
        em.getTransaction().commit();
        return returnEntity;
    }


    /**
     * Generic Persistence Update
     *
     * @param entity
     * @param <T>
     * @return
     */
    public <T extends Object> T saveData(final T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }



    /**
     * Generic Persistence Delete
     *
     * @param entity
     * @param <T>
     * @return
     */
    public <T extends Object> T delete(final T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        return entity;
    }




    /**
     * Close Entity manager and factory
     */
    public void closeEntityManager() {
        if (em != null) {
            em.close();
        }

        if (emf != null) {
            emf.close();
        }
    }


}
