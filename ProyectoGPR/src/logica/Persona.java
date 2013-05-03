package logica;

public abstract class Persona {
protected String dni,nombre,pass;
public Persona(String _dni,String _usuario,String _pass){
	dni=_dni;
	nombre=_usuario;
	pass=_pass;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String _usuario) {
	nombre = _usuario;
}
public String getPass() {
	return pass;
}
public void setPass(String _pass) {
	pass = _pass;
}
public String getDNI() {
	return dni;
}

}
