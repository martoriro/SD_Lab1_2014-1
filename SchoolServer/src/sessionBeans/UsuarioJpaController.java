/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import encriptador.*;
import entityClass.Usuario;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
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
 * @author Joel
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Usuario> todos(){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Usuario.findAll");
                
        return query.getResultList();
    }
    
    public List<Usuario> sinApoderados(){
        String probar = null;
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Usuario.findByRutApoderado").
                setParameter("rutApoderado", null);
        
        return query.getResultList();
    }
    
    public List<Usuario> buscarUsuario(String rut){
        EntityManager em = getEntityManager();
        Query query;
        query = em.createNamedQuery("Usuario.findByRut").
                setParameter("rut", rut);
        
        return query.getResultList();
    }
            
    //Comprueba si se admite el acceso o no
    public String login(String rut, String password) throws NoSuchAlgorithmException{
        List<Usuario> user = buscarUsuario(rut);
        MD5 instancia = new MD5();        
        if(user.size()==0){
            return null;
        }else{
            if(user.get(0).getPassword().equals(instancia.encriptar(password))){
                return user.get(0).getTipo();
            }else{
                return null;
            }
        }
    }
    
    //Lista que retorna los apoderados de un padre
    public List<Usuario> buscarHijos(String rutApoderado){
        EntityManager em = getEntityManager();
        Query query;
        
        query = em.createNamedQuery("Usuario.findByRutApoderado").
                setParameter("rutApoderado", rutApoderado);
        
        return query.getResultList();
    }
    
    //Obtener profesores
    public List<Usuario> buscarProfesor(){
        EntityManager em = getEntityManager();
        Query query;
        
        query = em.createNamedQuery("Usuario.findByTipo").
                setParameter("tipo", "profesor");
        
        return query.getResultList();
    }
    
    public List<Usuario> buscarAlumnos(){
        EntityManager em = getEntityManager();
        Query query;
        
        query = em.createNamedQuery("Usuario.findByTipo").
                setParameter("tipo", "alumno");
        
        return query.getResultList();
    }
    
    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getRut()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuario = em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuario.getRut();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getRut();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
