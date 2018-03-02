package com.historiasclinicas.gestores;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.historiasclinicas.ejecucion.CanConvert;
import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.log.Log;

public class LostFocus {
	static boolean error = false;

	public static boolean ValidaApellidoyNombre(String palabra) {
		final boolean converted = CanConvert.Convert(palabra);
		if (palabra.equals("")) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.errorApeNomVacio());
			error = true;
			return error;
		} else if (converted) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.errorApeNomVal());
			error = true;
			return error;
		} else {
			error = false;
			return error;
		}
	}

	public static boolean ValidaDni(String dni) throws IOException {
		final boolean converted = CanConvert.Convert(dni);
		if (dni.equals("")) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.dnivacio());
			error = true;
			return error;
		} else if (!converted) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.dninumeros());
			error = true;
			return error;
		} else{
			final int dniConv = Integer.parseInt(dni);
			if((dniConv<1000000) || (dniConv>99999999))
			{
				JOptionPane.showMessageDialog(new JDialog(), Errores.dninumeros());
				error = true;
				return error;
			}
			else
			{
				try {
					if (GestorPacientes.ConsultarDni(Integer.parseInt(dni)) == 1) {
						JOptionPane.showMessageDialog(new JDialog(), Errores.dnipacienteexistente());
						error = true;
						return error;
					} else {
						error = false;
						return error;
					}
				} catch (NumberFormatException | HeadlessException | IOException e) {
					Log.CreaLog(e.toString());
					e.printStackTrace();
				}
			}
		}
		return error;
	}

	public static boolean validamail(String mail) {
		if (mail.equals("")) {
			error = true;
			return error;
		} else {
			final boolean correcto = ValidaEmail.esEmailCorrecto(mail);
			if (correcto) {
				error = false;
				return error;
			} else {
				error = true;
				return error;
			}
		}
	}

	// si dentro de dos años, volves a ver esto, dejame decirte
	// DEBISTE HABER DOCUMENTADO MEJOR, Y CORREGIR LOS NOMBRE DE
	// LAS VARIABLES Y LOS EVENTOS!!
	public static boolean ValidaPesoAltura(String palabra) {
		final boolean convertido = CanConvert.FloatConvert(palabra);
		if (!convertido) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorPesoAltura());
			error = true;
			return error;
		} else {
			error = false;
			return error;
		}
	}

	public static boolean ValidaTelefono(String Telefono) {
		if (CanConvert.LongConvert(Telefono)) {
			if (Telefono.length() > 20) {
				error = true;
				return error;
			} else {
				error = false;
				return error;
			}
		} else {
			error = true;
			return error;
		}
	}
}
