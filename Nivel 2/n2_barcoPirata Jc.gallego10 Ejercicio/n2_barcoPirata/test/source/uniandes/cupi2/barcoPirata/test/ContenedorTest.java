/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_barcoPirata 
 * Autor: Equipo Cupi2 2014
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.barcoPirata.test;

import junit.framework.TestCase;
import uniandes.cupi2.barcoPirata.mundo.Contenedor;

/**
 * Clase usada para verificar que los m�todos de la clase Contenedor est�n correctamente implementados.
 */
public class ContenedorTest extends TestCase
{

    // ---------------------------------------------------------
    // Atributos
    // ---------------------------------------------------------

    /**
     * Contenedor de prueba.
     */
    private Contenedor contenedor;

    // ---------------------------------------------------------
    // M�todos
    // ---------------------------------------------------------

    /**
     * Escenario de pruebas.
     */
    private void setupEscenario1( )
    {
        contenedor = new Contenedor("Morgan");
    }

    /**
     * Prueba 1 - Verifica el constructor.
     */
    public void testCrearContenedor( )
    {
        setupEscenario1( );
        assertEquals("El nombre del pirata due�o no es correcto.", "Morgan", contenedor.darNombrePirata());
        assertEquals("El n�mero de cajas no es correcto.", 0, contenedor.darNumeroCajas( ) );
        assertEquals("El peso por caja no es correcto.", 0, contenedor.darPesoPorCaja(), 0.01);
        assertEquals("El tipo de carga no es correcto.", Contenedor.SIN_CARGA, contenedor.darTipoCarga());
    }

    /**
     * Prueba 2 - Verifica el m�todo darPesoContenedor.
     */
    public void testDarPesoContenedor( )
    {
    	setupEscenario1();
    	assertEquals("El peso total no est� bien calculado.", 0.0, contenedor.darPesoContenedor(), 0.01 );
    	contenedor.descargar();
    	contenedor.cargar(5, 10.0, Contenedor.CARGA_PELIGROSA);
    	assertEquals("El peso total no est� bien calculado.", 50.0, contenedor.darPesoContenedor(), 0.01 );
    	contenedor.descargar();
    	contenedor.cargar(1200, 3, Contenedor.CARGA_PELIGROSA);
    	assertEquals("El peso total no est� bien calculado.", 3600.0, contenedor.darPesoContenedor(), 0.01 );
    }
    
    /**
     * Prueba 3 - Verifica el m�todo cargar.
     */
    public void testCargar( )
    {
        setupEscenario1( );
        contenedor.cargar(5, 10.0, Contenedor.CARGA_PELIGROSA);
        assertEquals("El nombre del pirata due�o no es correcto.", "Morgan", contenedor.darNombrePirata());
        assertEquals("El n�mero de cajas no es correcto.", 5, contenedor.darNumeroCajas( ) );
        assertEquals("El peso por caja no es correcto.", 10, contenedor.darPesoPorCaja(), 0.01);
        assertEquals("El tipo de carga no es correcto.", Contenedor.CARGA_PELIGROSA, contenedor.darTipoCarga());
    }

    /**
     * Prueba 4 - Verifica el m�todo descargar.
     */
    public void testDescargar( )
    {
        setupEscenario1( );
        contenedor.cargar(5, 10.0, Contenedor.CARGA_PELIGROSA);
        contenedor.descargar();
        assertEquals("El nombre del pirata due�o no es correcto.", "Morgan", contenedor.darNombrePirata());
        assertEquals("El n�mero de cajas no es correcto.", 0, contenedor.darNumeroCajas( ) );
        assertEquals("El peso por caja no es correcto.", 0, contenedor.darPesoPorCaja(), 0.01);
        assertEquals("El tipo de carga no es correcto.", Contenedor.SIN_CARGA, contenedor.darTipoCarga());
    }

    

}
