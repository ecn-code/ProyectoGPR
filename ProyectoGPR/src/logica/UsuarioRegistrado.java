package logica;

public abstract class UsuarioRegistrado {
protected String dni,usuario,pass;
public UsuarioRegistrado(String _dni,String _usuario,String _pass){
	dni=_dni;
	usuario=_usuario;
	pass=_pass;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String _usuario) {
	usuario = _usuario;
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
