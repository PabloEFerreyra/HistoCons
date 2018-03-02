package com.historiasclinicas.pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.historiasclinicas.entidades.Otrasvacunas;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorPacientes;

public class PantaMuestraOtrasVacunas extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 7202214690597156575L;
	private final JButton btnLlenarTabla;
	private final String[] columnNames = {"Nombre Vacuna", "Fecha Vacuna"};
	private final JPanel contentPane;
	private List<Otrasvacunas> ov;
	private final JTable table;

	public PantaMuestraOtrasVacunas(Paciente paciente) {

		setType(Type.POPUP);
		setTitle("Otras Vacunas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaMuestraOtrasVacunas.class.getResource("/imagenes/logotipo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nombre Vacuna", "Fecha Vacuna"
				}
				));
		scrollPane.setViewportView(table);

		btnLlenarTabla = new JButton("Llenar Tabla");
		btnLlenarTabla.addActionListener(arg0 -> {
			ov = GestorPacientes.ObtieneOtrasvacunas(paciente.getDni());
			LlenaTabla();
		});
		final GridBagConstraints gbc_btnLlenarTabla = new GridBagConstraints();
		gbc_btnLlenarTabla.gridx = 0;
		gbc_btnLlenarTabla.gridy = 1;
		contentPane.add(btnLlenarTabla, gbc_btnLlenarTabla);
	}

	private void LlenaTabla() {
		final DefaultTableModel df = new DefaultTableModel();
		df.setColumnIdentifiers(columnNames);
		final Object[] fila = new Object[df.getColumnCount()];
		for (int i = 0; i < ov.size(); i++) {
			fila[0] = ov.get(i).getNombreVacuna();
			fila[1] = ov.get(i).getFechaVacuna().toString();
			df.addRow(fila);
		}
		table.setModel(df);

	}

}
