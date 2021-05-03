package br.com.hard.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.hard.mvc.dao.UsuarioDao;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDao userDAO;

	@RequestMapping(value="/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model){
		model.addAttribute("usuarios", userDAO.getTodos());
		return new ModelAndView("/user/list", model);
	}
}
