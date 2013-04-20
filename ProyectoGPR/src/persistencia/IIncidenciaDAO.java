package persistencia;
import java.util.ArrayList;

import excepciones.*;
import logica.Area;
import logica.Incidencia;

public interface IIncidenciaDAO {
	void crearIncidencia(Incidencia in) throws DAOExcepcion; 
	void clasificarIncidencia(Incidencia in,Area area,String prioridad) throws DAOExcepcion; 
	ArrayList<Incidencia> getIncidencias() throws DAOExcepcion; 
}


	
