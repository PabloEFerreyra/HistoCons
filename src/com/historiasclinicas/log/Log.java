package com.historiasclinicas.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Log {
	public static String path = System.getProperty("user.home");
	public static File folder = new File(path+"\\.HistoriasClinicas");
	public static void CreaLog(String Operacion) throws IOException {
		FileWriter archivo = null;
		final Calendar fechaActual = Calendar.getInstance();
		final String fecha = fechaActual.get(Calendar.DAY_OF_MONTH) + " " + (fechaActual.get(Calendar.MONTH) + 1) + " "
				+ fechaActual.get(Calendar.YEAR);
		archivo = new FileWriter(new File(folder+"\\log-HistoCons - " + fecha + ".log"), true);

		if (!(new File(folder+"\\log-HistoCons - " + fecha + ".log").exists()))
			archivo = new FileWriter(new File(folder+"\\log-HistoCons - " + fecha + ".log"),
					false);
		else
			archivo = new FileWriter(new File(folder+"\\log-HistoCons - " + fecha + ".log"), true);

		// Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar
		// el paquete calendar

		archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH)) + "/"
				+ String.valueOf(fechaActual.get(Calendar.MONTH) + 1) + "/"
				+ String.valueOf(fechaActual.get(Calendar.YEAR)) + ";"
				+ String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY)) + ":"
				+ String.valueOf(fechaActual.get(Calendar.MINUTE)) + ":"
				+ String.valueOf(fechaActual.get(Calendar.SECOND))) + ";" + Operacion + "\r\n");

		archivo.close();
	}

	public static void crearLog(String Operacion) throws IOException {
		// Pregunta el archivo existe, caso contrario crea uno con el nombre
		// log.txt
		if (!folder.exists()) {
			folder.mkdirs();
			CreaLog(Operacion);
		} else
			CreaLog(Operacion);
	}
}
