package back.ing.procesos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import back.ing.procesos.app.models.entity.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

}
