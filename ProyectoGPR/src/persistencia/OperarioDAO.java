package persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import logica.Area;
import logica.Operario;
import logica.OrdenTrabajo;
import excepciones.DAOExcepcion;

public class OperarioDAO implements IOperarioDAO {
	private ConnectionManager connManager;

	public OperarioDAO()throws DAOExcepcion{
		try{
			connManager= new ConnectionManager("practicaGPR");
			}catch (ClassNotFoundException e){
				throw new DAOExcepcion("DB_CONNECT_ERROR");
			}
	}
	@Override
	public Operario getOperario(String dni) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from OPERARIO o,PERSONA p where o.DNI=p.DNI and o.DNI='"+dni+"'");
			connManager.close();
			
			try {
				IAreaDAO areaDao=new AreaDAO();
				Operario operario=null;
				if(rs.next()){	
					Area area=areaDao.getArea(rs.getString("NOMBRE_AREA"));
					operario = new Operario(rs.getString("DNI"),rs.getString("NOMBRE")
							,rs.getString("PASS"),area);
					
				}
				return operario;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
		
	}


	@Override
	public ArrayList<Operario> getOperarios() throws DAOExcepcion{
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from OPERARIO o,PERSONA p where o.DNI=p.DNI");
			connManager.close();
			
			try {
				ArrayList<Operario> operarios = new ArrayList<Operario>();
				IAreaDAO areaDao=new AreaDAO();
				while(rs.next()){
					Area area=areaDao.getArea(rs.getString("NOMBRE_AREA"));
					Operario operario = new Operario(rs.getString("DNI"),rs.getString("NOMBRE")
							,rs.getString("PASS"),area);
					operarios.add(operario);
				}
				return operarios;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}

	@Override
	public ArrayList<Operario> getOperarios(Area _area) throws DAOExcepcion{
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from OPERARIO o,PERSONA p where o.DNI=p.DNI and o.NOMBRE_AREA='"+_area.getNombre()+"'");
			connManager.close();
			
			try {
				ArrayList<Operario> operarios = new ArrayList<Operario>();
				IAreaDAO areaDao=new AreaDAO();
				while(rs.next()){
					Area area=areaDao.getArea(rs.getString("NOMBRE_AREA"));
					Operario operario = new Operario(rs.getString("DNI"),rs.getString("NOMBRE")
							,rs.getString("PASS"),area);
					operarios.add(operario);
				}
				return operarios;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}
	@Override
	public int loguear(String nombre, String pass) throws DAOExcepcion {
		// TODO Auto-generated method stub
		return 0;
	}


}
