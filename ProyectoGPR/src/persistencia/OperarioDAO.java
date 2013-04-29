package persistencia;

import java.util.ArrayList;

import logica.Area;
import logica.Operario;
import excepciones.DAOExcepcion;

public class OperarioDAO implements IOperarioDAO {

	@Override
	public Operario getOperario(String dni) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int loguear(String nombre, String pass) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Operario> getOperarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Operario> getOperarios(Area area) {
		// TODO Auto-generated method stub
		return null;
	}

}
