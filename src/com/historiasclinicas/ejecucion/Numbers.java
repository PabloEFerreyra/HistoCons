package com.historiasclinicas.ejecucion;

import java.awt.event.KeyEvent;

public class Numbers {
	public static void caracteres(KeyEvent e){
		final char caracter = e.getKeyChar();
		if(((caracter < '0') ||
				(caracter > '9')) &&
				(caracter != '\b'))
		{
			e.consume();
		}
	}
}
