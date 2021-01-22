package com.sistemas.basico.controlador;

import javax.validation.Valid;
import org.springframework.ui.Model;

@Controller 
@RequestMapping (value="/tarifa") 
public class TarifaController {
	@Autowired 
	private TarifaService tarifaService; 
	
	@getMapping({"/","/index"}) 
	public String getIndex(Model model) { 
	model.addAtribute("listaTarifas", tarifaService.listarTodos()); 
	
	return "/tarifa/tarifalndex" ; 
	}
	@GetMapping("/nuevo")
	public String getTarifaFormNew(Model model) { 
		model.addAttribute("tarifa", new Tarifa()); 
		
		return "/tarifa/tarifaForm"; 
	}
	
	@PostMapping("/nuevo") 
	public String postTarifaFormNew( 
			@Valid @ModelAttribute("tarifa") Tarifa tarifa, 
			BindingResult bindingResult, 
			Model model) { 
	
		if (bindingResuIt.hasErrors()) { 
			//si hubo erroes se muestra el formulario para correccion 
			return "/tarifa/tarifaForm" ; 
		}
		tarifaservice.agregar(tarifa); 
		
		return "redirect:/tarifa/index";
	}
	
	@GetMapping("/editar/{id}")
	public String getTarifaFormEdit( 
			@PathVariable("id") Long id, 
			Model model) { 
		Tarifa buscado = tarifaservice.buscar(id);
		
		if (buscado != null) { 
			model.addAttribute("tarifa", buscado); 
		}
		else { 
			model.addAttribute("tarifa", new Tarifa());
		}
	 
		return "/tarifa/tarifaForm"; 
	}

		@PostMapping("/editar") 
		public String postTarifaFormEdit( 
				@Valid @ModelAttribute("tarifa") Tarifa tarifa, 
				BindingResult bindingResult, 
				Model model) { 

			if (bindingResuIt.hasErrors()) { 
				//Si hubo errores se muestra el formulario para correccion 
				return "/tarifa/tarifaForm"; 
			}
			tarifaservice.agregar(tarifa ) ; 
			return "redirect:/tarifa/index"; 
		}
	@GetMapping("/eliminar/{id}")
	public String getTarifaEliminar( 
			@PathVariable("id") Long id, 
			Model model) { 

	tarifaService.eliminar( id ); 
	
	return "redirect:/tarifa/index"; 
	}
}
