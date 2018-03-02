package com.historiasclinicas.pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.gestores.Conexion;
import com.historiasclinicas.gestores.GestorOS;
import com.historiasclinicas.gestores.GestorUsuarios;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class PantaInformesAdmin extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -1687014496505109122L;
	private final JButton btnInformeIngresosMedicos;
	@SuppressWarnings("rawtypes")
	private final JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private final JComboBox comboBox_1;
	private final JPanel contentPane;
	private final String[] listaOS;
	@SuppressWarnings("rawtypes")
	private Map parametro;
	private final String[] usuarios;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PantaInformesAdmin() {
		listaOS = GestorOS.ConsultarOS();
		usuarios = GestorUsuarios.TraeNombreUsuarios();
		setResizable(false);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaInformesAdmin.class.getResource("/imagenes/logotipo.png")));
		setTitle("Imprimir Informes");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 180, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(listaOS));
		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox, gbc_comboBox);


		final JButton btnInformeObrasSociales = new JButton("Informe Obras Sociales");
		btnInformeObrasSociales.setHorizontalAlignment(SwingConstants.LEFT);
		btnInformeObrasSociales.addActionListener(e -> {
			parametro = new HashMap();
			parametro.put("obrasocial", comboBox.getSelectedIndex());

			JasperReport jr = null;
			final String archivo = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\ObrasSociales.jasper";
			try {
				jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
				final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());
				JasperPrintManager.printReport(jp, true);

			} catch (final JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		final GridBagConstraints gbc_btnInformeObrasSociales = new GridBagConstraints();
		gbc_btnInformeObrasSociales.insets = new Insets(0, 0, 5, 0);
		gbc_btnInformeObrasSociales.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInformeObrasSociales.gridx = 0;
		gbc_btnInformeObrasSociales.gridy = 0;
		contentPane.add(btnInformeObrasSociales, gbc_btnInformeObrasSociales);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(usuarios));
		final GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 3;
		contentPane.add(comboBox_1, gbc_comboBox_1);

		btnInformeIngresosMedicos = new JButton("Informe Ingresos Medicos");
		btnInformeIngresosMedicos.addActionListener(arg0 -> {
			parametro = new HashMap();
			parametro.put("medico", comboBox_1.getSelectedItem().toString());

			JasperReport jr = null;
			final String archivo = "C:\\Program Files (x86)\\Pablo Ferreyra\\Historias Clinicas\\HistoriasClinicas\\IngresoUsuarios.jasper";
			try {
				jr = (JasperReport) JRLoader.loadObjectFromFile(archivo);
				final JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion.getConexion());

				JasperPrintManager.printReport(jp, true);

			} catch (final JRException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		final GridBagConstraints gbc_btnInformeIngresosMedicos = new GridBagConstraints();
		gbc_btnInformeIngresosMedicos.insets = new Insets(0, 0, 5, 0);
		gbc_btnInformeIngresosMedicos.fill = GridBagConstraints.BOTH;
		gbc_btnInformeIngresosMedicos.gridx = 0;
		gbc_btnInformeIngresosMedicos.gridy = 2;
		contentPane.add(btnInformeIngresosMedicos, gbc_btnInformeIngresosMedicos);
	}

}
