package com.historiasclinicas.ejecucion;

import java.util.Date;

public class AdministrarPaciente {

	public static boolean ActualizaPaciente(Integer dni, String apellido, String nombre, Integer sexo, Date fechanac,
			Integer obrasocial, String numeroafiliado, String planobra, Integer provincia, Integer ciudad,
			String domicilio, Long telefono, Long celular, String mail, String hace) {
		final boolean res = Ejecucion.GuardaPaciente(dni, apellido, nombre, sexo, fechanac, obrasocial, numeroafiliado, planobra, provincia,
				ciudad, domicilio, telefono, celular, mail, null, hace);
		return res;

	}

	public static boolean ActualizaPaciente(Integer dni, String nombre, String apellido, Integer sexo, Date fechanac,
			Integer obrasocial, String numeroafiliado, String planobra, Integer provincia, Integer ciudad, String domicilio,
			Long telefono, Long celular, String mail, String gs, String hace) {
		final boolean res = Ejecucion.GuardaPaciente(dni, nombre, apellido, sexo, fechanac, obrasocial, numeroafiliado, planobra, provincia,
				ciudad, domicilio, telefono, celular, mail, gs, hace);
		return res;
	}
}