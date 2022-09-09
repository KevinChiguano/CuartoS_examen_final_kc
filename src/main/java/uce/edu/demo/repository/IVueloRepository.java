package uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import uce.edu.demo.modelo.Vuelo;

public interface IVueloRepository {
	
	public List<Vuelo> buscarVuelos(String origin, String destino, LocalDateTime fecha);

	public Vuelo buscarPorNumero(String numero);
	
	public void actualizar(Vuelo vuelo);
	
}
