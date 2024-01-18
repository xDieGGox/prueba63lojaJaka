package ec.edu.ups.p63.prueba63loja.business;

import java.util.List;

import ec.edu.ups.p63.prueba63loja.dao.ClienteDAO;
import ec.edu.ups.p63.prueba63loja.model.Cliente;
import ec.edu.ups.p63.prueba63loja.model.Deuda;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando programa");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("0107323180");
		cliente.setNombre("DIEGO LOJA");
		cliente.setDireccion("Cristo del Consuelo"); 
		
		Deuda deuda = new Deuda();
		deuda.setMes("Enero");
		deuda.setValor(100.90); 
		
		cliente.addDeuda(deuda);
		
		deuda = new Deuda();
		deuda.setMes("Febrero");
		deuda.setValor(50.90); 
		
		cliente.addDeuda(deuda); 
		
		daoCliente.insert(cliente); 
		
		cliente = new Cliente();
		cliente.setCodigo(2);
		cliente.setDni("0102376225"); 
		cliente.setNombre("MESIAS LOJA");
		cliente.setDireccion("Ricaurte");
		
		daoCliente.insert(cliente); 
		
		/*
		List<Cliente> list = daoCliente.getAllWithDeudas();
		
		
		for(Cliente cli: list) {
			System.out.println(cli.getCodigo()+"\t"+ cli.getDni()+"\t"+cli.getNombre()+"\t"+cli.getDireccion()+"\t"+cli.getDeudas().get(0));
		}
		*/
		
	}

}
