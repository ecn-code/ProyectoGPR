package persistencia;

import logica.Area;
import logica.Maestro;

public interface IMaestroDAO {
public Maestro [] getMaestros();
public Maestro [] getMaestros(Area area);
}
