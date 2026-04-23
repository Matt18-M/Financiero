package com.krakedev.financiero.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestBanco {

    @Test
    public void testCrearCuenta() {
        Banco banco = new Banco();

        Cliente cliente = new Cliente("101", "Mateo", "Molina");

        Cuenta cuenta1 = banco.crearCuenta(cliente);
        Cuenta cuenta2 = banco.crearCuenta(cliente);

        assertEquals("1000", cuenta1.getId());
        assertEquals("1001", cuenta2.getId());
    }

    @Test
    public void testDepositar() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("101", "Mateo", "Molina");

        Cuenta cuenta = banco.crearCuenta(cliente);

        boolean resultado = banco.depositar(100, cuenta);

        assertTrue(resultado);
        assertEquals(100, cuenta.getSaldoActual());
    }

    @Test
    public void testRetirar() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("101", "Mateo", "Molina");

        Cuenta cuenta = banco.crearCuenta(cliente);
        banco.depositar(200, cuenta);

        boolean resultado = banco.retirar(100, cuenta);

        assertTrue(resultado);
        assertEquals(100, cuenta.getSaldoActual());
    }

    @Test
    public void testTransferir() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("101", "Mateo", "Molina");

        Cuenta origen = banco.crearCuenta(cliente);
        Cuenta destino = banco.crearCuenta(cliente);

        banco.depositar(300, origen);

        boolean resultado = banco.transferir(origen, destino, 150);

        assertTrue(resultado);
        assertEquals(150, origen.getSaldoActual());
        assertEquals(150, destino.getSaldoActual());
    }
}