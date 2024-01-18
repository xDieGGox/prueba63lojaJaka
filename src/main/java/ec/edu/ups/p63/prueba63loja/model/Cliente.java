package ec.edu.ups.p63.prueba63loja.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	private int codigo;
	private String dni;
	private String nombre;
	private String direccion;
	
	@OneToMany(cascade = CascadeType.ALL)//Con esto es donde vamos a agrefar los detalles a la factura
	@JoinColumn(name="codigo_factura")
	private List<Deuda> deudas;
	
	//GETTERS AND SETTERS

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Deuda> getDeudas() {
		return deudas;
	}

	public void setDeudas(List<Deuda> deudas) {
		this.deudas = deudas;
	}

	public void addDeuda(Deuda deuda) {
		if(deudas == null)
			deudas = new ArrayList<Deuda>();
		
		deudas.add(deuda);
	}
	
	
	
	
	//TO STRING
	
	@Override
	public String toString() {
	    return "Cliente [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion
	            + ", deudas=" + (deudas != null ? deudas : "No hay deudas") + "]";
	}
	
	
	
	
	
	

}
