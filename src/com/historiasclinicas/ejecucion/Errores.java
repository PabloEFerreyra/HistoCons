package com.historiasclinicas.ejecucion;

public class Errores {
	public static String dninumeros() {
		final String mensaje = "Ingrese Solo Numeros";
		return mensaje;
	}

	public static String dnipacienteexistente() {
		final String mensaje = "Paciente ya Existente";
		return mensaje;
	}

	public static String dnipacientenoexistente() {
		final String mensaje = "Paciente no Existente";
		return mensaje;
	}

	public static String dnivacio() {
		final String mensaje = "Ingrese Dni";
		return mensaje;
	}

	public static String errorApeNomVacio() {
		final String mensaje = "Ingrese Apellido/Nombre";
		return mensaje;
	}

	public static String errorApeNomVal() {
		final String mensaje = "El Apellido/Nombre no puede contener numeros";
		return mensaje;
	}

	public static String ErrorCampos() {
		final String mensaje = "Revise los campos, por que hay un problema en ellos, posiblemente texto donde va numeros";
		return mensaje;
	}

	public static String ErrorInterno() {
		final String mensaje = "error interno, vuelva a intentarlo o comuniquese con su administrador";
		return mensaje;
	}

	public static String ErrorPesoAltura() {
		final String mensaje = "verifique los campos de peso/altura, el formato tiene que ser 12.34";
		return mensaje;
	}

	public static String FechaMal() {
		final String mensaje = "Verifique fechas";
		return mensaje;
	}

	public static String FechaNacimientoIncorrecta() {
		final String mensaje = "Verifique fecha Nacimiento";
		return mensaje;
	}

	public static String Ingresediagnostico() {
		final String mensaje = "Ingrese diagnostico";
		return mensaje;
	}

	public static String IngresoHistoriaCorrecta() {
		final String mensaje = "Se ha Ingresado Correctamente la Historia";
		return mensaje;
	}

	public static String IngresoSintomas() {
		final String mensaje = "Ingrese Sintomas";
		return mensaje;
	}

	public static String NoAplica() {
		final String mensaje = "N/A";
		return mensaje;
	}

	public static String nohayturnos() {
		final String mensaje = "No hay mas turnos";
		return mensaje;
	}

	public static String PacienteIngresoCorrecto() {
		final String mensaje = "Se Ha Ingresado Correctamente el Paciente";
		return mensaje;
	}

	public static String SexoMasFem() {
		final String mensaje = "El Sexo solo puede ser Masculino o Femenino";
		return mensaje;
	}

	public static String SexoNull() {
		final String mensaje = "Ingrese Sexo";
		return mensaje;
	}

	public static String sinNumero() {
		final String mensaje = "0";
		return mensaje;
	}

	public static String telefonoerroneo() {
		final String mensaje = "El Telefono no es Valido";
		return mensaje;
	}

	public static String turnoyapasado() {
		final String mensaje = "Ya ha pasado el turno o bien no ha llegado, revise el estado";
		return mensaje;
	}

	public static String UsuarioCorrecto() {
		final String mensaje = "Usuario ingresado correctamente";
		return mensaje;
	}

	public static String UsuarioPassIncorrecto() {
		final String mensaje = "Usuario/Contraseña incorrectos o vacios, por favor complete";
		return mensaje;
	}
}
