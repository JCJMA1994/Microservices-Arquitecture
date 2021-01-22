package com.sistemas.basico.controlador;
import java.util.ArrayList;

import org.springframework.ui.Model;
public class TareaController {
	@Autowired private TareaService tareaService; 
	@Autowired private EmpleadoService empleadoService; 
	
	@GetMapping({"{trabajoid}","{trabajoid}/index" } ) 
	public String getIndex( 
			@PathVariab1e("trabajoid") Long trabajoid, 
			Model model) { 
		List<Tarea> listaTareas = new ArrayList<Tarea>(); 
		
		for(Tarea tarea :tareaService. listarTodos()) { 
			if (tarea.getTrabajo().getID()== trabajoid { 
				listaTareas.add(tarea);
			}	
		}
		
	model. addAttribute( " listaTareas", listaTareas);
	
	return "/tarea/tareaIndex" ;
	}
	
	@GetMapping("/editar/{id}") 
	public String getTareaFormEdit(
			@PathVariable("id")	Long id, 
			Model model) { 
	Tarea buscado = tareaService.buscar(id);
	
	if (buscado != null) { 
		model.addAttribute("tarea", buscado);
	}
	else { 
		model. addAttribute("tarea", new Tarea()); 
	}
	
	return "/tarea/tareaForm";
	}
	
	@PostMapping("/editar")
	public String postTareaFormEdit( 
			@Valid @ModelAttribute("tarea" Tarea tarea, 
			BindingResult bindingResult, 
			Model model) {
				
		if (bindingResult.hasErrors()) { 
			//si hubo errores se muestra el formulario para correccion 
	model.addAttribute("listaEmpleados",empleadoService.listarTodos()); 
	
	return "/tarea/tareaForm"; 
	
	tareaService.agregar(tarea) ; 
	return "redirect:/tarea/"+tarea.getTrabajo().getId()+"/index";
		}
		
	@GetMapping("/iniciar/{id}") 
	public String getTareaIniciar( 
			@PathVariable("id") Long id, 
			Model model) { 
		Tarea tarea = tareaService.buscar(id); 
		Long trabajold = 0L;
		
		if (tarea != null) { 
			tarea.setFechaInicio(new Date()); 
			trabajold = tarea.getTrabajo().getId(); 
			tareaService.agregar(tarea) ; 
		}
		
	return "redirect:/tarea/"+trabajoId+"/index";
	
	}
	
	@GetMapping("/terminar/{id}") 
	public String getTareaTerminar( 
			@PathVariab1e("id") Long id, 
			Model model) { 
		Tarea tarea = tareaService.buscar(id); 
		Long trabajold 0L; 
		
		if (tarea null) { 
			tarea.setFechaFin(new Date()); 
			trabajold = tarea.getTrabajo().getld(); 
			tareaService.agregar(tarea) ; 
		}
		return "redirect:/tarea/"+trabajoId+"/index";
	}
}
