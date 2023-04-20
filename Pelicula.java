package CRUD_LISTAS;

/**
 * Clase que representa una película.
 */
public class Pelicula {
	
	private String titulo;
	private String genero;
	private int ano;
	
	
    /**
     * Constructor que crea una nueva instancia de Pelicula con los valores especificados.
     * 
     * @param titulo el título de la película
     * @param genero el género de la película
     * @param ano el año de estreno de la película
     */
	public Pelicula(String titulo, String genero, int ano) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.ano = ano;
	}

    /**
     * Retorna el título de la película.
     * 
     * @return el título de la película
     */
	public String getTitulo() {
		return titulo;
	}

    /**
     * Establece el título de la película.
     * 
     * @param titulo el nuevo título de la película
     */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

    /**
     * Retorna el género de la película.
     * 
     * @return el género de la película
     */
	public String getGenero() {
		return genero;
	}

    /**
     * Establece el género de la película.
     * 
     * @param genero el nuevo género de la película
     */
	public void setGenero(String genero) {
		this.genero = genero;
	}

    /**
     * Retorna el año de estreno de la película.
     * 
     * @return el año de estreno de la película
     */
	public int getAno() {
		return ano;
	}

    /**
     * Establece el año de estreno de la película.
     * 
     * @param ano el nuevo año de estreno de la película
     */
	public void setAno(int ano) {
		this.ano = ano;
	}

    /**
     * Retorna una representación en cadena de la película.
     * 
     * @return una cadena que contiene el título, el género y el año de la película
     */
	@Override
	public String toString() {
		return "pelicula [titulo=" + titulo + ", genero=" + genero + ", ano=" + ano + "]";
	}

}
