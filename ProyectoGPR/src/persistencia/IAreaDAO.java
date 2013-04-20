package persistencia;
import java.util.ArrayList;
import excepciones.DAOExcepcion;
import logica.Area;

public interface IAreaDAO {
public ArrayList<Area> getArea() throws DAOExcepcion;
public Area getArea(String nombre)throws DAOExcepcion;
}
