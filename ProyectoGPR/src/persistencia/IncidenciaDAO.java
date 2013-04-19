package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import logica.Area;
import logica.IIncidencia;
import logica.Incidencia;
import excepciones.DAOExcepcion;

public class IncidenciaDAO {

	private ConnectionManager connManager;
	
	public IncidenciaDAO() throws DAOExcepcion {
		try{
		connManager= new ConnectionManager("practica4");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion("DB_CONNECT_ERROR");
		}
	}

	public Collection<IIncidencia> getIncidencias() throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from INCIDENCIA");
			connManager.close();
			
			
		
			
			try {
				ArrayList<IIncidencia> incidencias = new ArrayList<IIncidencia>();
				while(rs.next()){
					IIncidencia incidencia = new Incidencia(rs.getString("ID"),rs.getString("NOMBRE")
							,rs.getString("DESCRIPCION"),rs.getDate("FECHA_ENTRADA"));
					
					incidencias.add(incidencia);
				}
				return incidencias;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}
	
	@Override
	public ArrayList<Revista> encontrarRevistas() throws DAOExcepcion {
		// TODO Auto-generated method stub
		ArrayList<Revista> revistas = new ArrayList<Revista>();
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select NOMREVISTA from REVISTA");
			connManager.close();
			
			
			try {
				
				while (rs.next()){
					Revista revista = encontrarRevistaPorNombre(rs.getString("NOMREVISTA"));
					revistas.add(revista);
					//System.out.print(revista.getNombre());
					//revista.setArea(areaDAO.encontrarAreasPorRevista(nombre));
				}
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
			return revistas;
	}

	@Override
	public void crearRevista(Revista r) throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
		connManager.connect();
		connManager.updateDB("insert into REVISTA (NOMREVISTA) values ('"+r.getNombre()+"')");
		connManager.close();
		IAreaDAO areaDAO = new AreaDAOImp();
		ArrayList<Area> areas= r.getArea();
		System.out.println(areas.size());
		for(int i=0;i<areas.size();i++){
			System.out.println("i="+i+" Area="+areas.get(i).getNombre());
			areaDAO.crearArea(areas.get(i));
			
		}
		
		}catch (DAOExcepcion e){
			throw e;
		}
	}
}

