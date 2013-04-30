package logica;

import java.sql.Date;

public class OrdenTrabajo extends Incidencia {
	private String prioridad,estado;
	Operario operario;
	Area area;
	public OrdenTrabajo(String _iD,String _nombre
			,String _descripcion, Date _fechaEntrada,String _prioridad,String _estado, Operario _operario, Area _area ){
		super(_iD,_nombre,_descripcion,_fechaEntrada);
		prioridad=_prioridad;
		estado=_estado;
		operario=_operario;
		area=_area;
	}
	public OrdenTrabajo(Incidencia _incidencia,Area _area,String _prioridad){
		super(_incidencia.getID(),_incidencia.getNombre(),_incidencia.getDescripcion(),_incidencia.getFechaEntrada());
		prioridad=_prioridad;
		estado="nada";
		operario=null;
		area=_area;
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
	public Operario getOperario() {
		return operario;
	}
	public void setOperario(Operario operario) {
		this.operario = operario;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
}
