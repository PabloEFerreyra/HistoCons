package com.historiasclinicas.ejecucion;

import java.io.IOException;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.entidades.Usuarios;
import com.historiasclinicas.gestores.GestorPacientes;
import com.historiasclinicas.gestores.GestorUsuarios;
import com.historiasclinicas.gestores.LostFocus;
import com.historiasclinicas.log.Log;

public class Ejecucion {
	static boolean error = false;
	static String valornulo = "0";

	public static float calculaimc(float peso, float altura) {
		final float imc = (peso / (altura * altura));

		return imc;

	}

	public static String EvaluaCero(String palabra) {
		if (palabra.equals("")) {
			final String mensaje = Errores.sinNumero();
			return mensaje;
		} else {
			final boolean pasa = LostFocus.ValidaTelefono(palabra);
			if (pasa) {
				JOptionPane.showMessageDialog(new JDialog(), Errores.telefonoerroneo());
				final String mensaje = Errores.sinNumero();
				return mensaje;
			} else
				return palabra;
		}
	}

	public static String EvaluaNoAplica(String palabra) {
		if (palabra.equals("")) {
			final String mensaje = Errores.NoAplica();
			return mensaje;
		} else
			return palabra;
	}

	public static boolean GuardaPaciente(int dni, String nombre, String apellido, Integer sexo, Date fechanac,
			Integer obrasocial, String numeroafiliado, String planobra, Integer provincia, Integer ciudad, String domicilio,
			Long telefono, Long celular, String mail, String gs, String hace) {
		try {
			final Paciente pacientes = new Paciente();
			pacientes.setDni(dni);
			pacientes.setNombre(nombre);
			pacientes.setApellido(apellido);
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
			pacientes.setGruposanguineo(gs);
			pacientes.setCorreo(mail);

			if (hace.toUpperCase().equals("NUEVO")) {
				final int resultado = GestorPacientes.IngresarPaciente(dni, nombre, apellido, sexo, fechanac, obrasocial,
						numeroafiliado, planobra, provincia, ciudad, domicilio, telefono, celular, gs, mail);
				if (resultado == 1) {
					JOptionPane.showMessageDialog(new JDialog(), Errores.PacienteIngresoCorrecto());
					Log.CreaLog("Ingreso Nuevo paciente con errores");
					error = false;
					return error;
				} else {
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
					error = true;
					return error;
				}
			} else if (hace.toUpperCase().equals("ACTUALIZA")) {
				final int resultado = GestorPacientes.ActuaPaciente(pacientes);
				if (resultado == 1) {
					JOptionPane.showMessageDialog(new JDialog(), Errores.PacienteIngresoCorrecto());
					Log.CreaLog("Ingreso Nuevo paciente con errores");
					error = false;
					return error;
				} else {
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
					error = true;
					return error;
				}
			}
		} catch (final NumberFormatException f) {

			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos());
			error = true;
			return error;
		} catch (final Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
			error = true;
			return error;
		}
		return error;

	}

	public static boolean GuardaUsuario(String usuario, String passwrd, String activo, String perfil, String Nombre, String Apellido, String Especialidad, Integer Matricula, String hace)
			throws IOException {
		try {
			final Usuarios usuarios = new Usuarios();
			usuarios.setNombre(Nombre);
			usuarios.setApellido(Apellido);
			usuarios.setEspecialidad(Especialidad);
			usuarios.setUsername(usuario);
			usuarios.setPassword(passwrd);
			usuarios.setIsactive(activo);
			usuarios.setPerfil(perfil);
			usuarios.setMatricula(Matricula);

			if (hace.toUpperCase().equals("NUEVO")) {
				final int resultado = GestorUsuarios.NuevoUsuario(usuario, passwrd, activo, perfil, Nombre, Apellido, Especialidad, Matricula);
				if (resultado == 1) {
					JOptionPane.showMessageDialog(new JDialog(), Errores.UsuarioCorrecto());
					error = false;
					return error;
				} else {
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
					error = true;
					return error;
				}
			} else if (hace.toUpperCase().equals("ACTUALIZA")) {
				final int resultado = GestorUsuarios.ActualizaUsuario(usuarios);
				if (resultado == 1) {
					JOptionPane.showMessageDialog(new JDialog(), Errores.UsuarioCorrecto());
					error = false;
					return error;
				} else {
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
					error = true;
					return error;
				}
			}

			Log.crearLog("Usuario Almacenado Corectamente en el sistema");
		} catch (final Exception f) {
			Log.crearLog(f.getMessage().toString());
			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorInterno());
			error = true;
			return error;
		}
		return error;
	}

	public static String ValidaCorreo(String palabra) {
		final boolean valido = LostFocus.validamail(palabra);
		if (!valido) {
			final String mensaje = palabra;
			return mensaje;
		} else {
			final String mensaje = Errores.NoAplica();
			return mensaje;
		}
	}

	public static boolean validafecha(Date fecha) {
		final Date fechaHoy = new Date();
		if (!(fecha.before(fechaHoy) || fecha.equals(fechaHoy))) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.FechaNacimientoIncorrecta());
			error = true;
			return error;
		} else {
			error = false;
			return error;
		}
	}
}
