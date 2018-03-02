package com.historiasclinicas.pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorPacientes;
import com.toedter.calendar.JDateChooser;

public class PantaControlVacunas extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -5319277199706727668L;
	private String bcg = "N/A";
	private final JButton btnCancelar;
	private final JButton btnGuardar;
	private final JButton btnOtros;
	private final Calendar c2 = new GregorianCalendar();
	private final JPanel contentPane;
	private final DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
	private String dpt = "N/A";
	private String dta = "N/A";
	private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private String hepA = "N/A";
	private String hepB = "N/A";
	private String hib = "N/A";
	private final Date hoy = new Date();
	private final String hoyA;
	private final Date hoyB;
	private final JLabel lblDpt;
	private final JLabel lblDta;
	private final JLabel lblHepA;
	private final JLabel lblHib;
	private final JLabel lblPrs;
	private Boolean otros = false;
	private final Integer pacient;
	private String prs = "N/A";
	private String sabin = "N/A";
	private final JDateChooser txtDateChooser;
	private final JDateChooser txtDateChooser_1;
	private final JDateChooser txtDateChooser_2;
	private final JDateChooser txtDateChooser_3;
	private final JDateChooser txtDateChooser_4;
	private final JDateChooser txtDateChooser_5;
	private final JDateChooser txtDateChooser_6;
	private final JDateChooser txtDateChooser_7;
	public PantaControlVacunas(Paciente paciente) throws ParseException {
		pacient = paciente.getDni();
		hoyA = formatter.format(hoy);
		hoyB = formatter.parse(hoyA);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaControlVacunas.class.getResource("/imagenes/logotipo.png")));
		setTitle("Control Vacunas");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 408, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{86, 83, 96, 101, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		final JLabel lblBcg = new JLabel("BCG");
		final GridBagConstraints gbc_lblBcg = new GridBagConstraints();
		gbc_lblBcg.fill = GridBagConstraints.BOTH;
		gbc_lblBcg.insets = new Insets(0, 0, 5, 5);
		gbc_lblBcg.gridx = 0;
		gbc_lblBcg.gridy = 0;
		contentPane.add(lblBcg, gbc_lblBcg);

		final JLabel lblHepB = new JLabel("Hep B");
		final GridBagConstraints gbc_lblHepB = new GridBagConstraints();
		gbc_lblHepB.fill = GridBagConstraints.BOTH;
		gbc_lblHepB.insets = new Insets(0, 0, 5, 5);
		gbc_lblHepB.gridx = 1;
		gbc_lblHepB.gridy = 0;
		contentPane.add(lblHepB, gbc_lblHepB);

		lblHib = new JLabel("HIB");
		final GridBagConstraints gbc_lblHib = new GridBagConstraints();
		gbc_lblHib.fill = GridBagConstraints.BOTH;
		gbc_lblHib.insets = new Insets(0, 0, 5, 5);
		gbc_lblHib.gridx = 2;
		gbc_lblHib.gridy = 0;
		contentPane.add(lblHib, gbc_lblHib);

		lblDta = new JLabel("DTa");
		final GridBagConstraints gbc_lblDta = new GridBagConstraints();
		gbc_lblDta.fill = GridBagConstraints.BOTH;
		gbc_lblDta.insets = new Insets(0, 0, 5, 0);
		gbc_lblDta.gridx = 3;
		gbc_lblDta.gridy = 0;
		contentPane.add(lblDta, gbc_lblDta);

		txtDateChooser = new JDateChooser();
		txtDateChooser.setCalendar(c2);
		txtDateChooser.setDateFormatString("dd/MM/yyyy");

		final GridBagConstraints gbc_txtDateChooser = new GridBagConstraints();
		gbc_txtDateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateChooser.fill = GridBagConstraints.BOTH;
		gbc_txtDateChooser.gridx = 0;
		gbc_txtDateChooser.gridy = 1;
		contentPane.add(txtDateChooser, gbc_txtDateChooser);

		txtDateChooser_1 = new JDateChooser();
		txtDateChooser_1.setBorder(null);
		txtDateChooser_1.setCalendar(c2);
		txtDateChooser_1.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_txtDateChooser_1 = new GridBagConstraints();
		gbc_txtDateChooser_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_txtDateChooser_1.gridx = 1;
		gbc_txtDateChooser_1.gridy = 1;
		contentPane.add(txtDateChooser_1, gbc_txtDateChooser_1);

		txtDateChooser_2 = new JDateChooser();
		txtDateChooser_2.setCalendar(c2);
		txtDateChooser_2.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_txtDateChooser_2 = new GridBagConstraints();
		gbc_txtDateChooser_2.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateChooser_2.fill = GridBagConstraints.BOTH;
		gbc_txtDateChooser_2.gridx = 2;
		gbc_txtDateChooser_2.gridy = 1;
		contentPane.add(txtDateChooser_2, gbc_txtDateChooser_2);

		txtDateChooser_3 = new JDateChooser();
		txtDateChooser_3.setCalendar(c2);
		txtDateChooser_3.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_txtDateChooser_3 = new GridBagConstraints();
		gbc_txtDateChooser_3.insets = new Insets(0, 0, 5, 0);
		gbc_txtDateChooser_3.fill = GridBagConstraints.BOTH;
		gbc_txtDateChooser_3.gridx = 3;
		gbc_txtDateChooser_3.gridy = 1;
		contentPane.add(txtDateChooser_3, gbc_txtDateChooser_3);

		final JLabel lblSabin = new JLabel("Sabin");
		final GridBagConstraints gbc_lblSabin = new GridBagConstraints();
		gbc_lblSabin.fill = GridBagConstraints.BOTH;
		gbc_lblSabin.insets = new Insets(0, 0, 5, 5);
		gbc_lblSabin.gridx = 0;
		gbc_lblSabin.gridy = 2;
		contentPane.add(lblSabin, gbc_lblSabin);

		lblDpt = new JLabel("DPT");
		final GridBagConstraints gbc_lblDpt = new GridBagConstraints();
		gbc_lblDpt.fill = GridBagConstraints.BOTH;
		gbc_lblDpt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDpt.gridx = 1;
		gbc_lblDpt.gridy = 2;
		contentPane.add(lblDpt, gbc_lblDpt);

		lblPrs = new JLabel("PRS");
		final GridBagConstraints gbc_lblPrs = new GridBagConstraints();
		gbc_lblPrs.fill = GridBagConstraints.BOTH;
		gbc_lblPrs.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrs.gridx = 2;
		gbc_lblPrs.gridy = 2;
		contentPane.add(lblPrs, gbc_lblPrs);

		lblHepA = new JLabel("Hep A");
		final GridBagConstraints gbc_lblHepA = new GridBagConstraints();
		gbc_lblHepA.fill = GridBagConstraints.BOTH;
		gbc_lblHepA.insets = new Insets(0, 0, 5, 0);
		gbc_lblHepA.gridx = 3;
		gbc_lblHepA.gridy = 2;
		contentPane.add(lblHepA, gbc_lblHepA);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(e -> {
			try {

				GuardarVacunas();
			} catch (final ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		btnOtros = new JButton("Otros");
		btnOtros.addActionListener(e -> {
			otros = true;
			PantaOtrasVacunas pov = null;
			try {
				pov = new PantaOtrasVacunas(paciente);
			} catch (final ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pov.setVisible(true);
		});

		txtDateChooser_4 = new JDateChooser();
		txtDateChooser_4.setCalendar(c2);
		txtDateChooser_4.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_txtDateChooser_4 = new GridBagConstraints();
		gbc_txtDateChooser_4.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateChooser_4.fill = GridBagConstraints.BOTH;
		gbc_txtDateChooser_4.gridx = 0;
		gbc_txtDateChooser_4.gridy = 3;
		contentPane.add(txtDateChooser_4, gbc_txtDateChooser_4);

		txtDateChooser_5 = new JDateChooser();
		txtDateChooser_5.setCalendar(c2);
		txtDateChooser_5.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_txtDateChooser_5 = new GridBagConstraints();
		gbc_txtDateChooser_5.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateChooser_5.fill = GridBagConstraints.BOTH;
		gbc_txtDateChooser_5.gridx = 1;
		gbc_txtDateChooser_5.gridy = 3;
		contentPane.add(txtDateChooser_5, gbc_txtDateChooser_5);

		txtDateChooser_6 = new JDateChooser();
		txtDateChooser_6.setCalendar(c2);
		txtDateChooser_6.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_txtDateChooser_6 = new GridBagConstraints();
		gbc_txtDateChooser_6.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateChooser_6.fill = GridBagConstraints.BOTH;
		gbc_txtDateChooser_6.gridx = 2;
		gbc_txtDateChooser_6.gridy = 3;
		contentPane.add(txtDateChooser_6, gbc_txtDateChooser_6);

		txtDateChooser_7 = new JDateChooser();
		txtDateChooser_7.setCalendar(c2);
		txtDateChooser_7.setDateFormatString("dd/MM/yyyy");
		final GridBagConstraints gbc_txtDateChooser_7 = new GridBagConstraints();
		gbc_txtDateChooser_7.insets = new Insets(0, 0, 5, 0);
		gbc_txtDateChooser_7.fill = GridBagConstraints.BOTH;
		gbc_txtDateChooser_7.gridx = 3;
		gbc_txtDateChooser_7.gridy = 3;
		contentPane.add(txtDateChooser_7, gbc_txtDateChooser_7);
		btnOtros.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnOtros = new GridBagConstraints();
		gbc_btnOtros.fill = GridBagConstraints.BOTH;
		gbc_btnOtros.insets = new Insets(0, 0, 0, 5);
		gbc_btnOtros.gridx = 0;
		gbc_btnOtros.gridy = 4;
		contentPane.add(btnOtros, gbc_btnOtros);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> dispose());
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.setIcon(new ImageIcon(PantaControlVacunas.class.getResource("/imagenes/iconos/twentytwo/ban.png")));
		final GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.BOTH;
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 2;
		gbc_btnCancelar.gridy = 4;
		contentPane.add(btnCancelar, gbc_btnCancelar);
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setIcon(new ImageIcon(PantaControlVacunas.class.getResource("/imagenes/iconos/twentytwo/save.png")));
		final GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 3;
		gbc_btnGuardar.gridy = 4;
		contentPane.add(btnGuardar, gbc_btnGuardar);
	}
	public void Guardado() {

		final boolean res = GestorPacientes.GuardaVacunas(bcg, sabin, hepB, dpt, hib, prs, dta, hepA, otros, pacient);
		if (res)
		{
			JOptionPane.showMessageDialog(new JDialog(), "Ingreso Correcto", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		else
			JOptionPane.showMessageDialog(new JDialog(), "Error Interno, consulte con sistemas", "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void GuardarVacunas() throws ParseException {
		if(txtDateChooser.getDate() == null)
			bcg = "";
		else
		{
			if (txtDateChooser.getDate().before(hoy) || txtDateChooser.getDate().equals(hoy))
				bcg = txtDateChooser.getDate().toString();
			else
			{
				JOptionPane.showMessageDialog(new JDialog(), "solo puede ingresar fechas antes o de hoy", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(txtDateChooser_4.getDate() == null)
			sabin = "";
		else
		{
			if (txtDateChooser_4.getDate().before(hoy) || txtDateChooser_4.getDate().equals(hoy))
				sabin = txtDateChooser.getDate().toString();
			else
			{
				JOptionPane.showMessageDialog(new JDialog(), "solo puede ingresar fechas antes o de hoy", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(txtDateChooser_1.getDate() == null)
			hepB = "";
		else
		{
			if (txtDateChooser_1.getDate().before(hoy) || txtDateChooser_1.getDate().equals(hoy))
				hepB = txtDateChooser.getDate().toString();
			else
			{
				JOptionPane.showMessageDialog(new JDialog(), "solo puede ingresar fechas antes o de hoy", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(txtDateChooser_5.getDate() == null)
			dpt = "";
		else
		{
			if (txtDateChooser_5.getDate().before(hoy) || txtDateChooser_5.getDate().equals(hoy))
				dpt = txtDateChooser.getDate().toString();
			else
			{
				JOptionPane.showMessageDialog(new JDialog(), "solo puede ingresar fechas antes o de hoy", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(txtDateChooser_2.getDate() == null)
			hib = "";
		else
			hib = txtDateChooser_2.getDate().toString();
		if(txtDateChooser_6.getDate() == null)
			prs = "";
		else
			prs = txtDateChooser_6.getDate().toString();
		if(txtDateChooser_3.getDate() == null)
			dta = "";
		else
			dta = txtDateChooser_3.getDate().toString();
		if(txtDateChooser_7.getDate() == null)
			hepA = "";
		else
			hepA = txtDateChooser_7.getDate().toString();
		
			Guardado();
		
	}

}
