package persistencia;

import java.util.ArrayList;

import logica.Area;
import logica.Operario;


import excepciones.DAOExcepcion;

public interface IOperarioDAO {
public Operario getOperario(String dni)throws DAOExcepcion ;
public Operario loguear(String nombre, String pass)throws DAOExcepcion ;
public ArrayList<Operario> getOperarios()throws DAOExcepcion;
public ArrayList<Operario> getOperariosPorArea(Area area)throws DAOExcepcion;
public Operario getOperarioPorNombre(String nombre);

}
