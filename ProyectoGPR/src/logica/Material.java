package logica;

import java.sql.Date;

public class Material {
	private String iD;
	private String nombre;
	private String descripcion;
	private int disponibles; 
	public Material(String _iD,String _nombre,String _descripcion,int _disponibles){
		iD=_iD;
		nombre=_nombre;
		descripcion=_descripcion;
		disponibles=_disponibles;
	}
	public String getID() {
		return iD;
	}
	public void setID(String id) {
		iD = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDisponibles() {
		return disponibles;
	}
	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
}
