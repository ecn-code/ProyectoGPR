package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import excepciones.DAOExcepcion;

import logica.Area;
import logica.Maestro;
import logica.Operario;

public class MaestroDAO implements IMaestroDAO {
	private ConnectionManager connManager;
	public MaestroDAO()throws DAOExcepcion{
		try{
			connManager= new ConnectionManager("practicaGPR");
			}catch (ClassNotFoundException e){
				throw new DAOExcepcion("DB_CONNECT_ERROR");
			}
	}
	@Override
	public ArrayList<Maestro> getMaestros()throws DAOExcepcion{
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from MAESTRO m,PERSONA p where m.DNI=p.DNI");
			connManager.close();
			
			try {
				ArrayList<Maestro> maestros = new ArrayList<Maestro>();
				IAreaDAO areaDao=new AreaDAO();
				while(rs.next()){
					Area area=areaDao.getAreaPorNombre(rs.getString("NOMBRE_AREA"));
					Maestro maestro = new Maestro(rs.getString("DNI"),rs.getString("NOMBRE")
							,rs.getString("PASS"),area);
					maestros.add(maestro);
				}
				return maestros;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}

	@Override
	public ArrayList<Maestro> getMaestros(Area area) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maestro loguearMaestro(String nombre,String pass)throws DAOExcepcion {
		// TODO Auto-generated method stub
		ArrayList<Maestro> maestros = getMaestros();
		
		for(Maestro maestro : maestros) {
			System.out.println();
			System.out.println(maestro.getNombre());
			if(maestro.getNombre().equals(nombre) && maestro.getPass().equals(pass))
				return maestro;
		}
		return null;
	}

}
