package logica;

public class UsuarioRegistrado {
private String iD,usuario,pass;
public UsuarioRegistrado(String _iD,String _usuario,String _pass){
	iD=_iD;
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
public String getID() {
	return iD;
}

}
