package au.com.mongodb.test.persistence;

import au.com.mongodb.test.enums.EvenSearchField;
import au.com.mongodb.test.model.EventModel;
import au.com.mongodb.test.persistence.entities.Event;

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
     * @param evenSearchField
     * {@link EvenSearchField}
     *
     * @param valueForSearch
     * @return
     */
    public List<Event> search(final EvenSearchField evenSearchField, final String valueForSearch) {
        final String namedQuery;
        final String keyValue;
        if (evenSearchField.equals(EvenSearchField.ID) && valueForSearch != null) {
            namedQuery = "event.findById";
            keyValue = EvenSearchField.ID.getField();
        } else if (evenSearchField.equals(EvenSearchField.ACCOUNT_ID) && valueForSearch != null) {
            namedQuery = "event.findByAccountId";
            keyValue = EvenSearchField.ACCOUNT_ID.getField();
        } else if (evenSearchField.equals(EvenSearchField.REFERENCE_NUMBER) && valueForSearch != null) {
            namedQuery = "event.findByReferenceNumber";
            keyValue = EvenSearchField.REFERENCE_NUMBER.getField();
        } else if (evenSearchField.equals(EvenSearchField.ACCOUNT_NUMBER) && valueForSearch != null) {
            namedQuery = "event.findByAccountNumber";
            keyValue = EvenSearchField.ACCOUNT_NUMBER.getField();
        } else if (evenSearchField.equals(EvenSearchField.SCHEME_MEMBERSHIP_NUMBER) && valueForSearch != null) {
            namedQuery = "event.findBySchemeMembershipNumber";
            keyValue = EvenSearchField.SCHEME_MEMBERSHIP_NUMBER.getField();
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
