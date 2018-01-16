package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAInfo {

    private final static String URL="jdbc:mysql://us-cdbr-iron-east-05.cleardb.net/heroku_8bf21add3c7950f"; 
    private final static String USERNAME = "b543aa714c729c";
    private final static String PASSWORD = "37b9f27b";
 

	public static Connection getConnection() throws SQLException {
                //PREPARAMOS LA CONEXION A LA BASE DE DATOS
		long startTime = System.nanoTime();
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000;
		System.out.println("Tiempo para establecer la conexion "+ duration + " ms");
		return con;
	}
}
