package persistencia;

import java.util.ArrayList;

import logica.Incidencia;

import excepciones.DAOExcepcion;

public class prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws DAOExcepcion{
		DAL dal = DAL.dameDAL();
		IncidenciaDAO in = new IncidenciaDAO();
		ArrayList<Incidencia> array = in.getIncidencias();
		for(Incidencia incidencia : array){
			System.out.println(incidencia.getNombre());
		}
	}

}
