package com.historiasclinicas.pantallas;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class PantaVademecum extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static void lanzarNavegador(String html) {
		if (java.awt.Desktop.isDesktopSupported()) {
			final java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					final java.net.URI uri = new java.net.URI("http://ar.prvademecum.com/productos.php?producto="+html+"&query_submit6=");
					desktop.browse(uri);
				} catch (URISyntaxException | IOException ex) {
				}
			}
		}
	}
	private final JPanel contentPane;

	private final JTextField txtMedicamento;

	public PantaVademecum() {
		setResizable(false);
		setTitle("Busqueda Medicamentos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaVademecum.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JLabel lblMedicamentoprimerasLetras = new JLabel("Medicamento (primeras letras)");
		lblMedicamentoprimerasLetras.setBounds(0, 11, 145, 14);
		contentPane.add(lblMedicamentoprimerasLetras);

		txtMedicamento = new JTextField();
		txtMedicamento.setBounds(0, 30, 335, 20);
		contentPane.add(txtMedicamento);
		txtMedicamento.setColumns(10);

		final JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(e -> lanzarNavegador(txtMedicamento.getText()));
		btnBuscar.setBounds(345, 29, 89, 23);
		contentPane.add(btnBuscar);
	}
}
