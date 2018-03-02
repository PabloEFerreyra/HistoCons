package com.historiasclinicas.main;

import java.awt.EventQueue;

import com.historiasclinicas.pantallas.PantaLogin;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				final PantaLogin frame = new PantaLogin();
				frame.setVisible(true);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		});
	}
}
