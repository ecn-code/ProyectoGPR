package logica;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import persistencia.DAL;
import excepciones.DominioExcepcion;
import excepciones.DAOExcepcion;

import excepciones.*;


public class Controlador {
	
	private DAL dal;
	//public boolean logeado;
	public UsuarioRegistrado usu;
	//**********************************************************************
	// Creación del controlador
	// Un único controlador para todos los C.U.
	//**********************************************************************
	private Controlador() throws DominioExcepcion{
		try {
		// Objeto para comunicarse con la capa de acceso a datos
		this.dal = DAL.dameDAL();
		
		}catch (DAOExcepcion e){
			throw new DominioExcepcion(e.getMessage());
		}
	}
	
	public void enviarIncidencia (Incidencia incidencia) throws DominioExcepcion{
		try{ 
			this.dal.enviarIncidencia(incidencia);
		}catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e.getMessage()); 
		} 
	}
	
	public void clasificarIncidencia (Incidencia incidencia, Area area, int prioridad)
	throws DominioExcepcion{
		try{ 
			this.dal.clasificarIncidencia(incidencia, area, prioridad);
		}catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e.getMessage()); 
		} 
	}
	
	public void asignarOrdenTrabajo (OrdenTrabajo orden)throws DominioExcepcion{
		try{ 
			this.dal.asignarOrdenTrabajo(orden);
		}catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e.getMessage()); 
		} 
	}
	
	public ArrayList<Incidencia> getIncidencias() throws DominioExcepcion {
		try{ 
			return this.dal.getIncidencias();
		}catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e.getMessage()); 
		} 
	}
	
	public ArrayList<OrdenTrabajo> getOrdenesTrabajoPorArea(Area area) throws DominioExcepcion {
		try{ 
			return this.dal.getOrdenesTrabajoPorArea(area);
		}catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e.getMessage()); 
		} 
	}
	
	
	public ArrayList<Area> getAreas() throws DominioExcepcion {
		try{ 
			return this.dal.getAreas();
		}catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e.getMessage()); 
		} 
	}
	
	
	
	public static  Controlador dameControlador() throws DominioExcepcion {
		// TODO Auto-generated method stub
		return new Controlador();
	}
/*
	//****************************************************************************
	// Para el C.U. Crear Usuario Registrado
	//****************************************************************************
	public void crearUsuarioRegistrado(UsuarioRegistrado u)throws DominioExcepcion{ 
		try{ 
			
		   if (dal.encontrarUsuarioRegistradoPorNombreUsuario( u.getNombreUsuario()) == null ) {
			   
			   dal.crearUsuarioRegistrado(u);  
		   }
		   else throw new DominioExcepcion("El usuario ya existe."); 
		 }catch (DAOExcepcion e){ 
		   throw new DominioExcepcion(e); 
		 } 
	}


	public UsuarioRegistrado comprobarUsuarioRegistrado(String usuario, String password)throws DominioExcepcion{ 
		try{ 
			UsuarioRegistrado u = null;
		   if ((u = dal.encontrarUsuarioRegistradoPorNombreUsuario( usuario ))!= null ) {
			   
			   if(u.getPassword().equals(password))
				   return u;
			   else 
				   return u;
		 
		   }
		   else return u;
		 }catch (DAOExcepcion e){
		   throw new DominioExcepcion(e);
		 }
	}
	
	public static  Controlador dameControlador() throws DominioExcepcion {
		// TODO Auto-generated method stub
		return new Controlador();
	}
	
	//****************************************************************************
	// Para el C.U. Mostrar Usuarios Registrados
	//****************************************************************************
	public List <UsuarioRegistrado> encontrarUsuariosRegistrados() throws DominioExcepcion{ 
	try { 
	   return dal.encontrarUsuariosRegistrados(); 
	 }catch (DAOExcepcion e){ 
	   throw new DominioExcepcion(e); 
	 } 
	}
	
	//****************************************************************************
	// Para el C.U. Mostrar Areas
	//****************************************************************************
	public List <Area> encontrarAreas() throws DominioExcepcion{ 
	try {
		
	   return dal.encontrarAreas(); 
	 }catch (DAOExcepcion e){ 
	   throw new DominioExcepcion(e); 
	 } 
	}
	//****************************************************************************
	// Para el C.U. Mostrar Articulos
	//****************************************************************************
	public List <Articulo> encontrarArticulos(Area a,String estado) throws DominioExcepcion{ 
	try {
		
	   return dal.encontrarArticulos(a,estado); 
	 }catch (DAOExcepcion e){ 
	   throw new DominioExcepcion(e); 
	 } 
	}
	
	public Articulo encontrarArticuloId(String id) throws DominioExcepcion{ 
		try {
			
		   return dal.encontrarArticuloId(id); 
		 }catch (DAOExcepcion e){ 
		   throw new DominioExcepcion(e); 
		 } 
		}
	//****************************************************************************
	// Para el C.U. Crear Area
	//****************************************************************************
	public void crearArea(Area a,String editor, String revista)throws DominioExcepcion{ 
		try{ 
			
		   if (dal.encontrarAreaPorNombre( a.getNombre() ) == null ) {
			   
			   UsuarioRegistrado u;
			if ((u = dal.encontrarUsuarioRegistradoPorNombreUsuario( editor )) != null ) {
				Revista re;
				   if ( (re = dal.encontrarRevistaPorNombre(revista)) != null ) {
					   
					   if ( u.getEditorArea() == null){ 
						   
						   a.setRevista(re);
						   a.setEditor(u);
					   
			   				dal.crearArea(a);
					   }else throw new DominioExcepcion("El EDITOR ya pertenece a una Area ");
				   }
				   else throw new DominioExcepcion("LA REVISTA NO existe.");
			   }
			   else throw new DominioExcepcion("El USUARIO no existe."); 
		   }
		   else throw new DominioExcepcion("El Area ya existe."); 
		 }catch (DAOExcepcion e){ 
		   throw new DominioExcepcion(e); 
		 } 
	}
	
	//****************************************************************************
	// Para el C.U. Articulos
	//****************************************************************************
	public void creaArticulo(Articulo ar) throws DominioExcepcion{ 
		
		try{ 
				dal.crearArticulo(ar);
				
			 }catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e); 
		} 
		
	}
	
	public void cambiaEstadoArticulo(Articulo ar) throws DominioExcepcion{ 
		
		try{ 
				dal.cEstadoArticulo(ar);
				
			 }catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e); 
		} 
		
	}
	
	public void creaEvaluacion(Evaluacion ev) throws DominioExcepcion{ 
		try{ 
				dal.crearEvaluacion(ev); 
				
			 }catch (DAOExcepcion e){ 
			   throw new DominioExcepcion(e); 
		} 
		
	}
	
	
	
	public void creaArticulosPruebas() throws DominioExcepcion{
	try{
		//Si el usuario jhcanos no está ya registrado lo registramos
		//crearUsuarioRegistrado crea internamente a la persona
		//por tanto no es necesario llamar a crearPersona
		
		if (dal.encontrarUsuarioRegistradoPorNombreUsuario("jhcanos")==null)
			dal.crearUsuarioRegistrado(new UsuarioRegistrado("33333333C","Jose Hilario",
					"Canos Cerda","jhcanos","jh123","jhcanos@dsic.upv.es","WorkFlows, Bibliotecas Digitales",true));
		
		
		UsuarioRegistrado u = dal.encontrarUsuarioRegistradoPorNombreUsuario("jhcanos");
		
		
		if (dal.encontrarUsuarioRegistradoPorNombreUsuario("imarfa")==null)
			dal.crearUsuarioRegistrado(new UsuarioRegistrado("44880646x","Ivan",
					"Martinez Fayos","imarfa","iv123","imarfa@gmail.com","WorkFlows, Bibliotecas Digitales",true));
		
		
		UsuarioRegistrado autor = dal.encontrarUsuarioRegistradoPorNombreUsuario("imarfa");
		
		//Si no existe la Revista con Nombre FUTURAMA se crea
	
		if (dal.encontrarRevistaPorNombre("FUTURAMA")==null)
			dal.crearRevista(new Revista("FUTURAMA"));
		
		Revista r = dal.encontrarRevistaPorNombre("FUTURAMA");
		
		Area a;
		//Si no existe la Revista con Nombre FUTURAMA se crea
		if (dal.encontrarAreaPorNombre("SERIES")==null){
			
			a = new Area("SERIES");
			a.setEditor(u);
			a.setRevista(r);
			
			dal.crearArea(a);
		}
		
		a = dal.encontrarAreaPorNombre("SERIES");
	
		Articulo ar;

		for(int i = 0 ; i < 10; i++) {
			
			String titulo = "Articulo "+i;
			
			 Calendar cal1 = Calendar.getInstance();
			 String fecha_envio = cal1.get(Calendar.YEAR)+"-"+cal1.get(Calendar.MONTH)+"-"+cal1.get(Calendar.DATE)+" "+cal1.get(Calendar.HOUR)
								    +":"+cal1.get(Calendar.MINUTE)+":"+cal1.get(Calendar.SECOND);
			   
			
			ar = new Articulo(titulo, fecha_envio , "", "");
			ar.setPArea(a);
			ar.setResponsable(autor);
			ar.setEstado("PE");
			
			dal.crearArticulo(ar);

		}
		
			 
	}catch (DAOExcepcion e){ 
		   throw new DominioExcepcion(e); 
		 } 
		
	}
*/

}
