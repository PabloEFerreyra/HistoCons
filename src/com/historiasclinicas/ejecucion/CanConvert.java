package com.historiasclinicas.ejecucion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CanConvert {
	private static boolean convertido;
	@SuppressWarnings("unused")
	private static Date date;

	public static boolean Convert(String palabra) {
		try {
			Integer.parseInt(palabra);
			convertido = true;
		} catch (final Exception e) {
			convertido = false;
		}
		return convertido;
	}

	public static boolean DateConvert(String text) {
		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = formatter.parse(text);
			return true;
		}
		catch (final Exception e)
		{
			return false;
		}
	}

	public static boolean FloatConvert(String palabra) {
		try {
			Float.parseFloat(palabra);
			convertido = true;
			return convertido;
		} catch (final Exception e) {
			convertido = false;
			return convertido;
		}

	}

	public static boolean LongConvert(String palabra) {
		try {
			Long.parseLong(palabra);
			convertido = true;
		} catch (final Exception e) {
			convertido = false;
		}
		return convertido;
	}
}
