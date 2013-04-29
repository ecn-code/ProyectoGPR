package persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.Area;
import logica.Incidencia;
import logica.Operario;
import logica.OrdenTrabajo;
import excepciones.DAOExcepcion;

public class OrdenTrabajoDAO implements IOrdenTrabajoDAO {
	private ConnectionManager connManager;

	public OrdenTrabajoDAO()throws DAOExcepcion{
		try{
			connManager= new ConnectionManager("practicaGPR");
			}catch (ClassNotFoundException e){
				throw new DAOExcepcion("DB_CONNECT_ERROR");
			}
	}
	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajo(Area _area)
			throws DAOExcepcion {
			// TODO Auto-generated method stub
		
			try{
				connManager.connect();
				ResultSet rs=connManager.queryDB("select * from INCIDENCIA inc,ORDENDETRABAJO ord where ord.ID=inc.ID and NOMBRE_AREA='"+_area.getNombre()+"'");
				connManager.close();
				
				try {
					ArrayList<OrdenTrabajo> ordenesTrabajo = new ArrayList<OrdenTrabajo>();
					IOperarioDAO persona=new OperarioDAO();
					IAreaDAO areaDao=new AreaDAO();
					while(rs.next()){
						
						Operario operario=persona.getOperario(rs.getString("DNI"));
						Area area=areaDao.getArea(rs.getString("NOMBRE_AREA"));
						OrdenTrabajo orden = new OrdenTrabajo(rs.getString("ID"),rs.getString("NOMBRE")
								,rs.getString("DESCRIPCION"),rs.getDate("FECHADEENTRADA"),rs.getString("PRIORIDAD")
								,rs.getString("ESTADO"),operario,area);
						
						ordenesTrabajo.add(orden);
					}
					return ordenesTrabajo;
					}catch (SQLException e){
						throw new DAOExcepcion("DB_READ_ERROR");
					}
				
				}catch (DAOExcepcion e){
					throw e;
				}
	}

	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajo(Operario _operario)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from INCIDENCIA inc,ORDENDETRABAJO ord where ord.ID=inc.ID and DNI='"+_operario.getDNI()+"'");
			connManager.close();
			try {
				ArrayList<OrdenTrabajo> ordenesTrabajo = new ArrayList<OrdenTrabajo>();
				while(rs.next()){
					
					Area area=new Area(rs.getString("NOMBRE_AREA"));
					OrdenTrabajo orden = new OrdenTrabajo(rs.getString("ID"),rs.getString("NOMBRE")
							,rs.getString("DESCRIPCION"),rs.getDate("FECHADEENTRADA"),rs.getString("PRIORIDAD")
							,rs.getString("ESTADO"),_operario,area);
					
					ordenesTrabajo.add(orden);
				}
				return ordenesTrabajo;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}

	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajo(Date fecha1, Date fecha2)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from INCIDENCIA inc,ORDENDETRABAJO ord where ord.ID=inc.ID and FECHADEENTRADA>='"+fecha1+"' and FECHADEENTRADA<='"+fecha2+"'");
			connManager.close();
			
			try {
				ArrayList<OrdenTrabajo> ordenesTrabajo = new ArrayList<OrdenTrabajo>();
				IOperarioDAO persona=new OperarioDAO();
				IAreaDAO areaDao=new AreaDAO();
				while(rs.next()){
					
					Operario operario=persona.getOperario(rs.getString("DNI"));
					Area area=areaDao.getArea(rs.getString("NOMBRE_AREA"));
					OrdenTrabajo orden = new OrdenTrabajo(rs.getString("ID"),rs.getString("NOMBRE")
							,rs.getString("DESCRIPCION"),rs.getDate("FECHADEENTRADA"),rs.getString("PRIORIDAD")
							,rs.getString("ESTADO"),operario,area);
					
					ordenesTrabajo.add(orden);
				}
				return ordenesTrabajo;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}

	@Override
	public void modificar(OrdenTrabajo orden) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
				connManager.connect();
				connManager.updateDB("update ORDENDETRABAJO set PRIORIDAD='"+orden.getPrioridad()+"', ESTADO='"+orden.getEstado()+"'where ID='"+orden.getID()+"'");
				connManager.close();
	
			}catch (DAOExcepcion e){
				throw e;
			}
	
			
	}
	@Override
	public void crearOrdenTrabajo(Incidencia incidencia, Area area,
			String prioridad) {
		// TODO Auto-generated method stub
		
	}

}
