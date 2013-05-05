package persistencia;

import java.sql.Date;
import java.util.ArrayList;

import logica.Area;
import logica.Incidencia;
import logica.Jefe;
import logica.Maestro;
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
	IMaestroDAO maestroDAO;
	IJefeDAO jefeDAO;
	
private DAL() throws DAOExcepcion{
	// Objectos para comunicarse con la capa de acceso a datos
	this.inDAO = new IncidenciaDAO();
	this.arDAO = new AreaDAO();
	this.orDAO = new OrdenTrabajoDAO();
	this.peDAO = new OperarioDAO();
	this.maDAO = new MaterialDAO();
	this.maestroDAO = new MaestroDAO();
	this.jefeDAO = new JefeDAO();
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
public ArrayList<OrdenTrabajo> getOrdenesTrabajoPorOperario(Operario operario)throws DAOExcepcion{
	return orDAO.getOrdenTrabajoPorOperario(operario);
}
public ArrayList<OrdenTrabajo> getOrdenTrabajoPorFecha(Date fecha_ini,Date fecha_fin)throws DAOExcepcion{
	return orDAO.getOrdenTrabajoPorFecha(fecha_ini,fecha_fin);
}
public void modificarOrdenTrabajo(OrdenTrabajo orden)throws DAOExcepcion{
	orDAO.modificarEstado(orden);
}
public void crearOrdenTrabajo(OrdenTrabajo orden)throws DAOExcepcion{
	this.orDAO.crearOrdenTrabajo(orden);
}

public void asignarOrdenTrabajo(OrdenTrabajo orden, String dni)throws DAOExcepcion{
	this.orDAO.asignarOrdenTrabajo(orden, dni);
}


//metodos de operario

public Operario getOperarioPorNombre(String nombre) throws DAOExcepcion{
	return peDAO.getOperarioPorNombre(nombre);
}

public Operario encontrarOperarioPorDNI(String dni)throws DAOExcepcion{
	return peDAO.getOperario(dni);
}
public ArrayList<Operario> getOperariosPorArea(Area area)throws DAOExcepcion{
		return peDAO.getOperariosPorArea(area);
}
public ArrayList<Operario> encontrarOperarios()throws DAOExcepcion{
	return peDAO.getOperarios();
}
public Operario loguearOperario(String nombre,String pass)throws DAOExcepcion{
	return peDAO.loguear(nombre,pass);
}
//metodos de Area
public ArrayList<Area> getAreas() throws DAOExcepcion{
	return arDAO.getAreas();
}
public Area getAreaPorNombre(String nombre) throws DAOExcepcion{
	return arDAO.getAreaPorNombre(nombre);
}
//metodos de Material
public ArrayList<Material> encontrarMateriales() throws DAOExcepcion{
	return maDAO.getMateriales();
}
public void modificarDisponiblesMaterial(Material material) throws DAOExcepcion{
	maDAO.modificarDisponiblesMaterial(material);
}

public Maestro loguearMaestro(String nombre, String pass) throws DAOExcepcion {
	// TODO Auto-generated method stub
	return maestroDAO.loguearMaestro(nombre,pass);
}

public Jefe loguearJefe(String nombre, String pass) throws DAOExcepcion {
	// TODO Auto-generated method stub
	return jefeDAO.loguearJefe(nombre,pass);
}
}