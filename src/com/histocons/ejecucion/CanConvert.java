package com.histocons.ejecucion;

public class CanConvert {
private static boolean convertido;

	public static boolean Convert (String palabra)
	{
		try
		{
			Integer.parseInt(palabra);
			convertido = true;
		}
		catch(Exception e)
		{
			convertido = false;
		}
		return convertido;
	}
	public static boolean LongConvert (String palabra)
	{
		try
		{
			Long.parseLong(palabra);
			convertido = true;
		}
		catch(Exception e)
		{
			convertido = false;
		}
		return convertido;
	}
	
	public static boolean FloatConvert (String palabra)
	{
		try
		{
			Float.parseFloat(palabra);
			convertido = true;
			return convertido;
		}
		catch(Exception e)
		{
			convertido = false;
			return convertido;
		}
		
	}
}
