package com.bookez.repository;

import com.bookez.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
	private List<Cliente> clientes = new ArrayList<>();

	public void save(Cliente cliente) {
		Cliente existingCliente = findByNIF(cliente.getNif());

		if (existingCliente != null) {
			existingCliente.setNombre(cliente.getNombre());
			existingCliente.setDireccion(cliente.getDireccion());
			existingCliente.setTelefono(cliente.getTelefono());
			existingCliente.setEmail(cliente.getEmail());
		} else {
			clientes.add(cliente);
		}
	}

	public Cliente findByNIF(String nif) {
		return clientes.stream().filter(cliente -> cliente.getNif().equals(nif)).findFirst().orElse(null);
	}

	public List<Cliente> findAll() {
		return new ArrayList<>(clientes);
	}
}
