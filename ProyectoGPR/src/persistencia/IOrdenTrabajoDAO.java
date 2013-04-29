package persistencia;
import java.sql.Date;
import java.util.ArrayList;
import excepciones.*;
import logica.Incidencia;
import logica.Operario;
import logica.Area;
import logica.OrdenTrabajo;
public interface IOrdenTrabajoDAO {
	ArrayList<OrdenTrabajo> getOrdenTrabajo(Area area) throws DAOExcepcion; 
	ArrayList<OrdenTrabajo> getOrdenTrabajo(Operario operario) throws DAOExcepcion; 
	ArrayList<OrdenTrabajo> getOrdenTrabajo(Date fecha1,Date fecha2) throws DAOExcepcion;
	void modificar(OrdenTrabajo orden) throws DAOExcepcion;
	public void crearOrdenTrabajo(Incidencia incidencia, Area area,
			String prioridad);
}