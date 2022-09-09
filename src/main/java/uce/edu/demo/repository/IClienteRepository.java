package uce.edu.demo.repository;

import uce.edu.demo.modelo.Cliente;

public interface IClienteRepository {
	
	public Cliente buscarPorCedula(String cedula);

}
