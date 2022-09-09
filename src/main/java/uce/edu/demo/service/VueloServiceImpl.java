package uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.demo.modelo.Vuelo;
import uce.edu.demo.repository.IVueloRepository;

@Service
public class VueloServiceImpl implements IVueloService {
	
	@Autowired
	private IVueloRepository vueloRepository;

	@Override
	public List<Vuelo> buscarVuelos(String origin, String destino, LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.vueloRepository.buscarVuelos(origin, destino, fecha);
	}


}
