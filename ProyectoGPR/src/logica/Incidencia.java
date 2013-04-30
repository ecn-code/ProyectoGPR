package logica;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Incidencia{
	
	private String iD;
	private String nombre;
	private String descripcion;
	private String fechaEntrada;

	public Incidencia(String _iD, String _nombre, String _descripcion){
		this.iD = _iD;
		this.nombre = _nombre;
		this.descripcion = _descripcion;
		this.fechaEntrada = this.getFechaActual();
	}
	
	public Incidencia(String _iD, String _nombre, String _descripcion, 
			String _fechaEntrada){
		this.iD = _iD;
		this.nombre = _nombre;
		this.descripcion = _descripcion;
		this.fechaEntrada = _fechaEntrada;
	}
	
	public String getFechaActual() {
		// TODO Auto-generated method stub
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String cadenaFechaActual = formato.format(fechaActual);
		return cadenaFechaActual;
	}

	public String getFechaEntrada(){
		return this.fechaEntrada;
	}

	public String getDescripcion() {
		// TODO Auto-generated method stub
		return this.descripcion;
	}

	
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public String getID() {
		return this.iD;
	}

}
