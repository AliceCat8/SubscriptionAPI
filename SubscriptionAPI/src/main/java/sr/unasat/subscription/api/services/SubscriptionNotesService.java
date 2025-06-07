
package sr.unasat.subscription.api.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import sr.unasat.subscription.api.entity.SubscriptionNotes;

import java.util.List;

public class SubscriptionNotesService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("unasat");

    // Save a new subscription note
    public SubscriptionNotes save(SubscriptionNotes note) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(note);
            tx.commit();
            return note;
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
    }

    // Retrieve all subscription notes
    public List<SubscriptionNotes> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            List<SubscriptionNotes> result = em.createQuery("SELECT n FROM SubscriptionNotes n", SubscriptionNotes.class).getResultList();
            return result != null ? result : List.of();
        } finally {
            em.close();
        }
    }

    // Retrieve notes by subscription ID
    public List<SubscriptionNotes> findBySubscriptionId(int subscriptionId) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT n FROM SubscriptionNotes n WHERE n.subscriptionId = :subscriptionId", SubscriptionNotes.class)
                    .setParameter("subscriptionId", subscriptionId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    // Retrieve a single note by ID
    public SubscriptionNotes findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(SubscriptionNotes.class, id);
        } finally {
            em.close();
        }
    }

    // Update a subscription note
    public SubscriptionNotes update(SubscriptionNotes note) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SubscriptionNotes updated = em.merge(note);
            tx.commit();
            return updated;
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
    }

    // Delete a subscription note by ID
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SubscriptionNotes note = em.find(SubscriptionNotes.class, id);
            if (note != null) {
                em.remove(note);
            }
            tx.commit();
        } finally {
            if (tx.isActive()) tx.rollback();
            em.close();
        }
    }
}
