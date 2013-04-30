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
}
