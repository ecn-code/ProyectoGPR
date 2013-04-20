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
		connManager= new ConnectionManager("practicaGPR");
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

}

