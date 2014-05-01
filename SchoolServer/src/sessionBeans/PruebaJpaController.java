/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entityClass.Prueba;
import java.io.Serializable;
import java.util.Date;
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
public class PruebaJpaController implements Serializable {

    public PruebaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //calucla el promedio de una prueba de una asignatura realizada en una fecha
    public float promedioGeneralPrueba(Date fecha, int id_asignatura){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Prueba.findByIdAsignaturaFecha").setParameter("idAsignatura",id_asignatura).
                setParameter("fecha", fecha);
        return sacaPromedio(query.getResultList());      
        
    }
    //saca promedio general asignatura
    public float promedioGeneralAsignatura(int id_asignatura){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Prueba.findByIdAsignatura").setParameter("idAsignatura", id_asignatura);
        
        return sacaPromedio(query.getResultList());
    }
    
    //calcula el promedio general de un alumno
    public float promedioGeneralAlumno(String rut){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Prueba.findByRut").setParameter("rut", rut);
        return sacaPromedio(query.getResultList());
        
    }
    
    //saca el promedio de notas de una lista de Pruebas
    public float sacaPromedio(List<Prueba> p){
        int cant = p.size();
        float prom = 0;
        float sum = 0;
        for(int i = 0; i< cant; i++){
            sum += p.get(i).getNota();            
        }
        prom = sum/cant;
        return prom;
    }
    
    //identifica las notas de un alumno de una asignatura
    public float sacaPromedioRamo(String rut , int id_asignatura){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Prueba.findByRutIdAsignatura").
                setParameter("rut", rut).
                setParameter("idAsignatura", id_asignatura);
        return sacaPromedio(query.getResultList());            
    }
    
    //Se guardan todas las notas de 1 alumno
    public List<Prueba> todasNotas(String rut){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Prueba.findByRut").
                setParameter("rut", rut);
        return query.getResultList();
    }
    
    //Obtiene la lista de notas segun el alumno y la asignatura
    public List<Prueba> notasPorAsignatura(String rut, int id){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Prueba.findByRutIdAsignatura").
                setParameter("rut", rut).
                setParameter("idAsignatura", id);
        return query.getResultList();
    }
    
    public void create(Prueba prueba) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(prueba);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Prueba prueba) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            prueba = em.merge(prueba);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = prueba.getIdPrueba();
                if (findPrueba(id) == null) {
                    throw new NonexistentEntityException("The prueba with id " + id + " no longer exists.");
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
            Prueba prueba;
            try {
                prueba = em.getReference(Prueba.class, id);
                prueba.getIdPrueba();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prueba with id " + id + " no longer exists.", enfe);
            }
            em.remove(prueba);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Prueba> findPruebaEntities() {
        return findPruebaEntities(true, -1, -1);
    }

    public List<Prueba> findPruebaEntities(int maxResults, int firstResult) {
        return findPruebaEntities(false, maxResults, firstResult);
    }

    private List<Prueba> findPruebaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Prueba.class));
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

    public Prueba findPrueba(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prueba.class, id);
        } finally {
            em.close();
        }
    }

    public int getPruebaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prueba> rt = cq.from(Prueba.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
