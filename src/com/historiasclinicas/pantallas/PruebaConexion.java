package com.historiasclinicas.pantallas;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.gestores.Conexion;

public class PruebaConexion extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;

	public PruebaConexion() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JButton btnPruebaConexion = new JButton("Prueba Conexion");
		btnPruebaConexion.addActionListener(arg0 -> {

			final java.sql.Connection cn = Conexion.getConexion();

			if (cn != null) {

				JOptionPane.showMessageDialog(new JDialog(), "Conectado", "Informacion", JOptionPane.INFORMATION_MESSAGE);

				try {

					cn.close();

				} catch (final SQLException ex) {

					System.out.println("Error al desconectar " + ex);

				}
			} else
				JOptionPane.showMessageDialog(new JDialog(), "Error al conectar", "Error", JOptionPane.ERROR_MESSAGE);

		});
		btnPruebaConexion.setBounds(110, 92, 154, 25);
		contentPane.add(btnPruebaConexion);
	}
}
