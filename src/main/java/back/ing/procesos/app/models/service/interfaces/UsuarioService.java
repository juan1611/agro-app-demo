package back.ing.procesos.app.models.service.interfaces;

import java.util.List;

import back.ing.procesos.app.models.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();

	public void save(Usuario usuario);

	public void delete(Long id);

	public Usuario findOne(Long id);

}
