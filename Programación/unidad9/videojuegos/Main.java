package unidad9.videojuegos;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

import unidad9.conexion.mysql.MySQLConnection;

public class Main {

	public static void main(String[] MySQLConnection) {

		Scanner scI = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);

		MySQLConnection db = new MySQLConnection();
		Connection conexion = db.mySQLConnect();
		int opcion = 0;
		do {
			try {
				System.out.println("introduzca una opcion\n" + "1) Mostrar todos los juegos\r\n"
						+ "2) Eliminar clientes\r\n" + "3) Añadir clientes\r\n"
						+ "4) Modificar el teléfono de un cliente\r\n"
						+ "5) Buscar clientes por apellido (que muestre todos los clientes que tengan un apellido concreto que será solicitado por scanner)\r\n"
						+ "6) Salir");
				opcion = scI.nextInt();

				
			} catch (InputMismatchException ex) {
				System.out.println("Solo se admiten numeros");
				scI.next();
			}
		} while (opcion != 6);

	}

}
