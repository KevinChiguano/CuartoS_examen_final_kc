package uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import uce.edu.demo.modelo.Vuelo;
import uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/vuelos")
public class VueloController {
	
	@Autowired
	private IVueloService vueloService;
	
	@GetMapping("/buscarVuelos")
	public String vistaBuscarVuelos(Vuelo vuelo) {
		return "vistaBuscarVuelos";
	}
	
	@GetMapping("/mostrarVuelos/{origen}/{destino}/{fecha}")
	public String vistaMostrarVuelos(@PathVariable("origen") String origen, @PathVariable("destino") String destino,@PathVariable("fecha") String fecha,Model modelo) {
		this.vueloService.buscarVuelos(origen, destino, null);
		return "vistaMostrarVuelos";
	}

}
