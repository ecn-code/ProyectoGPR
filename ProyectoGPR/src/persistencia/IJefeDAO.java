package persistencia;

import java.util.ArrayList;

import logica.Area;
import logica.Jefe;
import excepciones.DAOExcepcion;

public interface IJefeDAO {
	public ArrayList<Jefe> getJefes() throws DAOExcepcion;
	public ArrayList<Jefe> getJefes(Area area);
	public Jefe loguearJefe(String nombre,String pass) throws DAOExcepcion;
}
