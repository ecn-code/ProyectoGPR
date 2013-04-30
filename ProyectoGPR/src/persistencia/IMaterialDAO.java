package persistencia;

import java.util.ArrayList;

import logica.Material;

public interface IMaterialDAO {
public void modificarMaterial(Material material);
public ArrayList<Material> getMateriales();
}
