package com.histocons.ejecucion;

public class Errores {
	public static String dnivacio()
	{
		String mensaje = "Ingrese Dni";
		return mensaje;
	}
	public static String dninumeros()
	{
		String mensaje = "Ingrese Solo Numeros";
		return mensaje;
	}
	public static String dnipacienteexistente()
	{
		String mensaje = "Paciente ya Existente";
		return mensaje;
	}
	
	public static String telefonoerroneo()
	{
		String mensaje = "El Telefono no es Valido";
		return mensaje;
	}
	
	public static String SexoNull()
	{
		String mensaje = "Ingrese Sexo";
		return mensaje;
	}
	
	public static String SexoMasFem()
	{
		String mensaje = "El Sexo solo puede ser Masculino o Femenino";
		return mensaje;
	}
	
	public static String PacienteIngresoCorrecto()
	{
		String mensaje = "Se Ha Ingresado Correctamente el Paciente";
		return mensaje;
	}
	
	public static String ErrorCampos()
	{
		String mensaje = "Revise los campos, por que hay un problema en ellos, posiblemente texto donde va numeros";
		return mensaje;
	}
	
	public static String ErrorInterno()
	{
		String mensaje = "error interno, vuelva a intentarlo o comuniquese con su administrador";
		return mensaje;
	}
	
	public static String FechaMal()
	{
		String mensaje = "Verifique fechas";
		return mensaje;
	}
	
	public static String ErrorPesoAltura()
	{
		String mensaje = "verifique los campos de peso/altura, el formato tiene que ser 12.34";
		return mensaje;
	}
	public static String IngresoHistoriaCorrecta()
	{
		String mensaje = "Se ha Ingresado Correctamente la Historia";
		return mensaje;
	}
	
	public static String IngresoSintomas()
	{
		String mensaje = "Ingrese Sintomas";
		return mensaje;
	}
	
	public static String NoAplica()
	{
		String mensaje = "N/A";
		return mensaje;
	}
	public static String Ingresediagnostico()
	{
		String mensaje = "Ingrese diagnostico";
		return mensaje;
	}
	
	public static String FechaNacimientoIncorrecta()
	{
		String mensaje ="Verifique fecha Nacimiento";
		return mensaje;
	}
	
	public static String errorApeNomVacio()
	{
		String mensaje =  "Ingrese Apellido/Nombre";
		return mensaje;
	}
	
	public static String errorApeNomVal()
	{
		String mensaje = "El Apellido/Nombre no puede contener numeros";
		return mensaje;
	}
	public static String sinNumero()
	{
		String mensaje = "0";
		return mensaje;
	}
	
	public static String UsuarioCorrecto()
	{
		String mensaje = "Usuario ingresado correctamente";
		return mensaje;
	}
	public static String UsuarioPassIncorrecto()
	{
		String mensaje = "Usuario/Contraseña incorrectos o vacios, por favor complete";
		return mensaje;
	}
}
