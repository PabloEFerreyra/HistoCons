package com.historiasclinicas.gestores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection conexion = null;

	public static Connection getConexion() {

		if (conexion == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (final Exception ex) {
				System.out.println("Exception: " + "no se pudo registrar el driver");
				System.out.println("Error\n" + ex.getMessage());
				return null;
			}
			try {
				conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.104:3306/histocons", "root", "root");
			} catch (final SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				return null;
			}
		}

		return conexion;

	}

}