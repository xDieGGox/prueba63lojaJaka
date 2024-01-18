package ec.edu.ups.p63.prueba63loja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Deuda {
	
	@Id
	@GeneratedValue
	private int codigo;
	private String mes;
	private double valor;
	
	//GETTERS ANDA SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	//TO STRING
	
	@Override
	public String toString() {
		return "Deuda [codigo=" + codigo + ", mes=" + mes + ", valor=" + valor + "]";
	}
	
	
	
	

}
