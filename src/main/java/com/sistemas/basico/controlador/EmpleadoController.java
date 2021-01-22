package com.sistemas.basico.controlador;

import javax.validation.Valid;

@Controller 
@Autowired 
public class EmpleadoController {
	 
	private EmpleadoService empleadoService;
	
	@GetMapping({"/","/index"}) 
	public String getIndex(Model model) { 
	model.addAttribute("listaEmp1eados", empleadoService.listarTodos()); 
	
	return "/empleado/empleadoIndex";
	
	@GetMapping("/nuevo" ) 
	public String getEmp1eadoFormNew(Mode1 model) { 
	model. addAttribute( "empleado", new Empleado());
	
	return "/empleado/empleadoForm"; 
	}
	
	@PostMapping("/nuevo" ) 
	public String postEmp1eadoFormNew( 
			@Va1id 30de1Attribute( "empleado") Empleado empleado, 
			BindingResu1t bindingResu1t, 
			Model model) { 
		if (bindingResu1t.hasErrors()) { 
			//Si hubo errores se muestra el formulario para correccion 
			return "/empleadO/empleadoForm";
		}
			
		empleadoService.agregar(empleado); 
		
		return "redirect:/empleado/index";
		
	}
	@GetMapping("/editar/{id}")
	public String getEmpleadoFormEdit( 
			@PathVariable("id")Long id, 
			Model model ) { 
		Empleado buscado = empleadoService.buscar(id); 
		
		if (buscado != null) { 
			model.addAttribute ("empleado" , buscado); 
		}
		else { 
			model.addAttribute("empleado", new Empleado()); 
		}
			return "/empleado/empleadoForm"; 
	}
	
	@PostMapping("/editar")
	public String postEmpleadoFormEdit(
			@Valid @ModelAttribute("empleado") Empleado empleado, 
			BindingResult bindingResult, 
			Model model) { 
		
		if (bindingResult.hasErrors()) { 
			//Si hubo errores se muestra el formulario para correccion 
			return "redirect:/empleado/empleadoForm" ; 
		}
		@GetMapping("/eliminar/{id}")
		public String getEmpIeadoEIiminar( 
		@PathVariab1e("id") Long id, 
		Model model) { 
			
		empleadoService.eliminar(id ) ; 
		return "redirect:/empleado/index"; 
}
}