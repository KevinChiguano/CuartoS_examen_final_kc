package uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import uce.edu.demo.modelo.Vuelo;

public interface IVueloService {
	
	public List<Vuelo> buscarVuelos(String origin, String destino, LocalDateTime fecha);

}
