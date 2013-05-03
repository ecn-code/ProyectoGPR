package persistencia;
import java.util.ArrayList;

import logica.Area;

import excepciones.DAOExcepcion;

public interface IAreaDAO {
public ArrayList<Area> getAreas() throws DAOExcepcion;
public Area getAreaPorNombre(String nombre)throws DAOExcepcion;
}
