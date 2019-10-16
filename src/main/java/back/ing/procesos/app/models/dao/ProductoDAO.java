package back.ing.procesos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import back.ing.procesos.app.models.entity.Producto;

public interface ProductoDAO extends CrudRepository<Producto, Long>{

}
