package uce.edu.demo.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.demo.modelo.Cliente;
import uce.edu.demo.modelo.CompraPasaje;
import uce.edu.demo.modelo.Vuelo;
import uce.edu.demo.repository.IClienteRepository;
import uce.edu.demo.repository.ICompraPasajeRepository;
import uce.edu.demo.repository.IVueloRepository;

@Service
public class ReservarPasajeImpl implements IReservarPasajeService{
	
	@Autowired
	private IVueloRepository vueloRepository;
	
	@Autowired 
	private IClienteRepository clienteRepository;
	
	@Autowired
	private ICompraPasajeRepository compraPasajeRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void reservarPasaje(String numeroVuelo, Integer cantidad, String cedula) {
		// TODO Auto-generated method stub
		
		Vuelo vuelo = this.vueloRepository.buscarPorNumero(numeroVuelo);
		Cliente cliente = this.clienteRepository.buscarPorCedula(cedula);
		CompraPasaje compraPasaje = new CompraPasaje();
		
		if(vuelo.getEstado().equalsIgnoreCase("D")){
			if(cantidad>=vuelo.getAsientosDisponibles()) {
				vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles()-cantidad);
				this.vueloRepository.actualizar(vuelo);
				compraPasaje.setCantidadAsientosComprados(cantidad);
				compraPasaje.setCliente(cliente);
				compraPasaje.setEstado("RES");
				compraPasaje.setFechaCompra(LocalDateTime.now());
				compraPasaje.setVuelo(vuelo);
				this.compraPasajeRepository.insertar(compraPasaje);
				
			}else {
				throw new RuntimeException();
			}
		}else {
			throw new RuntimeException();
		}
		
	}

}
