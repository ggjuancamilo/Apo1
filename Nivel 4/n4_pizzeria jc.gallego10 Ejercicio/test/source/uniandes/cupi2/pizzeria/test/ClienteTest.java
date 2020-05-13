/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_pizzeria
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.pizzeria.test;

import uniandes.cupi2.pizzeria.mundo.Cliente;
import junit.framework.TestCase;

/**
 * Clase usada para verificar que los métodos de la clase Cliente estén correctamente implementados.
 */
public class ClienteTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    
    /**
     * Cliente de prueba.
     */
    private Cliente cliente;
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Escenario 1: Construye un nuevo cliente.
     */
    private void setupEscenario1()
    {
        cliente = new Cliente( "German", 1020, 3393949, "Calle 19 # 1 - 2" );
    }
    
    /**
     * Prueba 1: Verifica el método constructor.
     */
    public void testCrearCliente()
    {
        setupEscenario1( );
        
        assertEquals( "El nombre no coincide.", "German", cliente.darNombre( ) );
        assertEquals( "La cédula no coincide.", 1020, cliente.darCedula( ) );
        assertEquals( "El teléfono no coincide.", 3393949, cliente.darTelefono( ) );
        assertEquals( "La dirección no coincide.", "Calle 19 # 1 - 2", cliente.darDireccion( ) );
        
    }
}
