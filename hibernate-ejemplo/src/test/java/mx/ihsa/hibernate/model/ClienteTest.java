package mx.ihsa.hibernate.model;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class ClienteTest {

	EntityManagerFactory factory= Persistence.createEntityManagerFactory("UnidadPersistencia");
	EntityManager em =factory.createEntityManager();
	
	
	@Test
	public void testInsert() {
		Cliente cliente= new Cliente();
		cliente.setIdCte(2);
		cliente.setNomCte("Carlos");
		cliente.setApePatCte("Ibarra");
		cliente.setApeMatCte("Mares");
		cliente.setTelCte("8125923369");
		cliente.setDirCte("Garcia NL");
		cliente.setIdEdoCte(2);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		assertNull(cliente);
		
	}
	
	@Test
	public void testUpdate() {
		
		Cliente cliente= new Cliente();
		cliente.setIdCte(2);
		cliente.setNomCte("Carlos");
		cliente.setApePatCte("Ibarra");
		cliente.setApeMatCte("Mares");
		cliente.setTelCte("8125923369");
		cliente.setDirCte("Garcia NL xxxxx");
		cliente.setIdEdoCte(2);
		
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		assertNull(cliente);
	}
	
	@Test
	public void testDelete() {
		
		Cliente cliente= em.find(Cliente.class, 2);
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		assertNull(cliente);
	}
	
	@Test
	public void testListar() {
		Query qry=em.createQuery("From Cliente");
		List<Cliente> clientes=(List<Cliente>) qry.getResultList();
		assertFalse(clientes.isEmpty());
		
		for(Cliente cliente: clientes) {
			System.out.println("Cliente==="+cliente.getIdCte()+" "+cliente.getNomCte());
			
		}
		
	}

}
