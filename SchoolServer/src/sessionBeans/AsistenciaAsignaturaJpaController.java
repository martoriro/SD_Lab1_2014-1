/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entityClasses.AsistenciaAsignatura;
import entityClasses.AsistenciaAsignaturaPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sessionBeans.exceptions.NonexistentEntityException;
import sessionBeans.exceptions.PreexistingEntityException;

/**
 *
 * @author Martín
 */
public class AsistenciaAsignaturaJpaController implements Serializable {

    public AsistenciaAsignaturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AsistenciaAsignatura asistenciaAsignatura) throws PreexistingEntityException, Exception {
        if (asistenciaAsignatura.getAsistenciaAsignaturaPK() == null) {
            asistenciaAsignatura.setAsistenciaAsignaturaPK(new AsistenciaAsignaturaPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asistenciaAsignatura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAsistenciaAsignatura(asistenciaAsignatura.getAsistenciaAsignaturaPK()) != null) {
                throw new PreexistingEntityException("AsistenciaAsignatura " + asistenciaAsignatura + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AsistenciaAsignatura asistenciaAsignatura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            asistenciaAsignatura = em.merge(asistenciaAsignatura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                AsistenciaAsignaturaPK id = asistenciaAsignatura.getAsistenciaAsignaturaPK();
                if (findAsistenciaAsignatura(id) == null) {
                    throw new NonexistentEntityException("The asistenciaAsignatura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(AsistenciaAsignaturaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AsistenciaAsignatura asistenciaAsignatura;
            try {
                asistenciaAsignatura = em.getReference(AsistenciaAsignatura.class, id);
                asistenciaAsignatura.getAsistenciaAsignaturaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asistenciaAsignatura with id " + id + " no longer exists.", enfe);
            }
            em.remove(asistenciaAsignatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AsistenciaAsignatura> findAsistenciaAsignaturaEntities() {
        return findAsistenciaAsignaturaEntities(true, -1, -1);
    }

    public List<AsistenciaAsignatura> findAsistenciaAsignaturaEntities(int maxResults, int firstResult) {
        return findAsistenciaAsignaturaEntities(false, maxResults, firstResult);
    }

    private List<AsistenciaAsignatura> findAsistenciaAsignaturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AsistenciaAsignatura.class));
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

    public AsistenciaAsignatura findAsistenciaAsignatura(AsistenciaAsignaturaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AsistenciaAsignatura.class, id);
        } finally {
            em.close();
        }
    }

    public int getAsistenciaAsignaturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AsistenciaAsignatura> rt = cq.from(AsistenciaAsignatura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
