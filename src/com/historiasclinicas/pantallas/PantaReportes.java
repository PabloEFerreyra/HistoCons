package com.historiasclinicas.pantallas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
import com.historiasclinicas.gestores.Conexion;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
public class PantaReportes extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 6695519515164457187L;
	private final JPanel contentPane;
	private final JLabel lblNewLabel;
	@SuppressWarnings("rawtypes")
	private Map parametro;
	public PantaReportes(Paciente paciente) {
		setType(Type.POPUP);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaReportes.class.getResource("/imagenes/logotipo.png")));
		setTitle("Reportes");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 230, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		final JButton btnNewButton = new JButton("Reporte Ingresos");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent e) {
				parametro = new HashMap();
				parametro.put("Paciente", paciente.getDni());
				JasperReport jr = null;
				final String archivo = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\Historias.jasper";
				try {
					jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
					final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
					JasperPrintManager.printReport(jp, true);
				} catch (final JRException e1) {
					JOptionPane.showMessageDialog(new JDialog(), "No se encontraron registros para el paciente", "VACIO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		final JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("SansSerif", Font.BOLD, 12));
		final GridBagConstraints gbc_lblPaciente = new GridBagConstraints();
		gbc_lblPaciente.anchor = GridBagConstraints.WEST;
		gbc_lblPaciente.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaciente.gridx = 1;
		gbc_lblPaciente.gridy = 0;
		contentPane.add(lblPaciente, gbc_lblPaciente);

		lblNewLabel = new JLabel();
		lblNewLabel.setText(paciente.getNombre()+" "+paciente.getApellido());
		final GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(PantaReportes.class.getResource("/imagenes/iconos/twentytwo/calendar-check-o.png")));
		final GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		final JButton btnReporteAntecPers = new JButton("Reporte Antec. Personales");
		btnReporteAntecPers.setHorizontalAlignment(SwingConstants.LEFT);
		btnReporteAntecPers.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent arg0) {
				parametro = new HashMap();
				parametro.put("Paciente", paciente.getDni());
				JasperReport jr = null;
				final String archivo = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\Antecedentes.jasper";
				try {
					jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
					final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
					JasperPrintManager.printReport(jp, true);
				} catch (final JRException e1) {
					JOptionPane.showMessageDialog(new JDialog(), "No se encontraron registros para el paciente", "VACIO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnReporteAntecPers.setIcon(new ImageIcon(PantaReportes.class.getResource("/imagenes/iconos/twentytwo/building.png")));
		final GridBagConstraints gbc_btnReporteAntecPers = new GridBagConstraints();
		gbc_btnReporteAntecPers.fill = GridBagConstraints.BOTH;
		gbc_btnReporteAntecPers.insets = new Insets(0, 0, 5, 5);
		gbc_btnReporteAntecPers.gridx = 1;
		gbc_btnReporteAntecPers.gridy = 3;
		contentPane.add(btnReporteAntecPers, gbc_btnReporteAntecPers);

		final JButton btnReporteAntecFamiliares = new JButton("Reporte Antec. Familiares");
		btnReporteAntecFamiliares.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent arg0) {
				parametro = new HashMap();
				parametro.put("Paciente", paciente.getDni());
				JasperReport jr = null;
				final String archivo = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\AntecedentesF.jasper";
				try {
					jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
					final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
					JasperPrintManager.printReport(jp, true);
				} catch (final JRException e1) {
					JOptionPane.showMessageDialog(new JDialog(), "No se encontraron registros para el paciente", "VACIO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnReporteAntecFamiliares.setIcon(new ImageIcon(PantaReportes.class.getResource("/imagenes/iconos/twentytwo/building.png")));
		btnReporteAntecFamiliares.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnReporteAntecFamiliares = new GridBagConstraints();
		gbc_btnReporteAntecFamiliares.fill = GridBagConstraints.BOTH;
		gbc_btnReporteAntecFamiliares.insets = new Insets(0, 0, 5, 5);
		gbc_btnReporteAntecFamiliares.gridx = 1;
		gbc_btnReporteAntecFamiliares.gridy = 4;
		contentPane.add(btnReporteAntecFamiliares, gbc_btnReporteAntecFamiliares);

		final JButton btnReporteVacunas = new JButton("Reporte Vacunas");
		btnReporteVacunas.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent e) {
				parametro = new HashMap();
				parametro.put("Paciente", paciente.getDni());
				JasperReport jr = null;
				final String archivo = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\Vacunas.jasper";
				try {
					jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
					final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
					JasperPrintManager.printReport(jp, true);
				} catch (final JRException e1) {
					JOptionPane.showMessageDialog(new JDialog(), "No se encontraron registros para el paciente", "VACIO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnReporteVacunas.setIcon(new ImageIcon(PantaReportes.class.getResource("/imagenes/iconos/twentytwo/eyedropper.png")));
		btnReporteVacunas.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnReporteVacunas = new GridBagConstraints();
		gbc_btnReporteVacunas.fill = GridBagConstraints.BOTH;
		gbc_btnReporteVacunas.insets = new Insets(0, 0, 5, 5);
		gbc_btnReporteVacunas.gridx = 1;
		gbc_btnReporteVacunas.gridy = 5;
		contentPane.add(btnReporteVacunas, gbc_btnReporteVacunas);

		final JButton btnReporteCrecimiento = new JButton("Reporte Crecimiento");
		btnReporteCrecimiento.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent e) {
				parametro = new HashMap();
				parametro.put("Paciente", paciente.getDni());
				JasperReport jr = null;
				final String archivo = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\Crecimiento.jasper";
				try {
					jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
					final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
					JasperPrintManager.printReport(jp, true);
				} catch (final JRException e1) {
					JOptionPane.showMessageDialog(new JDialog(), "No se encontraron registros para el paciente", "VACIO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnReporteCrecimiento.setIcon(new ImageIcon(PantaReportes.class.getResource("/imagenes/iconos/twentytwo/child.png")));
		btnReporteCrecimiento.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnReporteCrecimiento = new GridBagConstraints();
		gbc_btnReporteCrecimiento.fill = GridBagConstraints.BOTH;
		gbc_btnReporteCrecimiento.insets = new Insets(0, 0, 5, 5);
		gbc_btnReporteCrecimiento.gridx = 1;
		gbc_btnReporteCrecimiento.gridy = 6;
		contentPane.add(btnReporteCrecimiento, gbc_btnReporteCrecimiento);

		final JButton btnReporteErroresCongenitos = new JButton("Reporte Errores Congenitos");
		btnReporteErroresCongenitos.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void actionPerformed(ActionEvent arg0) {
				parametro = new HashMap();
				parametro.put("Paciente", paciente.getDni());
				JasperReport jr = null;
				final String archivo = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\ErroresCongenitos.jasper";
				try {
					jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
					final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
					JasperPrintManager.printReport(jp, true);
				} catch (final JRException e1) {
					JOptionPane.showMessageDialog(new JDialog(), "No se encontraron registros para el paciente", "VACIO", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				//JOptionPane.showMessageDialog(new JDialog(), "Boton en Mantenimiento", "Mantenimiento", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnReporteErroresCongenitos.setIcon(new ImageIcon(PantaReportes.class.getResource("/imagenes/iconos/twentytwo/bars.png")));
		btnReporteErroresCongenitos.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnReporteErroresCongenitos = new GridBagConstraints();
		gbc_btnReporteErroresCongenitos.fill = GridBagConstraints.BOTH;
		gbc_btnReporteErroresCongenitos.insets = new Insets(0, 0, 0, 5);
		gbc_btnReporteErroresCongenitos.gridx = 1;
		gbc_btnReporteErroresCongenitos.gridy = 7;
		contentPane.add(btnReporteErroresCongenitos, gbc_btnReporteErroresCongenitos);
	}

}
