package com.bookez.test.unit;

import com.bookez.model.Cliente;
import com.bookez.repository.ClienteRepository;
import com.bookez.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteServiceTest {
    private ClienteService clienteService;
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        clienteRepository = new ClienteRepository();
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    public void testRegistrarCliente() {
        Cliente cliente = new Cliente("12345678A", "Juan Pérez", "Calle Falsa 123", "123456789", "juan@example.com");
        clienteService.registrarCliente(cliente);

        Cliente clienteRegistrado = clienteService.obtenerClientePorNIF("12345678A");
        assertNotNull(clienteRegistrado);
        assertEquals("Juan Pérez", clienteRegistrado.getNombre());
    }

    @Test
    public void testObtenerClientePorNIF() {
        Cliente cliente = new Cliente("12345678A", "Juan Pérez", "Calle Falsa 123", "123456789", "juan@example.com");
        clienteService.registrarCliente(cliente);

        Cliente clienteRegistrado = clienteService.obtenerClientePorNIF("12345678A");
        assertEquals("Juan Pérez", clienteRegistrado.getNombre());
    }

    @Test
    public void testObtenerTodosLosClientes() {
        Cliente cliente1 = new Cliente("12345678A", "Juan Pérez", "Calle Falsa 123", "123456789", "juan@example.com");
        Cliente cliente2 = new Cliente("87654321B", "Ana García", "Avenida Siempre Viva 742", "987654321", "ana@example.com");
        clienteService.registrarCliente(cliente1);
        clienteService.registrarCliente(cliente2);

        assertEquals(2, clienteService.obtenerTodosLosClientes().size());
    }
    
    @Test
    public void obtenerClientePorNifVacio() {
        Cliente clienteObtenido = clienteService.obtenerClientePorNIF("");

        assertNull(clienteObtenido);
    }
}
