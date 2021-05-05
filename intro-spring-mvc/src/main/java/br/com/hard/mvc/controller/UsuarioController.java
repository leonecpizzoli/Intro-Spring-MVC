package br.com.hard.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.hard.mvc.dao.UsuarioDao;
import br.com.hard.mvc.domain.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioDao userDAO;
	
	@RequestMapping(value="/todos", method = RequestMethod.GET)
	public ModelAndView listaTodosUsuarios(ModelMap model){
		model.addAttribute("usuarios", userDAO.getTodos());
		return new ModelAndView("/user/list", model);
	}
	
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model){
		return "/user/add";		
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttr){
		userDAO.salvar(usuario);
		redirectAttr.addFlashAttribute("message", "usuario salvo com sucesso");
		return "redirect:/usuario/todos";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model){
		Usuario usuario = userDAO.getId(id);
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/user/add", model);
	}
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttr){
		userDAO.editar(usuario);
		redirectAttr.addFlashAttribute("message", "Usuário alterado com sucesso!");
		return new ModelAndView("redirect:/usuario/todos");
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttr){
		userDAO.excluir(id);
		redirectAttr.addFlashAttribute("message", "Usuário excluído com sucesso");
		return "redirect:/usuario/todos";
	}
}


