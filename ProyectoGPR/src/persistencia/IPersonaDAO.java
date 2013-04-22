package persistencia;

import logica.Operario;
import excepciones.DAOExcepcion;

public interface IPersonaDAO {
int loguear(String nombre,String pass) throws DAOExcepcion;
Operario getOperario(String dni) throws DAOExcepcion;
}
