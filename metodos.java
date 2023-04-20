package CRUD_LISTAS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Miguel_P
 * @version 3
 */

public class metodos {

	/**
	 * Método que devuelve un ArrayList con las opciones disponibles en el programa.
	 * 
	 * @return un ArrayList de Strings que contiene las opciones disponibles en el
	 *         programa.
	 */
	public static ArrayList<String> devolverOpciones() {

		ArrayList<String> listadoOpciones = new ArrayList<String>();

		listadoOpciones.add("Añadir");
		listadoOpciones.add("Mostrar listado");
		listadoOpciones.add("Modificar");
		listadoOpciones.add("Buscar");
		listadoOpciones.add("Borrar 1 registro");
		listadoOpciones.add("Resetear registros");
		listadoOpciones.add("Salir");

		return listadoOpciones;
	}

	/**
	 * Método que permite seleccionar una opción del listado de opciones
	 * proporcionado.
	 * 
	 * @param listadoOpciones un ArrayList de Strings que contiene las opciones
	 *                        disponibles para seleccionar.
	 * @return un Integer que representa la opción seleccionada por el usuario.
	 * @throws IOException si se produce un error de entrada/salida durante la
	 *                     selección de la opción.
	 */
	public static Integer seleccionarOpcion(ArrayList<String> listadoOpciones) throws IOException {

		int opcionSeleccionada = 0;
		boolean opcionValida = false;

		while (!opcionValida) {

			try {

				System.out.println("[INFO] Opciones disponibles: ");

				for (int i = 0; i < listadoOpciones.size(); i++) {

					System.out.println("[" + (i + 1) + "] " + listadoOpciones.get(i));
				}

				Scanner inputOpcion = new Scanner(System.in);
				System.out.print("[INPUT] Selecciona alguna de las opciones disponibles (1,2,3...): ");
				opcionSeleccionada = inputOpcion.nextInt();

			} catch (Exception e) {
			}

			if (opcionSeleccionada >= 1 & opcionSeleccionada <= 7) {

				opcionValida = true;

			} else {

				System.out.println("[ERROR] No has seleccionado una opcion valida");
				metodos.pulsaEnter();

			}
		}

		return opcionSeleccionada;
	}

	/**
	 * Método que pausa la ejecución del programa hasta que el usuario presiona la
	 * tecla "Enter".
	 * 
	 * @throws IOException si se produce un error de entrada/salida al intentar leer
	 *                     la entrada del usuario.
	 */
	public static void pulsaEnter() throws IOException {

		System.out.print("[INFO] Pulsa 'Enter' para continuar...");
		System.in.read();
		System.out.println("");

	}

	/**
	 * Método que solicita al usuario el título de una película y lo devuelve como
	 * un String.
	 * 
	 * @return un String que representa el título de la película introducido por el
	 *         usuario.
	 */
	public static String solicitarTituloPelicula() {

		String titulo;

		Scanner inputTitulo = new Scanner(System.in);
		System.out.print("[INPUT] Introduce el titulo de la pelicula: ");
		titulo = inputTitulo.next();

		return titulo;
	}

	/**
	 * Método que solicita al usuario el género de una película y lo devuelve como
	 * un String.
	 * 
	 * @return un String que representa el género de la película introducido por el
	 *         usuario.
	 */
	public static String solicitarGeneroPelicula() {

		String genero;

		Scanner inputGenero = new Scanner(System.in);
		System.out.print("[INPUT] Introduce el genero de la pelicula: ");
		genero = inputGenero.next();

		return genero;
	}

	/**
	 * Método que solicita al usuario el año de una película y lo devuelve como un
	 * Integer.
	 * 
	 * @return un Integer que representa el año de la película introducido por el
	 *         usuario.
	 */
	public static Integer solicitarAnoPelicula() {

		int ano;

		Scanner inputAno = new Scanner(System.in);
		System.out.print("[INPUT] Introduce el ano de la pelicula: ");
		ano = inputAno.nextInt();

		return ano;
	}

	/**
	 * 
	 * Método que crea una nueva instancia de la clase Pelicula con los valores de
	 * título, género y año especificados y la devuelve.
	 * 
	 * @param titulo un String que representa el título de la película.
	 * @param genero un String que representa el género de la película.
	 * @param ano    un Integer que representa el año de la película.
	 * @return una instancia de la clase Pelicula con los valores especificados de
	 *         título, género y año.
	 */
	public static Pelicula crearPelicula(String titulo, String genero, int ano) {

		Pelicula pelicula = new Pelicula(titulo, genero, ano);

		return pelicula;
	}

	/**
	 * Método que muestra por consola el contenido de un ArrayList genérico.
	 * 
	 * @param listado un ArrayList genérico que contiene los elementos que se van a
	 *                mostrar por consola.
	 */
	public static Boolean mostrarListado(ArrayList<?> listado) {

		int contador = 1;
		Boolean listadoMostrado = false;

		if (listado.size() > 0) {

			System.out.println("[INFO] Mostrando listado...");

			for (Object elemento : listado) {

				System.out.println("[" + contador + "] " + elemento);
				contador++;
			}

			listadoMostrado = true;

			System.out.println("");

		} else {
			System.out.println("[ERROR] El listado esta vacio");

		}
		return listadoMostrado;
	}

	/**
	 * 
	 * Metodo que modifica alguno de los atributos de una Pelicula.
	 * 
	 * @param pelicula La Pelicula que se desea modificar.
	 * @return true si se ha modificado algun atributo, false en caso contrario.
	 */
	public static Boolean modificarPelicula(Pelicula pelicula) {

		int opcion;
		Boolean peliculaModificada = false;
		System.out.println(pelicula);

		Scanner inputOpcion = new Scanner(System.in);
		System.out.print("[INPUT] Introduce el tipo de dato a modificar (1=Titulo, 2=Genero, 3=Ano): ");
		opcion = inputOpcion.nextInt();

		switch (opcion) {

		case 1: {
			pelicula.setTitulo(solicitarTituloPelicula());
			peliculaModificada = true;
			break;
		}
		case 2: {
			pelicula.setGenero(solicitarGeneroPelicula());
			peliculaModificada = true;
			break;
		}
		case 3: {
			pelicula.setAno(solicitarAnoPelicula());
			peliculaModificada = true;
			break;
		}

		}

		return peliculaModificada;
	}

	/**
	 * Solicita al usuario la posición del elemento que desea seleccionar.
	 * 
	 * @return La posición del elemento seleccionado por el usuario.
	 */
	public static Integer escogerPosicionLista(ArrayList<?> listado) {

		Integer posicionElemento = -1;

		mostrarListado(listado);

		if (listado.size() > 0) {

			do {

				Scanner inputPosicion = new Scanner(System.in);
				System.out.print("[INPUT] Introduce la posicicion del elemento que deseas: ");
				posicionElemento = inputPosicion.nextInt() - 1;

			} while (posicionElemento > 0 && posicionElemento < listado.size());
			
		}

		return posicionElemento;
	}

	/**
	 * Busca una película en el listado según los criterios de búsqueda
	 * seleccionados por el usuario.
	 * 
	 * @param listado el listado de películas a buscar
	 * @return true si se encontró la película, false en caso contrario
	 */
	public static Boolean buscarPelicula(ArrayList<Pelicula> listado) {

		Boolean peliculaEncontrada = false;

		int opcion;
		String terminoBusqueda;
		int contador = 0;
		String valorBusqueda = "";
		int logitudListado = listado.size();
		Boolean buscarElemento = true;

		if (listado.size() > 0) {

			Scanner inputOpcion = new Scanner(System.in);
			System.out.print("[INPUT] Introduce el tipo de dato a buscar (1=Titulo, 2=Genero, 3=Ano): ");
			opcion = inputOpcion.nextInt();

			Scanner inputTerminos = new Scanner(System.in);
			System.out.print("[INPUT] Introduce los terminos de busqueda: ");
			terminoBusqueda = inputTerminos.next();

			do {

				if (contador <= listado.size()) {

					switch (opcion) {

					case 1:
						if (listado.get(contador).getTitulo().contains(terminoBusqueda)) {

							System.out.println(listado.get(contador).toString());
							buscarElemento = false;
							peliculaEncontrada = true;
						}
						;
						break;

					case 2:
						if (listado.get(contador).getGenero().contains(terminoBusqueda)) {

							System.out.println(listado.get(contador).toString());
							buscarElemento = false;
							peliculaEncontrada = true;
						}
						;
						break;

					case 3:
						if (String.valueOf(listado.get(contador).getAno()).contains(terminoBusqueda)) {

							System.out.println(listado.get(contador).toString());
							buscarElemento = false;
							peliculaEncontrada = true;
						}
						;
						break;
					}

					contador++;

				} else {

					System.out.println("[INFO] No se ha encontrado ninguno resultado");
					buscarElemento = false;

				}

			} while (buscarElemento);

		} else {
			System.out.println("[ERROR] El listado esta vacio");
		}

		return peliculaEncontrada;
	}

	/**
	 * Borra un elemento de la lista seleccionando su posición.
	 * 
	 * @param listado Lista de elementos a borrar.
	 * @throws IndexOutOfBoundsException si se introduce una posición fuera de
	 *                                   rango.
	 */
	public static void borrarElemento(ArrayList<?> listado) {

		int elementoBorrar;
		Boolean borrarElemento = true;

		if (!listado.isEmpty()) {

			do {

				elementoBorrar = escogerPosicionLista(listado);

				if (elementoBorrar >= 0 && elementoBorrar < listado.size()) {

					listado.remove(elementoBorrar);
					System.out.println("[INFO] Elemento borrado de la lista");
					borrarElemento = false;

				}

				else {
					System.out.println("[ERROR] No has seleccionado una posicion valida");
				}

			} while (borrarElemento);
		}

		else {
			System.out.println("[ERROR] El listado esta vacio, no puedes eliminar ningun elemento");
		}
		;
	}

	/**
	 * Borra todos los elementos de un ArrayList
	 * 
	 * @param listado ArrayList a borrar
	 */
	public static void borrarTodo(ArrayList<?> listado) {

		if (listado.size() > 0) {

			listado.clear();
			System.out.println("[INFO] Se han borrado todos los elementos de la lista");

		} else {
			System.out.println("[ERROR] El listado esta vacio, no puedes eliminar ningun elemento");
		}
	}
}
