package logica;

import java.sql.Date;

public class Incidencia implements IIncidencia{
	
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
	
	@Override
	public Date fechaEntrada() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
