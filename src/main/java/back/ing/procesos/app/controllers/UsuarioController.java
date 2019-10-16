package back.ing.procesos.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import back.ing.procesos.app.models.entity.Usuario;
import back.ing.procesos.app.models.service.interfaces.UsuarioService;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

	final static String URL_BASE = "/usuario";

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = URL_BASE + "/usuarioListar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "usuarioListar";
	}

	@RequestMapping(value = URL_BASE + "/usuarioEliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			usuarioService.delete(id);
		}
		return "redirect:" + URL_BASE + "/usuarioListar";
	}

	@RequestMapping(value = URL_BASE + "/usuarioForm")
	public String crear(Map<String, Object> model) {

		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "Formulario de Creación de Usuarios");
		return "usuarioForm";
	}

	@RequestMapping(value = URL_BASE + "/usuarioForm/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Usuario usuario = null;

		if (id > 0) {
			usuario = usuarioService.findOne(id);
		} else {
			return "redirect:" + URL_BASE + "/usuarioListar";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Editar Usuario");
		return "usuarioForm";
	}

	@RequestMapping(value = URL_BASE + "/usuarioForm", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Usuarios");
			return "form";
		}
		usuarioService.save(usuario);
		status.setComplete();
		return "redirect:" + URL_BASE + "/usuarioListar";
	}

}
