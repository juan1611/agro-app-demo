package back.ing.procesos.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import back.ing.procesos.app.models.dao.UsuarioDAO;
import back.ing.procesos.app.models.entity.Usuario;
import back.ing.procesos.app.models.service.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDAO.save(usuario);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		usuarioDAO.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		return usuarioDAO.findById(id).orElse(null);
	}
}
