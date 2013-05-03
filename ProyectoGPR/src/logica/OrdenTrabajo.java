package logica;

import java.sql.Date;

public class OrdenTrabajo extends Incidencia {
	
	private String estado;
	private int prioridad;
	private Operario operario;
	private Area area;
	
	
	
	public OrdenTrabajo(int _iD, String _nombre, String _descripcion, 
			int _prioridad, String _estado, Operario _operario, Area _area ){
		super(_iD, _nombre, _descripcion);
		this.prioridad = _prioridad;
		this.estado = _estado;
		this.operario = _operario;
		this.area = _area;
	}
	
	public OrdenTrabajo(Incidencia _incidencia, Area _area, int _prioridad){
		super(_incidencia.getID(), _incidencia.getNombre(), _incidencia.getDescripcion(),
				_incidencia.getFechaEntrada());
		this.prioridad =_prioridad;
		this.estado = "PENDIENTE";
		this.operario = null;
		this.area = _area;
	}
	public OrdenTrabajo(int id, int _prioridad, String _estado,
			String _nombreArea) {
		super(id, null, null);
		this.prioridad =_prioridad;
		this.estado = _estado;
		area = new Area(_nombreArea);
	}

	public int getPrioridad() {
		return this.prioridad;
	}
	public void setPrioridad(int _prioridad) {
		this.prioridad = _prioridad;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String _estado) {
		this.estado = _estado;
	}
	public Operario getOperario() {
		return this.operario;
	}
	public void setOperario(Operario operario) {
		this.operario = operario;
	}
	public Area getArea() {
		return this.area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
}
