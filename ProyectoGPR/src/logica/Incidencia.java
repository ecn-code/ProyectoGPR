package logica;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Incidencia{
	
	private int iD;
	private String nombre;
	private String descripcion;
	private String fechaEntrada;

	//Constructor que se utiliza cuando se crea el aviso de incidencia
	public Incidencia(String _nombre, String _descripcion){
		this.nombre = _nombre;
		this.descripcion = _descripcion;
		this.fechaEntrada = this.getFechaActual();
	}
	
	//Constructor que se utiliza cuando se crea una incidencia existente
	//en la base de datos para ser mostrada en la tabla Avisos de Incidencia
	public Incidencia(int _iD, String _nombre, String _descripcion, 
			String _fechaEntrada){
		this.iD = _iD;
		this.nombre = _nombre;
		this.descripcion = _descripcion;
		this.fechaEntrada = _fechaEntrada;
	}
	
	//Constructor que se utiliza cuando se crea una incidencia existente
	//en la base de datos para ser mostrada en la tabla Órdenes de trabajo
	//del Maestro de área
	public Incidencia(int _iD, String _nombre, String _descripcion){
		this.iD = _iD;
		this.nombre = _nombre;
		this.descripcion = _descripcion;
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

	public int getID() {
		return this.iD;
	}

}
