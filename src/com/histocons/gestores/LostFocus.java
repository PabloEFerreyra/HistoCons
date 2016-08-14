package com.histocons.gestores;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.histocons.ejecucion.CanConvert;
import com.histocons.ejecucion.Errores;
public class LostFocus {
	static boolean error = false;
	public static boolean ValidaDni(String dni)
	{
		boolean converted = CanConvert.Convert(dni);
		if(dni.equals(""))
		{
			JOptionPane.showMessageDialog(new JDialog(), Errores.dnivacio());
			error = true;	
			return error;
		}
		else if (!converted) {
			JOptionPane.showMessageDialog(new JDialog(), Errores.dninumeros());
			error = true;
			return error;
		}else if(GestorPacientes.ConsultarDni(Integer.parseInt(dni)) == 1){
			JOptionPane.showMessageDialog(new JDialog(), Errores.dnipacienteexistente());
			error = true;
			return error;
		}
		else
		{
			error = false;
			return error;
		}
	}
	
	public static boolean ValidaApellidoyNombre(String palabra)
	{
		boolean converted = CanConvert.Convert(palabra);
		if(palabra.equals(""))
		{
			JOptionPane.showMessageDialog(new JDialog(),Errores.errorApeNomVacio());
			error = true;
			return error;
		}
		else if(converted)
		{
			JOptionPane.showMessageDialog(new JDialog(),Errores.errorApeNomVal());
			error = true;
			return error;
		}
		else
		{
			error = false;
			return error;
		}
	}
	
	public static boolean ValidaTelefono(String Telefono)
	{
		if (CanConvert.Convert(Telefono))
		{			
			if(Telefono.length() > 13)
			{
				error = true;
				return error;
			}
			else 
			{
				error = false;
				return  error;
			}
		}
		else
		{
			error = true;
			return error;
		}
	}
	
	public static boolean validamail(String mail)
	{
		if(mail.equals(""))
		{
			error = true;
			return error;
		}
		else
		{
			boolean correcto = ValidaEmail.esEmailCorrecto(mail);
			if (correcto)
			{
				error = false;
				return error;
			}
			else
			{
				error = true;
				return error;
			}
		}
	}
	//si dentro de dos años, volves a ver esto, dejame decirte
	//DEBISTE HABER DOCUMENTADO MEJOR, Y CORREGIR LOS NOMBRE DE 
	//LAS VARIABLES Y LOS EVENTOS!!
	public static boolean ValidaPesoAltura(String palabra)
	{
		boolean convertido = CanConvert.FloatConvert(palabra);
		if(!convertido)
		{
			JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorPesoAltura());
			error = true;
			return error;
		}
		else
		{
			error = false;
			return error;
		}
	}
}
