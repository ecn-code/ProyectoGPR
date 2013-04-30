package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import logica.Material;

public class MaterialDAO implements IMaterialDAO{
	private ConnectionManager connManager;
	public MaterialDAO() throws DAOExcepcion {
		try{
		connManager= new ConnectionManager("practicaGPR");
		}catch (ClassNotFoundException e){
			throw new DAOExcepcion("DB_CONNECT_ERROR");
		}
	}
	@Override
	public ArrayList<Material> getMateriales() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from INCIDENCIA");
			connManager.close();
					
			try {
				ArrayList<Material> materiales = new ArrayList<Material>();
				while(rs.next()){
					Material material = new Material(
							rs.getString("ID"),
							rs.getString("NOMBRE"),
							rs.getString("DESCRIPCION"),
							rs.getInt("DISPONIBLES")		
					);
					
					materiales.add(material);
				}
				return materiales;
				}catch (SQLException e){
					throw new DAOExcepcion("DB_READ_ERROR");
				}
			
			}catch (DAOExcepcion e){
				throw e;
			}
	}

	@Override
	public void modificarDisponiblesMaterial(Material material) throws DAOExcepcion{
		try{
			connManager.connect();
			connManager.updateDB("update MATERIAL set DISPONIBLES='"+material.getDisponibles()+"'where ID='"+material.getID()+"'");
			connManager.close();

		}catch (DAOExcepcion e){
			throw e;
		}
	}

}
