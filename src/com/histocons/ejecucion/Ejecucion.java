package com.histocons.ejecucion;

import java.io.IOException;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.histocons.ejecucion.Errores;
import com.histocons.entidades.Historia;
import com.histocons.entidades.Paciente;
import com.histocons.entidades.Usuarios;
import com.histocons.gestores.GestorHistoria;
import com.histocons.gestores.GestorPacientes;
import com.histocons.gestores.GestorUsuarios;
import com.histocons.gestores.LostFocus;
import com.histocons.log.Log;

public class Ejecucion {
	static boolean error = false;
	static String valornulo = "0";
	public static boolean GuardaPaciente(int dni, String apellido, String nombre, String sexo, String fechanac, String obrasocial, 
			int numeroafiliado, String planobra, String provincia, String ciudad, String domicilio, int telefono, 
			int celular, String mail, String hace)
	{
		try
		{
			Paciente pacientes = new Paciente();
			pacientes.setDni(dni);
			pacientes.setApellido(apellido);
			pacientes.setNombre(nombre);
			pacientes.setSexo(sexo);
			pacientes.setFechaNacimiento(fechanac);
			pacientes.setObraSocial(obrasocial);
			pacientes.setNroAfiliado(numeroafiliado);
			pacientes.setPlanOs(planobra);
			pacientes.setProvincia(provincia);
			pacientes.setCiudad(ciudad);
			pacientes.setDomicilio(domicilio);
			pacientes.setTelefono(telefono);
			pacientes.setTelefonoCelular(celular);
			pacientes.setCorreo(mail);
			
			if(hace.toUpperCase().equals("NUEVO"))
			{
			int resultado=GestorPacientes.IngresarPaciente(dni, apellido, nombre, sexo, fechanac, obrasocial, numeroafiliado, planobra,
					provincia, ciudad, domicilio, telefono, celular, mail);
				if (resultado==1)
				{
					JOptionPane.showMessageDialog(new JDialog(), Errores.PacienteIngresoCorrecto());
					error = false;
					return error;
				}
				else
				{
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
					error = true;
					return error;
				}
			}
			else if (hace.toUpperCase().equals("ACTUALIZA"))
			{
				int resultado=GestorPacientes.ActuaPaciente(pacientes);
				if (resultado==1)
				{
					JOptionPane.showMessageDialog(new JDialog(), Errores.PacienteIngresoCorrecto());
					error = false;
					return error;
				}
				else
				{
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
					error = true;
					return error;
				}
			}
		}
			catch(NumberFormatException f)
		{
				
			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos());
			error = true;
			return error;
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
			error = true;
			return error;
		}
		return error;
		
	}
	public static float calculaimc(float peso, float altura) {
		float imc = (peso /(altura*altura));
		
		return imc;
		
	}
	public static boolean validafecha(Date fecha)
	{
		final Date fechaHoy = new Date();
		if(!(fecha.before(fechaHoy)|| fecha.equals(fechaHoy)))
		{
			JOptionPane.showMessageDialog(new JDialog(), Errores.FechaNacimientoIncorrecta());
			error = true;
			return error;
		}
		else
		{
			error = false;
			return error;
		}
	}
	
	public static String EvaluaNoAplica(String palabra)
	{
		if (palabra.equals(""))
		{
			String mensaje = Errores.NoAplica();
			return mensaje;
		}
		else
		{
			return palabra;
		}
	}
	public static String EvaluaCero(String palabra)
	{
		if(palabra.equals(""))
		{
			String mensaje = Errores.sinNumero();
			return mensaje;
		}
		else
		{
			boolean pasa = LostFocus.ValidaTelefono(palabra);
			if(pasa)
			{
				JOptionPane.showMessageDialog(new JDialog(), Errores.telefonoerroneo());
				String mensaje = Errores.sinNumero();
				return mensaje;
			}
			else	
				return palabra;
		}
	}
	public static String ValidaCorreo(String palabra)
	{
		boolean valido = LostFocus.validamail(palabra);
		if (!valido)
		{
			String mensaje = palabra;
			return mensaje;
		}
		else
		{
			String mensaje = Errores.NoAplica();
			return mensaje;
		}
	}
	public static boolean GuardaUsuario(String usuario, String passwrd, String activo, String perfil, String hace) throws IOException {
		try
		{
			Usuarios usuarios = new Usuarios();
			usuarios.setUsername(usuario);
			usuarios.setPassword(passwrd);
			usuarios.setIsactive(activo);
			usuarios.setPerfil(perfil);
			
			if(hace.toUpperCase().equals("NUEVO"))
			{
			int resultado=GestorUsuarios.NuevoUsuario(usuario, passwrd, activo, perfil);
				if (resultado == 1)
				{
					JOptionPane.showMessageDialog(new JDialog(), Errores.UsuarioCorrecto());
					error = false;
					return error;
				}
				else
				{
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
					error = true;
					return error;
				}
			}
			else if (hace.toUpperCase().equals("ACTUALIZA"))
			{
				int resultado=GestorUsuarios.ActualizaUsuario(usuarios);
				if (resultado==1)
				{
					JOptionPane.showMessageDialog(new JDialog(), Errores.UsuarioCorrecto());
					error = false;
					return error;
				}
				else
				{
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
					error = true;
					return error;
				}
			}
			
			Log.crearLog("Usuario Almacenado Corectamente en el sistema");
		}
			catch(Exception f)
		{
				Log.crearLog(f.getMessage().toString());
			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
			error = true;
			return error;
		}
		return error;
	}
}

