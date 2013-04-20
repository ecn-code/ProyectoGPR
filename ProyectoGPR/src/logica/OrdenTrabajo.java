package logica;

import java.sql.Date;

public class OrdenTrabajo extends Incidencia {
	private String prioridad,estado;
	public OrdenTrabajo(String _iD,String _nombre
			,String _descripcion, Date _fechaEntrada,String _prioridad,String _estado ){
		super(_iD,_nombre,_descripcion,_fechaEntrada);
		prioridad=_prioridad;
		estado=_estado;
	}
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String _prioridad) {
		prioridad = _prioridad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String _estado) {
		estado = _estado;
	}
	
}