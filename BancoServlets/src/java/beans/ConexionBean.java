/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import tablas.Cuentasbancarias;
import tablas.Operaciones;
import tablas.Propietarios;


@Stateless
public class ConexionBean {

 @PersistenceUnit
 EntityManagerFactory emf;
 
 public List findAll(){
 return emf.createEntityManager().createNamedQuery("Operaciones.findAll").getResultList();
 }
 
  public List findAllRankingNegativo(){
 return emf.createEntityManager().createNamedQuery("Cuentasbancarias.sortSaldoNegativo").getResultList();
 }
 
         
public List findSaldoNegativo(){
 return emf.createEntityManager().createNamedQuery("Operaciones.findSaldoNegativo").getResultList();
 }
  public Operaciones ObtenerOperacionPorID(int id){
        Query q = emf.createEntityManager().createNamedQuery("Operaciones.findByIdOperacion");
        q.setParameter("idOperacion", id);
        List<Operaciones> result = q.getResultList();
        Iterator iter = result.iterator();
        Operaciones a = (Operaciones) iter.next();
        return a;
 }

    public boolean ServletInsertarCuenta(Cuentasbancarias cuenta) {
          if (!existeCuenta(cuenta)) {
            EntityManager em = emf.createEntityManager();
            em.persist(cuenta);
            em.close();
            return true;
        }
        return false;}
    
    public boolean existeCuenta(Cuentasbancarias cuenta) {
        EntityManager em = emf.createEntityManager();
        Cuentasbancarias encontrado = em.find(Cuentasbancarias.class, cuenta.getNumeroCuenta());
        em.close();
        return encontrado != null;
    }
    
    public Propietarios findPropietarioByUsuario(String usuario) {
        Query q = emf.createEntityManager().createNamedQuery("Propietarios.findByUsuario");
        q.setParameter("usuario", usuario);
        List<Propietarios> result = q.getResultList();
        Iterator iter = result.iterator();
        Propietarios a = (Propietarios) iter.next();
        return a;
    }
}
