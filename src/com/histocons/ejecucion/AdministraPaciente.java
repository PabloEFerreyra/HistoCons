package com.histocons.ejecucion;

public class AdministraPaciente {
	
	public static void ActualizaPaciente(int dni, String apellido, String nombre, String sexo, String fechanac, 
			String obrasocial, int numeroafiliado, String planobra, String provincia, String ciudad,
			String domicilio, int telefono, int celular, String mail, String hace)
	{
		Ejecucion.GuardaPaciente(dni, apellido, nombre, sexo, fechanac, 
				obrasocial, numeroafiliado, planobra, provincia, ciudad, domicilio, 
				telefono, celular, mail, hace);
	}
}
