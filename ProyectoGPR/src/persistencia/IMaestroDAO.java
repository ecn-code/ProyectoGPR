package persistencia;

import java.util.ArrayList;

import excepciones.DAOExcepcion;

import logica.Area;
import logica.Maestro;

public interface IMaestroDAO {
public ArrayList<Maestro> getMaestros() throws DAOExcepcion;
public ArrayList<Maestro> getMaestros(Area area);
public Maestro loguearMaestro(String nombre,String pass) throws DAOExcepcion;
}
