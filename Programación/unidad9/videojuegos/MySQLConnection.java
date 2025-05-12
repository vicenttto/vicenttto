package unidad9.videojuegos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	 
		public Connection mySQLConnect() {
	        
	    	// Datos de conexión
	        String url = "jdbc:mysql://localhost:3306/jueguicos"; // url bbdd
	        String usuario = "root"; // Cambia por tu usuario de MySQL
	        String password = ""; // Cambia por tu contraseña

	        Connection conexion = null;
	        
	        try {
	            // Cargar el driver de MySQL (opcional para versiones recientes de Java)
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // Establecer la conexión
	            conexion = DriverManager.getConnection(url, usuario, password);
	            System.out.println("Conexión exitosa a la base de datos");
	            
	            // Cerrar la conexión
	            //conexion.close();
	        } catch (ClassNotFoundException e) {
	            System.out.println("Error: No se encontró el driver de MySQL");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Error al conectar a la base de datos");
	            e.printStackTrace();
	        }
	    
	        return conexion;
		}
	}



