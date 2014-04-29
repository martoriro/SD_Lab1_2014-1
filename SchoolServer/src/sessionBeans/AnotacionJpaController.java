/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entityClasses.Anotacion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sessionBeans.exceptions.NonexistentEntityException;

/**
 *
 * @author Martín
 */
public class AnotacionJpaController implements Serializable {

    public AnotacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //Funcionalidad que muestra las anotaciones
    public List<Anotacion> showAnotations(String rutAlumno){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Anotacion.findByRut").
                setParameter("rut", rutAlumno);
        
        return query.getResultList();
    }

    public void create(Anotacion anotacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(anotacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anotacion anotacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            anotacion = em.merge(anotacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = anotacion.getIdAnotacion();
                if (findAnotacion(id) == null) {
                    throw new NonexistentEntityException("The anotacion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anotacion anotacion;
            try {
                anotacion = em.getReference(Anotacion.class, id);
                anotacion.getIdAnotacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anotacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(anotacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anotacion> findAnotacionEntities() {
        return findAnotacionEntities(true, -1, -1);
    }

    public List<Anotacion> findAnotacionEntities(int maxResults, int firstResult) {
        return findAnotacionEntities(false, maxResults, firstResult);
    }

    private List<Anotacion> findAnotacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anotacion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Anotacion findAnotacion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anotacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnotacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anotacion> rt = cq.from(Anotacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
