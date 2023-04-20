package CRUD_LISTAS;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Miguel_P
 * @version 3
 */

public class CRUD_LISTAS {

	/*
	 * Realizaremos la mismas funcionalidades que en la primera práctica.
	 * 
	 * En este caso modificaremos la práctica para que:
	 * 
	 * Se use POO, es necesario realizar las clases y llamar a las funcionalidades
	 * mediante métodos de los objetos creados.
	 * 
	 * Se utilizarán ArrayList para realizar el almacenamiento de los datos,
	 * concretamente ArrayList de objetos, por ejemplo si el tema fuese cine;
	 * ArrayList<Pelicula> misPelis;
	 * 
	 * No hay limitación de 20 películas.
	 */

	/**
	 * Método principal que ejecuta el programa.
	 * 
	 * @param args los argumentos de la línea de comandos (no se utilizan)
	 * @throws IOException si ocurre un error al leer la entrada del usuario
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();
		Boolean programaActivo = true;

		while (programaActivo) {

			switch (metodos.seleccionarOpcion(metodos.devolverOpciones())) {

			case 1:

				listaPeliculas.add(

						metodos.crearPelicula(

								metodos.solicitarTituloPelicula(), metodos.solicitarGeneroPelicula(),
								metodos.solicitarAnoPelicula()));

				metodos.pulsaEnter();
				break;

			case 2:

				metodos.mostrarListado(listaPeliculas);
				metodos.pulsaEnter();
				break;

			case 3:

				try {
					metodos.modificarPelicula(listaPeliculas.get(metodos.escogerPosicionLista(listaPeliculas)));
					metodos.pulsaEnter();

				}

				catch (IndexOutOfBoundsException e) {

					// ERROR el listado esta vacio
					metodos.pulsaEnter();
				}

				break;

			case 4:

				metodos.buscarPelicula(listaPeliculas);
				metodos.pulsaEnter();
				break;

			case 5:

				metodos.borrarElemento(listaPeliculas);
				metodos.pulsaEnter();
				break;

			case 6:

				metodos.borrarTodo(listaPeliculas);
				metodos.pulsaEnter();
				break;

			case 7:

				programaActivo = false;
				System.out.println("[EXIT] Saliendo del programa...");
				break;

			}
		}
	}
}
