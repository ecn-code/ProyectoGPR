package persistencia;

import java.sql.Date;
import java.util.ArrayList;

import logica.Area;
import logica.Incidencia;
import logica.Material;
import logica.Operario;
import logica.OrdenTrabajo;


import excepciones.*;

public class DAL {
	private static DAL dal;
	IncidenciaDAO inDAO;
	IAreaDAO arDAO;
	IOrdenTrabajoDAO orDAO;
	IOperarioDAO peDAO;
	IMaterialDAO maDAO;
	
private DAL() throws DAOExcepcion{
	// Objectos para comunicarse con la capa de acceso a datos
	this.inDAO = new IncidenciaDAO();
	this.arDAO = new AreaDAO();
	this.orDAO = new OrdenTrabajoDAO();
	this.peDAO = new OperarioDAO();
	this.maDAO = new MaterialDAO();
}
public static DAL dameDAL() throws DAOExcepcion {
	if(dal == null)
		dal = new DAL();
	return dal;
	}
//metodos de incidencia
public void enviarIncidencia(Incidencia incidencia) throws DAOExcepcion {
	inDAO.crearIncidencia(incidencia);
}
public ArrayList<Incidencia> getIncidencias() throws DAOExcepcion {
	return this.inDAO.getIncidencias();
}
public void clasificarIncidencia(Incidencia incidencia, Area area, int prioridad)throws DAOExcepcion {
	this.inDAO.clasificarIncidencia(incidencia, area, prioridad);
}
//metodos de orden de trabajo
public ArrayList<OrdenTrabajo> getOrdenesTrabajoPorArea(Area area)throws DAOExcepcion{
	return orDAO.getOrdenesTrabajoPorArea(area);
}
public ArrayList<OrdenTrabajo> getOrdenTrabajoPorOperario(Operario operario)throws DAOExcepcion{
	return orDAO.getOrdenTrabajoPorOperario(operario);
}
public ArrayList<OrdenTrabajo> getOrdenTrabajoPorFecha(Date fecha_ini,Date fecha_fin)throws DAOExcepcion{
	return orDAO.getOrdenTrabajoPorFecha(fecha_ini,fecha_fin);
}
public void modificarOrdenTrabajo(OrdenTrabajo orden)throws DAOExcepcion{
	orDAO.modificar(orden);
}
public void asignarOrdenTrabajo(OrdenTrabajo orden)throws DAOExcepcion{
	this.orDAO.crearOrdenTrabajo(orden);
}


//metodos de persona

public Operario encontrarOperarioPorDNI(String dni)throws DAOExcepcion{
	return peDAO.getOperario(dni);
}
public ArrayList<Operario> encontrarOperariosPorArea(Area area)throws DAOExcepcion{
		return peDAO.getOperarios(area);
}
public ArrayList<Operario> encontrarOperarios()throws DAOExcepcion{
	return peDAO.getOperarios();
}
public int loguearOperario(String nombre,String pass)throws DAOExcepcion{
	return peDAO.loguear(nombre,pass);
}
//metodos de Area
public ArrayList<Area> getAreas() throws DAOExcepcion{
	return arDAO.getAreas();
}
public Area getAreaPorNombre(String nombre) throws DAOExcepcion{
	return arDAO.getArea(nombre);
}
//metodos de Material
public ArrayList<Material> encontrarMateriales() throws DAOExcepcion{
	return maDAO.getMateriales();
}
public void modificarDisponiblesMaterial(Material material) throws DAOExcepcion{
	maDAO.modificarDisponiblesMaterial(material);
}
}