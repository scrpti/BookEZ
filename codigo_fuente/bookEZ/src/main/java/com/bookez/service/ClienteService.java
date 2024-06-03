package com.bookez.service;

import com.bookez.model.Cliente;
import com.bookez.repository.ClienteRepository;

import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void registrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Cliente obtenerClientePorNIF(String nif) {
        return clienteRepository.findByNIF(nif);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }
}
