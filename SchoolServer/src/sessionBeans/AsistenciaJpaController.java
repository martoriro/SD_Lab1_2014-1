/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entityClass.Asistencia;
import entityClass.Usuario;
import entityClass.mergeClasses.*;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sessionBeans.exceptions.NonexistentEntityException;

/**
 *
 * @author Joel
 */
public class AsistenciaJpaController implements Serializable {

    public AsistenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //Funcionalidad, guarda las asistencias filtradas por rut, para mostrarlas a apoderados.
    public List<Asistencia> asistenciaAlumnoApoderado(String rut){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Asistencia.findByRut").
                setParameter("rut", rut);
        return query.getResultList();
    }
    
    public void create(Asistencia asistencia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asistencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Asistencia asistencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            asistencia = em.merge(asistencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = asistencia.getIdAsistencia();
                if (findAsistencia(id) == null) {
                    throw new NonexistentEntityException("The asistencia with id " + id + " no longer exists.");
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
            Asistencia asistencia;
            try {
                asistencia = em.getReference(Asistencia.class, id);
                asistencia.getIdAsistencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The asistencia with id " + id + " no longer exists.", enfe);
            }
            em.remove(asistencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Asistencia> findAsistenciaEntities() {
        return findAsistenciaEntities(true, -1, -1);
    }

    public List<Asistencia> findAsistenciaEntities(int maxResults, int firstResult) {
        return findAsistenciaEntities(false, maxResults, firstResult);
    }

    private List<Asistencia> findAsistenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Asistencia.class));
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

    public Asistencia findAsistencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Asistencia.class, id);
        } finally {
            em.close();
        }
    }
    
    //Utiliza una clase especial creada para guardar el cruce de tablas: "AsistenciaRamo" obtenido de la query y calcula el promedio de asistencia diaria
    public float promedioAsistenciaDia(String rut, Date fecha){
        float asistentes = 0;
        float total = 0;
        float resultado;
        List<AsistenciaRamo> asistencias = new ArrayList<>();
        List<Object[]> resultados = findAsistenciaPorRutyFecha(rut, fecha);
        for(Object[] result: resultados)
            asistencias.add(new AsistenciaRamo((String)result[0], (int)result[1], (Date)result[2], (int)result[3]));
        for(AsistenciaRamo asistencia: asistencias){
            if(asistencia.getEstado() == 1){
                asistentes++;
            }
            total++;
        }
        resultado = (asistentes/total)*100;
        return resultado;
    }
    
    //Utiliza una clase especial creada para guardar el cruce de tablas: "AsistenciaRamo" obtenido de la query y calcula el promedio de asistencia mensual
    public float promedioAsistenciaMes(String rut, int mes){
        mes--;
        float asistentes = 0;
        float total = 0;
        float resultado;
        List<AsistenciaRamo> asistencias = new ArrayList<>();
        List<Object[]> resultados = findAsistenciaPorRutyMes(rut, mes);
        for(Object[] result: resultados)
            asistencias.add(new AsistenciaRamo((String)result[0], (int)result[1], (Date)result[2], (int)result[3]));
        for(AsistenciaRamo asistencia: asistencias){
            if(asistencia.getFecha().getMonth() == mes){
                if(asistencia.getEstado() == 1){
                    asistentes++;
                }
                total++;
            }
        }
        resultado = (asistentes/total)*100;
        return resultado;
    }
    
    //Busca Asistencia por dia y rut (asume una asignatura por profesor)
    public List findAsistenciaPorRutyFecha(String rut, Date fecha){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Asistencia.findAlumnosByRutAndFecha").
                setParameter("rut", rut).
                setParameter("fecha", fecha);
        return query.getResultList();
    }
    
    //Busca Asistencia por mes y rut (asume una asignatura por profesor)
    public List findAsistenciaPorRutyMes(String rut, int mes){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Asistencia.findAlumnosByRut").
                setParameter("rut", rut);
        return query.getResultList();
    }

    public int getAsistenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Asistencia> rt = cq.from(Asistencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
