package com.bookez.test.integration;

import com.bookez.model.Cliente;
import com.bookez.repository.ClienteRepository;
import com.bookez.service.ClienteService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteIntegrationTest {
    private ClienteService clienteService;
    private ClienteRepository clienteRepository;
    private Cliente cliente;

    @Before
    public void setup() {
        clienteRepository = mock(ClienteRepository.class);
        clienteService = new ClienteService(clienteRepository);
        cliente = new Cliente("12345678", "Juan Pérez", "Calle 123", "1234567890", "juan.perez@example.com");
    }

    @Test
    public void obtenerClientePorNIF() {
        when(clienteRepository.findByNIF(cliente.getNif())).thenReturn(cliente);

        Cliente clienteObtenido = clienteService.obtenerClientePorNIF(cliente.getNif());

        verify(clienteRepository, times(1)).findByNIF(cliente.getNif());
        assertEquals(cliente, clienteObtenido);
    }

    @Test
    public void obtenerTodosLosClientes() {
        when(clienteRepository.findAll()).thenReturn(java.util.Arrays.asList(cliente));

        assertEquals(1, clienteService.obtenerTodosLosClientes().size());
        verify(clienteRepository, times(1)).findAll();
    }
}
