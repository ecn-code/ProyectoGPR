package persistencia;

import java.sql.Date;
import java.util.ArrayList;

import logica.Area;
import logica.Incidencia;
import logica.Operario;
import logica.OrdenTrabajo;


import excepciones.*;

public class DAL {
	private static DAL dal;
	IncidenciaDAO inDAO;
	IAreaDAO arDAO;
	IOrdenTrabajoDAO orDAO;
	IOperarioDAO peDAO;
	
private DAL() throws DAOExcepcion{
	// Objectos para comunicarse con la capa de acceso a datos
	inDAO=new IncidenciaDAO();
	arDAO=new AreaDAO();
	orDAO=new OrdenTrabajoDAO();
	peDAO=new OperarioDAO();
}
public static DAL dameDAL() throws DAOExcepcion {
	if(dal==null)
		dal = new DAL();
	return dal;
	}
//metodos de incidencia
public void enviarIncidencia(Incidencia incidencia) throws DAOExcepcion {
	inDAO.crearIncidencia(incidencia);
}
public ArrayList<Incidencia> getIncidencias() throws DAOExcepcion {
	return inDAO.getIncidencias();
}
public void clasificarIncidencia(Incidencia incidencia, Area area, String prioridad)throws DAOExcepcion {
	inDAO.clasificarIncidencia(incidencia, area, prioridad);
}
//metodos de orden de trabajo
public ArrayList<OrdenTrabajo> encontrarOrdenesTrabajoPorArea(Area area)throws DAOExcepcion{
	return orDAO.getOrdenTrabajo(area);
}
public ArrayList<OrdenTrabajo> encontrarOrdenesTrabajoPorOperario(Operario operario)throws DAOExcepcion{
	return orDAO.getOrdenTrabajo(operario);
}
public ArrayList<OrdenTrabajo> encontrarOrdenesTrabajoPorFecha(Date fecha_ini,Date fecha_fin)throws DAOExcepcion{
	return orDAO.getOrdenTrabajo(fecha_ini,fecha_fin);
}
public void modificarOrdenTrabajo(OrdenTrabajo orden)throws DAOExcepcion{
	orDAO.modificar(orden);
}
public void enviarOrdenTrabajo(OrdenTrabajo orden)throws DAOExcepcion{
	orDAO.crearOrdenTrabajo(orden);
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
public ArrayList<Area> encontrarAreas() throws DAOExcepcion{
	return arDAO.getArea();
}
public Area encontrarAreaPorNombre(String nombre) throws DAOExcepcion{
	return arDAO.getArea(nombre);
}
//metodos de Material
}