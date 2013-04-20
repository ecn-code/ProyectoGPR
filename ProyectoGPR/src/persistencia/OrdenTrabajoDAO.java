package persistencia;

import java.sql.Date;
import java.util.ArrayList;

import logica.Area;
import logica.Operario;
import logica.OrdenTrabajo;
import excepciones.DAOExcepcion;

public class OrdenTrabajoDAO implements IOrdenTrabajoDAO {

	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajo(Area area)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajo(Operario operario)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajo(Date fecha1, Date fecha2)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(OrdenTrabajo orden) throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}

}
