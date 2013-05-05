package logica;

public class Maestro extends Persona{
	private Area area;

	public Maestro(String _dni,String _usuario,String _pass,Area _area) {
		super(_dni, _usuario, _pass);
		area=_area;
		// TODO Auto-generated constructor stub
	}

	public Area getArea() {
		// TODO Auto-generated method stub
		return area;
	}

}
