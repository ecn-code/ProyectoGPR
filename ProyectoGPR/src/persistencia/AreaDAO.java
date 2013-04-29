package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.Area;
import logica.Incidencia;


import excepciones.DAOExcepcion;

public class AreaDAO implements IAreaDAO{
	
	private ConnectionManager connManager;
	
	public AreaDAO() throws DAOExcepcion {
		try{
		connManager= new ConnectionManager("practicaGPR");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion("DB_CONNECT_ERROR");
		}
	}

	@Override
	public ArrayList<Area> getArea() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from INCIDENCIA");
			connManager.close();
			
			
		
			
			try {
				ArrayList<Area> areas = new ArrayList<Area>();
				while(rs.next()){
					Area area = new Area(rs.getString("NOMBRE"));
					
					areas.add(area);
				}
				return areas;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}

	@Override
	public Area getArea(String nombre) throws DAOExcepcion {
		connManager.connect();
		ResultSet rs=connManager.queryDB("select * from INCIDENCIA WHERE NOMBRE='"+nombre+"'");
		connManager.close();
		try {
			if(rs.next())
			return new Area(nombre);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
