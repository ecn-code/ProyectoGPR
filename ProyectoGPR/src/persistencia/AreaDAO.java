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
		this.connManager= new ConnectionManager("practicaGPR");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion("DB_CONNECT_ERROR");
		}
	}

	@Override
	public ArrayList<Area> getAreas() throws DAOExcepcion {
		try{
			this.connManager.connect();
			ResultSet rs = this.connManager.queryDB("select * from AREA");
			this.connManager.close();
			
			try {
				ArrayList<Area> areas = new ArrayList<Area>();
				while(rs.next()){
					Area area = new Area(rs.getString("NOMBRE_AREA"));
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
		ResultSet rs=connManager.queryDB("select * from AREA WHERE NOMBRE_AREA ='"+nombre+"'");
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
