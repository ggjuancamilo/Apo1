/**
 * 
 */
package uniandes.cupi2.observatorio.mundo;

/**
 * @author Cesar
 *
 */
public class SateliteArtificial 
{
    // ---------------------------------------------------------------------
    // Constantes
    // ---------------------------------------------------------------------

	/**
	 * 
	 */
	public static final String TIPO_MILITAR = "MILITAR";
	

	/**
	 * 
	 */
	public static final String TIPO_COMUNICACION = "COMUNICACION";
	

	/**
	 * 
	 */
	public static final String TIPO_INVESTIGACION = "INVESTIGACION";
	
    
	// -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

  
	
    /**
     * Construye un satélite artificial con los datos suministrados por parámetro.
     * @param pNombre
     * @param pPais
     * @param pTipo
     */
    public SateliteArtificial( String pNombre, String pPais, String pTipo )
    {
        nombre = pNombre;   
        pais = pPais;
        tipoDeServicio = pTipo;
    }	
	
	
	// ---------------------------------------------------------------------
    // Atributos
    // ---------------------------------------------------------------------
	
	
	/**
     * Nombre del satélite natural.
     */
    private String nombre;
	
	/**
     * 
     */
    private String tipoDeServicio;
    
    /**
     * 
     */
    private String pais;
    
    
    
    
    // ---------------------------------------------------------------------
    // Métodos
    // ---------------------------------------------------------------------
    
	/**
	 * @return the nombre
	 */
	public String darNombre() {
		return nombre;
	}

	
	/**
	 * @return the tipo
	 */
	public String darTipoDeServicio() {
		return tipoDeServicio;
	}

	/**
	 * @return the pais
	 */
	public String darPais() {
		return pais;
	}

	


}
