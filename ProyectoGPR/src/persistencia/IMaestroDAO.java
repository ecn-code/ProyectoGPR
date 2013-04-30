package persistencia;

import java.util.ArrayList;

import logica.Area;
import logica.Maestro;

public interface IMaestroDAO {
public ArrayList<Maestro> getMaestros();
public ArrayList<Maestro> getMaestros(Area area);
}
