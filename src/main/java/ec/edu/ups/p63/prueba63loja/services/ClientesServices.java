package ec.edu.ups.p63.prueba63loja.services;

import java.util.List;

import ec.edu.ups.p63.prueba63loja.business.GestionClientes;
import ec.edu.ups.p63.prueba63loja.model.Cliente;
import ec.edu.ups.p63.prueba63loja.services.ErrorMessage;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class ClientesServices {
	
	@Inject
	private GestionClientes gClientes;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Cliente cliente) {
		try {
			gClientes.guardarClientes(cliente); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return Response.ok(cliente).build();
			//return "OK";
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
		
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente cliente) {
		try {
			gClientes.actualizarCliente(cliente); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return Response.ok(cliente).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try {
			gClientes.borrarCliente(codigo); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return "OK";
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public Cliente leer(@QueryParam("dni")String cedula) {
		try {
			return gClientes.getClientePorCedula(cedula); //Estos son los metodos o servicios
		}catch (Exception e) {
			return new Cliente(); 
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	public Response leer1(@QueryParam("dni")String cedula, @QueryParam("nombre")String nombre) {
		try {
			System.out.println("cedula " +  cedula + " nom=" + nombre);
			Cliente cli = gClientes.getClientePorCedula(cedula);
			return Response.ok(cli).build();
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(4, "Cliente no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build(); 
		}
	}
	
	@GET
	@Path("{dni}/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer2(@PathParam("dni") String cedula, @PathParam("nombre") String nombre) {
		try{
			System.out.println("cedula " +  cedula + " nom=" + nombre);
			Cliente cli = gClientes.getClienteconDeudas(cedula);
			return Response.ok(cli).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Cliente no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listnormal")//Esto es necesario cuando tenemos mas de un metodo GET pues
	public List<Cliente> getClientesNomrmal(){
		return gClientes.getClientes();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Cliente> clientes = gClientes.getClientes();
		if(clientes.size()>0)
			return Response.ok(clientes).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}

}
