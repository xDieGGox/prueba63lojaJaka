package ec.edu.ups.p63.prueba63loja.dao;

import java.util.List;

import ec.edu.ups.p63.prueba63loja.model.Cliente;
import ec.edu.ups.p63.prueba63loja.model.Deuda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
		
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
			
	}
	
	public void remove(int codigo) {
		Cliente cliente = em.find(Cliente.class, codigo);
		em.refresh(cliente);
		
	}
	
	public Cliente read (int codigo) {
		Cliente Factura = em.find(Cliente.class, codigo);
		
		return Factura;
		
	}
	
	public List<Cliente> getAll(){
		String jpql = "SELECT c FROM Cliente c";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	}
	
	
	public Cliente getClientePorCedula(String cedula) {
		String jpql = "SELECT c FROM Cliente c WHERE c.dni=:cedula";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("cedula", cedula);
		List<Cliente> clientes = q.getResultList();
		if(clientes.size()>0)
			return clientes.get(0);
		return null;
 	}
	
	
	public List<Cliente> getAllWithDeudas() {
        String jpql = "SELECT c FROM Cliente c LEFT JOIN FETCH c.deudas";
        Query query = em.createQuery(jpql, Cliente.class);
        return query.getResultList();
    }
	
	public Cliente getClienteConDeudas(String cedula) {
	    String jpql = "SELECT c FROM Cliente c LEFT JOIN FETCH c.deudas WHERE c.dni=:cedula";
	    Query query = em.createQuery(jpql, Cliente.class);
	    query.setParameter("cedula", cedula);
	    
	    try {
	        return (Cliente) query.getSingleResult();
	    } catch (Exception e) {
	        return null; // Devuelve null si no se encuentra el cliente con la cédula especificada
	    }
	}
}
