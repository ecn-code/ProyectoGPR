package logica;

import java.util.Date;



public class Incidencia{
	
	private String iD;
	private String nombre;
	private String descripcion;
	private Date fechaEntrada;

	public Incidencia(String _iD,String _nombre
			,String _descripcion, Date _fechaEntrada){
		iD = _iD;
		nombre = _nombre;
		descripcion = _descripcion;
		fechaEntrada = _fechaEntrada;
	}
	
	public Date getFechaEntrada() {
		// TODO Auto-generated method stub
		return fechaEntrada;
	}


	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}

	
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public String getID() {
		return iD;
	}

}
