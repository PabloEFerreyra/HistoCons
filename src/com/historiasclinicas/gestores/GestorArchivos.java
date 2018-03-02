package com.historiasclinicas.gestores;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class GestorArchivos {
	public static void abrirarchivo(String archivo){

		try {

			final File objetofile = new File (archivo);
			Desktop.getDesktop().open(objetofile);

		}catch (final IOException ex) {

			System.out.println(ex);

		}

	}
}
