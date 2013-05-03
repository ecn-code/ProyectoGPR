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
			this.connManager = new ConnectionManager("practicaGPR");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion("DB_CONNECT_ERROR");
		}
	}
	
	@Override
	public ArrayList<OrdenTrabajo> getOrdenesTrabajoPorArea(Area _area)
			throws DAOExcepcion {
			// TODO Auto-generated method stub
		
			try{
				this.connManager.connect();
				ResultSet rs = this.connManager.queryDB("SELECT * FROM INCIDENCIA inc, ORDENTRABAJO " +
						"ord where ord.ID = inc.ID AND NOMBRE_AREA = '" + _area.getNombre() + "'");
				this.connManager.close();
				
				try {
					ArrayList<OrdenTrabajo> ordenesTrabajo = new ArrayList<OrdenTrabajo>();
					IOperarioDAO persona = new OperarioDAO();
					IAreaDAO areaDao = new AreaDAO();
					
					while(rs.next()){
						Operario operario = persona.getOperario(rs.getString("DNI"));
						Area area = areaDao.getAreaPorNombre(rs.getString("NOMBRE_AREA"));
						OrdenTrabajo orden = new OrdenTrabajo(rs.getInt("ID"),rs.getString("NOMBRE")
								,rs.getString("DESCRIPCION"),rs.getInt("PRIORIDAD"), rs.getString("ESTADO"),
								operario, area);
						
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

	/*
	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajoPorOperario(Operario _operario)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from INCIDENCIA inc,ORDENDETRABAJO ord where ord.ID=inc.ID and DNI='"+_operario.getDNI()+"'");
			connManager.close();
			try {
				ArrayList<OrdenTrabajo> ordenesTrabajo = new ArrayList<OrdenTrabajo>();
				while(rs.next()){
					
					Area area = new Area(rs.getString("NOMBRE_AREA"));
					Area area = areaDao.getArea(rs.getString("NOMBRE_AREA"));
					OrdenTrabajo orden = new OrdenTrabajo(rs.getString("ID"),rs.getString("NOMBRE")
							,rs.getString("DESCRIPCION"),rs.getInt("PRIORIDAD"), rs.getString("ESTADO"),
							operario,area);
					
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
	public ArrayList<OrdenTrabajo> getOrdenTrabajoPorFecha(Date fecha1, Date fecha2)
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
	*/
	
	@Override
	public void crearOrdenTrabajo(OrdenTrabajo orden) {
		// TODO Auto-generated method stub
		try {
			this.connManager.connect();
			this.connManager.updateDB("insert into ORDENTRABAJO (ID, PRIORIDAD, " +
					"ESTADO, DNI, NOMBRE_AREA) values ("
					+ orden.getID()
					+ ", "
					+ orden.getPrioridad()
					+ ", '"
					+ orden.getEstado()
					+ "', "
					+ null
					+ ", '"
					+ orden.getArea().getNombre()
					+ "')");
			this.connManager.close();

		} catch (DAOExcepcion e) {
			System.out.println("ERROR EN DAO");
		}
		
	}
	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajoPorFecha(Date fecha1,
			Date fecha2) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<OrdenTrabajo> getOrdenTrabajoPorOperario(Operario operario)
			throws DAOExcepcion {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void asignarOrdenTrabajo(OrdenTrabajo orden,String dni){
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			System.out.println(orden.getID()+ " " + orden.getEstado() +
					" " + dni);
			connManager.updateDB("UPDATE ORDENTRABAJO SET DNI = '"
					+ dni + "', ESTADO = '" + orden.getEstado() 
					+ "'WHERE ID = " + orden.getID() + "");
			connManager.close();

		}catch (DAOExcepcion e){
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void modificar(OrdenTrabajo orden) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			connManager.updateDB("UPDATE ORDENTRABAJO SET PRIORIDAD = '"
					+ orden.getPrioridad() + "', ESTADO = '" + orden.getEstado() 
					+ "'where ID = '" + orden.getID() + "'");
			connManager.close();

		}catch (DAOExcepcion e){
			throw e;
		}
	}


}
