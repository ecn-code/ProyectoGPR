package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import logica.Area;
import logica.Incidencia;
import logica.OrdenTrabajo;


import excepciones.DAOExcepcion;

public class IncidenciaDAO implements IIncidenciaDAO{

	private ConnectionManager connManager;
	
	public IncidenciaDAO() throws DAOExcepcion {
		try{
		connManager = new ConnectionManager("practicaGPR");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion("DB_CONNECT_ERROR");
		}
	}

	public ArrayList<Incidencia> getIncidencias() throws DAOExcepcion {
		// TODO Auto-generated method stub
		try{
			connManager.connect();
			ResultSet rs = connManager.queryDB("select * from INCIDENCIA " +
					"WHERE NOT ID = (SELECT ID FROM INCIDENCIA inci , ORDENTRABAJO " +
					"orden WHERE inci.ID = orden.ID)");

			connManager.close();

			try {
				ArrayList<Incidencia> incidencias = new ArrayList<Incidencia>();
				while(rs.next()){
					Incidencia incidencia = new Incidencia(rs.getString("ID"),rs.getString("NOMBRE")
							,rs.getString("DESCRIPCION"), rs.getString("FECHADEENTRADA"));
					
					incidencias.add(incidencia);
				}
				return incidencias;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				System.out.println("ERROR");
				throw e;
			}
	}

	public void crearIncidencia(Incidencia incidencia) {
		
		try {
			this.connManager.connect();
			this.connManager.updateDB("insert into INCIDENCIA (ID, NOMBRE, DESCRIPCION, " +
					"FECHADEENTRADA) values (" 
					+ null + ", '" + incidencia.getNombre() + "', '" + 
					incidencia.getDescripcion() + "', '" + 
					incidencia.getFechaEntrada() + "')" );
			this.connManager.close();

		} catch (DAOExcepcion e) {
			e.printStackTrace();
		}
		
	}

	public void clasificarIncidencia(Incidencia incidencia, Area area,
			String prioridad) {
		IOrdenTrabajoDAO ordenDAO;
		try {
			ordenDAO = new OrdenTrabajoDAO();
			ordenDAO.crearOrdenTrabajo(new OrdenTrabajo(incidencia,area,prioridad));
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

