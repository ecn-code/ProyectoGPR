package persistencia;
import java.sql.Date;
import java.util.ArrayList;

import logica.Area;
import logica.Incidencia;
import logica.Operario;
import logica.OrdenTrabajo;

import excepciones.*;
public interface IOrdenTrabajoDAO {
	
	public ArrayList<OrdenTrabajo> getOrdenesTrabajoPorArea(Area area) throws DAOExcepcion; 
	public ArrayList<OrdenTrabajo> getOrdenTrabajoPorOperario(Operario operario) throws DAOExcepcion; 
	public ArrayList<OrdenTrabajo> getOrdenTrabajoPorFecha(Date fecha1,Date fecha2) throws DAOExcepcion;
	public void modificarEstado(OrdenTrabajo orden) throws DAOExcepcion;
	public void crearOrdenTrabajo(OrdenTrabajo orden);
	public void asignarOrdenTrabajo(OrdenTrabajo orden, String dni);
	
}