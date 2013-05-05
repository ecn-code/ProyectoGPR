package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.Area;
import logica.Jefe;
import logica.Jefe;
import excepciones.DAOExcepcion;

public class JefeDAO implements IJefeDAO {
	private ConnectionManager connManager;
	public JefeDAO()throws DAOExcepcion{
		try{
			connManager= new ConnectionManager("practicaGPR");
			}catch (ClassNotFoundException e){
				throw new DAOExcepcion("DB_CONNECT_ERROR");
			}
	}
	@Override
	public ArrayList<Jefe> getJefes()throws DAOExcepcion{
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from JEFE j,PERSONA p where j.DNI=p.DNI");
			connManager.close();
			
			try {
				ArrayList<Jefe> jefes = new ArrayList<Jefe>();
				IAreaDAO areaDao=new AreaDAO();
				while(rs.next()){
					Area area=areaDao.getAreaPorNombre(rs.getString("NOMBRE_AREA"));
					Jefe jefe = new Jefe(rs.getString("DNI"),rs.getString("NOMBRE")
							,rs.getString("PASS"),area);
					jefes.add(jefe);
				}
				return jefes;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}

	@Override
	public ArrayList<Jefe> getJefes(Area area) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jefe loguearJefe(String nombre,String pass)throws DAOExcepcion {
		// TODO Auto-generated method stub
		ArrayList<Jefe> jefes = getJefes();
		
		for(Jefe jefe : jefes) {
			System.out.println();
			System.out.println(jefe.getNombre());
			if(jefe.getNombre().equals(nombre) && jefe.getPass().equals(pass))
				return jefe;
		}
		return null;
	}

}
