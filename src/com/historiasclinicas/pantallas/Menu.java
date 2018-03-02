package com.historiasclinicas.pantallas;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = -4764930707608018600L;
	private JButton btnHistoriasClinicas;
	private JButton btnTurnos;
	private JPanel contentPane;

	@SuppressWarnings("rawtypes")
	public Menu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setTitle("Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/logotipo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 252);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JButton btnManual = new JButton("Manual");
		btnManual.addActionListener(arg0 -> {
			final File exit = new File("C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\imagenes\\manual.pdf");
			try {
				Desktop.getDesktop().open(exit);
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		menuBar.add(btnManual);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnTurnos = new JButton("Turnos");
		btnTurnos.addActionListener(arg0 -> new PantaListaTurnos().setVisible(true));
		btnTurnos.setBounds(62, 111, 153, 57);
		btnTurnos.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/iconos/calendar.png")));
		contentPane.add(btnTurnos);


		btnHistoriasClinicas = new JButton("Historias Clinicas");
		btnHistoriasClinicas.setBounds(285, 111, 163, 57);
		btnHistoriasClinicas.addActionListener(arg0 -> {
			final SwingWorker worker = new SwingWorker(){
				@Override
				protected Object doInBackground() throws Exception {
					new PantaPacientes().setVisible(true);
					return null;
				}
			};
			worker.execute();
		});
		btnHistoriasClinicas.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/iconos/inbox.png")));
		contentPane.add(btnHistoriasClinicas);

		final JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/logotipo.png")));
		label.setBounds(163, 11, 184, 89);
		contentPane.add(label);
	}
}
