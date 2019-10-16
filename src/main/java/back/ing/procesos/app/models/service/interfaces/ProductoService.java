package back.ing.procesos.app.models.service.interfaces;

import java.util.List;

import back.ing.procesos.app.models.entity.Producto;

public interface ProductoService {
	
	public List<Producto> findAll();

	public void save(Producto producto);
	
	public void delete(Long id);
	
	public Producto findOne(Long id);
	
}
