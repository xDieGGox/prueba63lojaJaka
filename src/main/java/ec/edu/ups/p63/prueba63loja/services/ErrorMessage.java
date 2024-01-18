package ec.edu.ups.p63.prueba63loja.services;

public class ErrorMessage {

	private int codigo;
	private String mensaje;
	
	public ErrorMessage(int codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
