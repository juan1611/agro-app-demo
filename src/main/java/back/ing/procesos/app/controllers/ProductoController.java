package back.ing.procesos.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import back.ing.procesos.app.models.entity.Producto;
import back.ing.procesos.app.models.service.interfaces.ProductoService;

@Controller
@SessionAttributes("producto")
public class ProductoController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	final static String URL_BASE = "/producto";

	@Autowired
	ProductoService productoService;

	@RequestMapping(value = { URL_BASE + "/productoListar", "/" }, method = RequestMethod.GET)
	public String listar(Model model, Authentication authentication) {
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("productos", productoService.findAll());
		return "productoListar";
	}

	@RequestMapping(value = URL_BASE + "/productoEliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			productoService.delete(id);
		}
		return "redirect:" + URL_BASE + "/productoListar";
	}

	@RequestMapping(value = URL_BASE + "/productoForm")
	public String crear(Map<String, Object> model) {

		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Formulario de Creación de Productos");
		return "productoForm";
	}

	@RequestMapping(value = URL_BASE + "/productoForm/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Producto producto = null;

		if (id > 0) {
			producto = productoService.findOne(id);
		} else {
			return "redirect:" + URL_BASE + "/productoListar";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		return "productoForm";
	}

	@RequestMapping(value = URL_BASE + "/productoForm", method = RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		productoService.save(producto);
		status.setComplete();
		return "redirect:" + URL_BASE + "/productoListar";
	}

}
