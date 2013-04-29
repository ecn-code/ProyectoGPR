package persistencia;
import java.util.ArrayList;

import logica.Area;
import logica.Incidencia;


import excepciones.*;

public interface IIncidenciaDAO {
	void crearIncidencia(Incidencia in) throws DAOExcepcion; 
	void clasificarIncidencia(Incidencia in,Area area,String prioridad) throws DAOExcepcion; 
	ArrayList<Incidencia> getIncidencias() throws DAOExcepcion; 
}


	
