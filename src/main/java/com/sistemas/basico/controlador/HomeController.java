package com.sistemas.basico.controlador; 

import org.springframework.stereotype.Controller;
@Controller 
public class HomeController { 

		@GetMapping({"/","/index"})
		public String index(Model model) {
			
			return "index";
		}
}