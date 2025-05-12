package unidad9.conexion.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void mostrarClientes(Connection conexion) {

		String query = "SELECT * FROM clientes";

		try {
			Statement comando = conexion.createStatement();

			ResultSet resultado = comando.executeQuery(query);

			/* Se imprimen los registros que estén guardados en la base de datos */
			while (resultado.next()) {
				System.out.println("id: " + resultado.getInt(1) + "\nNombre: " + resultado.getString(2) + "\nApellido: "
						+ resultado.getString(3) + "\nEmail: " + resultado.getString(4) + "\nTeléfono: "
						+ resultado.getInt(5));

				System.out.println("------------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void consultarClientes2(Connection conexion, String apellido) {
		String query = "SELECT * FROM Clientes WHERE apellido = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, apellido);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("nombre") + "  " + rs.getString("apellido") + " - " + " Telefono: "
						+ +rs.getInt("telefono"));
			}

		} catch (com.mysql.cj.jdbc.exceptions.MysqlDataTruncation e) {

			System.out.println("Error datos incorrectos");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Cliente crearCliente() {
		Scanner scS = new Scanner(System.in);
		System.out.println("introduzca un nombre: ");
		String nombre = scS.nextLine();
		System.out.println("Introduzca su apellido");
		String apellido = scS.nextLine();

		Cliente c = new Cliente(nombre, apellido);

		return c;
	}

	public static void insertarClientes2(Connection conexion, Cliente cliente) {
		String query = "insert into clientes(nombre, apellido, email, telefono) values (?,?,?,?)";

		// el id se incrementa solo, no hace falta añadirlo
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getEmail());
			ps.setInt(4, cliente.getTlf());

			int num_filas = ps.executeUpdate();

			if (num_filas <= 0) {
				System.out.println("No se ha podido insertar");
			} else {
				System.out.println("Cliente insertado con exito");
			}

			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void modificar_tlf(Connection conexion) {
		Scanner sc = new Scanner(System.in);
		Scanner scI = new Scanner(System.in);
		
		System.out.println("Introduce el nombre de la persona para modificar su telefono");
		String nombre_cambiar = sc.nextLine();
		
		System.out.println("Introduce el nuevo tlf");
		int tlf_cambiar = scI.nextInt();
		
		String query = "update clientes set telefono = ? where nombre = ?";

		// el id se incrementa solo, no hace falta añadirlo
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, tlf_cambiar);
	        ps.setString(2, nombre_cambiar);

			int filasAfectadas = ps.executeUpdate();
			
			if(filasAfectadas > 0) {
				System.out.println("Telefono agregado con exito");
			} else {
				System.out.println("No se encontro al cliente");
			}

			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void eliminar(Connection conexion) {
		Scanner sc = new Scanner(System.in);
		String query = "delete FROM Clientes WHERE nombre = ? ";

		System.out.println("Introduzca el nombre a eliminar");
		String nombre = sc.nextLine().trim();

		// el id se incrementa solo, no hace falta añadirlo
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombre);

			int num_filas = ps.executeUpdate();

			if (num_filas <= 0) {
				System.out.println("No se ha podido eliminar");
			} else {
				System.out.println("Cliente eliminado con exito");
			}

			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] MySQLConnection) {
		Scanner scI = new Scanner(System.in);
		Scanner scS = new Scanner(System.in);

		MySQLConnection db = new MySQLConnection();
		Connection conexion = db.mySQLConnect();
		int opcion = 0;
		do {
			try {
				System.out.println("introduzca una opcion\n" + "1) Mostrar todos los clientes\r\n"
						+ "2) Eliminar clientes\r\n" + "3) Añadir clientes\r\n"
						+ "4) Modificar el teléfono de un cliente\r\n"
						+ "5) Buscar clientes por apellido (que muestre todos los clientes que tengan un apellido concreto que será solicitado por scanner)\r\n"
						+ "6) Salir");
				opcion = scI.nextInt();

				switch (opcion) {
				case 1:
					mostrarClientes(conexion);
					break;
				case 2:
					eliminar(conexion);
					break;
				case 3:
					Cliente c = crearCliente();
					insertarClientes2(conexion, c);
					break;
				case 4:
					modificar_tlf(conexion);
					break;
				case 5:
					System.out.println("Introduze un apellido a buscar");
					String apellido = scS.nextLine();
					consultarClientes2(conexion, apellido);
					break;
				case 6:
					System.out.println("adios");
					break;

				default:
					System.out.println("No existe esa opcion");
					break;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Solo se admiten numeros");
				scI.next();
			}
		} while (opcion != 6);

		// System.out.println("Fin - Cerramos conexión");

		// insertar clientes

	}
}
