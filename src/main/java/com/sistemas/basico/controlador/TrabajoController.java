package com.sistemas.basico.controlador;

import java.util.ArrayList;
public class TrabajoController {
	@Autowired private TrabajoService trabajoService; 
	@Autowired private ClienteService clienteService; 
	@Autowired private TarifaService tarifaService; 
	@Autowired private EtapaService etapaService; 

	@GetMapping({ "/","index"}) 
	public String getlndex(model model) { 
		model.addAttribute("listaTrabajos", trabajoService.listarTodos()); 
		
		return "/trabajo/trabajolndex";
		}
		@GetMapping("/nuevo")
	public String getTrabajoFormNew(model model) { 
		Trabajo nuevo = new Trabajo(); 
		
		nuevo.setFechaTrabajo(new Date()); 
		nuevo.setFechaEntrega(new Date()); 
		
	model. addAttribute("trabajo", nuevo); 
	model. addAttribute("listaClientes", clienteService.listarTodos()); 
	model. addAttribute("listaTarifas", tarifaService.listarTodos()); 
	//model.addAttribute ("listaEmpleados", empleadoService.listarTodos()); 

	return "/trabajo/trabajoForm"; 
	}
		@PostMapping("/nuevo") 
		public String postTrabajoFormNew( 
			@Valid @ModelAttribute("trabajo") Trabajo trabajo, 
			BindingResult bindingResult, 
			Model model) { 
		List<Tarea> tareas = new ArrayList<Tarea>(); 

		if (bindingResult.hasErrors()) { 
			//si hubo errores se muestra el formulario para correccion
			model.addAttribute("listaClientes", clienteService.listarTodos ( ) ) ;
			model.addAttribute("listaTarifas",  tarifaService.listarTodos()); 

		return "/trabajo/trabajoForm"; 
		}
		//agregar tareas:
		for(Etapa etapa : etapaService.listarTodos()) { 
			Tarea tarea = new Tarea(); 
			
			tarea.setTrabajo(trabajo) ; 
			tarea.setEtapa (etapa) ; 
			tareas.add(tarea); 
			}
			
		trabajo.setTarea(tareas); 
		trabajoService.agregar(trabajo) ; 

		return "redirect: /trabajo/index"; 

		@GetMapping("/editar/{id}") 
		public String getTrabajoFormEdit( 
			@PathVariable("id") Long id, 
			Model model) { 
		Trabajo buscado = trabajoService.buscar(id); 

		if (buscado != null) { 
			model.addAttribute("trabajo", buscado); 
			}
		else { 
			model.addAttribute("trabajo", new Trabajo()); 
		}
		model.addAttribute("listaClientes", clienteService.listarTodos()); 
		model.addAttribute("listaTarifas", tarifaService.listarTodos()); 

		return "/trabajo/trabajoForm"; 
		}

	@PostMapping("/editar") 
	public String post TrabajoFormEdit( 
		@Valid @ModelAttribute("trabajo") Trabajo trabajo, 
		BindingResult bindingResult, 
		Model model) { 
		
		if (bindingResult.hasErrors()) { 
		//
		model.addAttribute ("listaClientes", clienteService.listarTodos ( ) ) ; 
		model.addAttribute ("listaTarifas", tarifaService.listarTodos()); 
		
		return "/trabajo/trabajoForm"; 
		}
	trabajoService.agregar(trabajo) ; 
	
	return "redirect:/trabajo/index";
	}
	@GetMapping("/eliminar/{id}) 
	public String getTrabajoEliminar( 
	@PathVariable("id") Long id, 
	Model model) { 
	
	trabajoService.eliminar(id); 
	
	return "redirect:/trabajo/index";
	}
}