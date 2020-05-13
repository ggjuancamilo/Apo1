/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Clase usada para verificar que los m�todos de la clase Cliente est�n correctamente implementados.
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
    // M�todos
    // -----------------------------------------------------------------
    
    /**
     * Escenario 1: Construye un nuevo cliente.
     */
    private void setupEscenario1()
    {
        cliente = new Cliente( "German", 1020, 3393949, "Calle 19 # 1 - 2" );
    }
    
    /**
     * Prueba 1: Verifica el m�todo constructor.
     */
    public void testCrearCliente()
    {
        setupEscenario1( );
        
        assertEquals( "El nombre no coincide.", "German", cliente.darNombre( ) );
        assertEquals( "La c�dula no coincide.", 1020, cliente.darCedula( ) );
        assertEquals( "El tel�fono no coincide.", 3393949, cliente.darTelefono( ) );
        assertEquals( "La direcci�n no coincide.", "Calle 19 # 1 - 2", cliente.darDireccion( ) );
        
    }
}
