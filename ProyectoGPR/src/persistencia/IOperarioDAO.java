package persistencia;

import java.util.ArrayList;

import logica.Area;
import logica.Operario;


import excepciones.DAOExcepcion;

public interface IOperarioDAO {
public Operario getOperario(String dni) throws DAOExcepcion;
<<<<<<< HEAD
public int loguear(String nombre, String pass) throws DAOExcepcion;
public ArrayList<Operario> getOperarios();
public ArrayList<Operario> getOperarios(Area area);
=======
public ArrayList<Operario> getOperarios() throws DAOExcepcion;
public ArrayList<Operario> getOperarios(Area area)throws DAOExcepcion;
>>>>>>> origin/Roberto
}
