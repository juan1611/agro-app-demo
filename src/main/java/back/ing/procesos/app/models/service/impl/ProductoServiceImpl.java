package back.ing.procesos.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import back.ing.procesos.app.models.dao.ProductoDAO;
import back.ing.procesos.app.models.entity.Producto;
import back.ing.procesos.app.models.service.interfaces.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDAO productoDAO;
	
	@Override
	@Transactional
	public void save(Producto producto) {
		productoDAO.save(producto);
	}

	@Override
	public List<Producto> findAll() {
		return (List<Producto>) productoDAO.findAll();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productoDAO.deleteById(id);
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Producto findOne(Long id) {
		return productoDAO.findById(id).orElse(null);
	}
}
