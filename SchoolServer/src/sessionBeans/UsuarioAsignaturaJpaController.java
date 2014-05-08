/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entityClass.UsuarioAsignatura;
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
 * @author Joel
 */
public class UsuarioAsignaturaJpaController implements Serializable {

    public UsuarioAsignaturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Listar IDS asignaturas por rut
    public List<UsuarioAsignatura> AsignaturasRut(String rut){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("UsuarioAsignatura.findByRut").
                setParameter("rut", rut);
        return query.getResultList();
    }
    
    //Listar ruts por id asignatura
    public List<UsuarioAsignatura> AsignaturasID(int idAsignatura){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("UsuarioAsignatura.findByIdAsignatura").
                setParameter("idAsignatura", idAsignatura);
        
        return query.getResultList();
    }
    
    public List<UsuarioAsignatura> buscarRegistro(String rut, int idAsignatura){
        EntityManager em = getEntityManager();
        Query query;
        
        query = em.createNamedQuery("UsuarioAsignatura.findByRutIdAsignatura").
                setParameter("rut", rut).
                setParameter("idAsignatura", idAsignatura);
               
        return query.getResultList();
    }
    
    public void create(UsuarioAsignatura usuarioAsignatura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioAsignatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioAsignatura usuarioAsignatura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioAsignatura = em.merge(usuarioAsignatura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarioAsignatura.getIdUsuarioAsignatura();
                if (findUsuarioAsignatura(id) == null) {
                    throw new NonexistentEntityException("The usuarioAsignatura with id " + id + " no longer exists.");
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
            UsuarioAsignatura usuarioAsignatura;
            try {
                usuarioAsignatura = em.getReference(UsuarioAsignatura.class, id);
                usuarioAsignatura.getIdUsuarioAsignatura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioAsignatura with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioAsignatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioAsignatura> findUsuarioAsignaturaEntities() {
        return findUsuarioAsignaturaEntities(true, -1, -1);
    }

    public List<UsuarioAsignatura> findUsuarioAsignaturaEntities(int maxResults, int firstResult) {
        return findUsuarioAsignaturaEntities(false, maxResults, firstResult);
    }

    private List<UsuarioAsignatura> findUsuarioAsignaturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioAsignatura.class));
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

    public UsuarioAsignatura findUsuarioAsignatura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioAsignatura.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioAsignaturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioAsignatura> rt = cq.from(UsuarioAsignatura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
