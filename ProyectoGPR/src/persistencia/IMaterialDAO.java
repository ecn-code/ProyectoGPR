package persistencia;

import java.util.ArrayList;

import excepciones.DAOExcepcion;

import logica.Material;

public interface IMaterialDAO {
public void modificarDisponiblesMaterial(Material material) throws DAOExcepcion;
public ArrayList<Material> getMateriales() throws DAOExcepcion;
}
