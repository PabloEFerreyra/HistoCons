package com.historiasclinicas.pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorPacientes;
import com.historiasclinicas.log.Log;
import com.toedter.calendar.JDateChooser;

public class PantaOtrasVacunas extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 7725581059879816576L;
	private final Calendar c2 = new GregorianCalendar();
	private JDateChooser dateChooser;
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private final Date hoy = new Date();
	private JTextField txtNombreVacuna;
	public PantaOtrasVacunas(Paciente paciente) throws ParseException {
		final String hoyA = formatter.format(hoy);
		final Date hoyB = formatter.parse(hoyA);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaOtrasVacunas.class.getResource("/imagenes/logotipo.png")));
		setTitle("Otras Vacunas");
		setBounds(100, 100, 478, 95);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		final GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		final JLabel lblNombreVacuna = new JLabel("Nombre Vacuna");
		final GridBagConstraints gbc_lblNombreVacuna = new GridBagConstraints();
		gbc_lblNombreVacuna.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreVacuna.fill = GridBagConstraints.BOTH;
		gbc_lblNombreVacuna.gridx = 0;
		gbc_lblNombreVacuna.gridy = 0;
		getContentPane().add(lblNombreVacuna, gbc_lblNombreVacuna);

		final JLabel lblFecha = new JLabel("Fecha");
		final GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 0);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 0;
		getContentPane().add(lblFecha, gbc_lblFecha);

		txtNombreVacuna = new JTextField();
		final GridBagConstraints gbc_txtNombreVacuna = new GridBagConstraints();
		gbc_txtNombreVacuna.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreVacuna.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreVacuna.gridx = 0;
		gbc_txtNombreVacuna.gridy = 1;
		getContentPane().add(txtNombreVacuna, gbc_txtNombreVacuna);
		txtNombreVacuna.setColumns(10);

		final JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(e -> {
			final SwingWorker<?, ?> worker = new SwingWorker<Object, Object>(){
				@Override
				protected Object doInBackground() throws Exception {
					final String nombreVacuna = txtNombreVacuna.getText();
					String fechaVacuna = null;
					if (dateChooser.getDate().before(hoyB) || dateChooser.getDate().equals(hoyB))
						fechaVacuna = dateChooser.getDate().toString();
					else
					{
						JOptionPane.showMessageDialog(new JDialog(), "Error de verificacion fecha", "Error", JOptionPane.ERROR_MESSAGE);
						txtNombreVacuna.requestFocus();
					}
					final Integer pac = paciente.getDni();

					final boolean res = GestorPacientes.GuardaOtrasvacunas(nombreVacuna, fechaVacuna, pac);
					if (res)
					{
						Log.CreaLog("Vacunas guardadas correctamente");
						JOptionPane.showMessageDialog(new JDialog(), "Vacunas guardadas correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					else
					{
						Log.CreaLog("error interno");
						JOptionPane.showMessageDialog(new JDialog(), "Error Interno, intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
					}
					return null;
				}
			};
			worker.execute();
		});

		dateChooser = new JDateChooser();
		final GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 1;
		dateChooser.setCalendar(c2);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		getContentPane().add(dateChooser, gbc_dateChooser);
		final GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.anchor = GridBagConstraints.WEST;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 2;
		getContentPane().add(btnGuardar, gbc_btnGuardar);

	}

}
