package com.historiasclinicas.pantallas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.entidades.Vacunas;
import com.historiasclinicas.gestores.GestorPacientes;

public class PantaMuestraVacunas extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 7697971655344290478L;
	private final JButton btnOtrasVacunas;
	private final JButton btnRecargar;
	private final String[] columnNames = { "BCG", "Sabin", "Hep B", "DPT", "HIB", "PRS", "DTa", "Hep A", "Otras Vacunas" };
	private final JPanel contentPane;
	private PantaMuestraOtrasVacunas pmov;
	private final JScrollPane scrollPane;
	private final JTable table;
	private List<Vacunas> vacunas = null;

	public PantaMuestraVacunas(Paciente paciente) {
		vacunas  = GestorPacientes.ConsultaVacunas(paciente.getDni());

		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaMuestraVacunas.class.getResource("/imagenes/logotipo.png")));
		setTitle("Muestra Tabla Vacunas");
		setBounds(100, 100, 802, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{108, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		final JLabel lblTablaVacunas = new JLabel("Tabla Vacunas");
		lblTablaVacunas.setIcon(new ImageIcon(PantaMuestraVacunas.class.getResource("/imagenes/iconos/calendar.png")));
		final GridBagConstraints gbc_lblTablaVacunas = new GridBagConstraints();
		gbc_lblTablaVacunas.gridwidth = 2;
		gbc_lblTablaVacunas.fill = GridBagConstraints.BOTH;
		gbc_lblTablaVacunas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTablaVacunas.gridx = 0;
		gbc_lblTablaVacunas.gridy = 0;
		contentPane.add(lblTablaVacunas, gbc_lblTablaVacunas);

		final JLabel lblHistocons = new JLabel("");
		lblHistocons.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHistocons.setIcon(new ImageIcon(PantaMuestraVacunas.class.getResource("/imagenes/logotipo.png")));
		final GridBagConstraints gbc_lblHistocons = new GridBagConstraints();
		gbc_lblHistocons.fill = GridBagConstraints.BOTH;
		gbc_lblHistocons.insets = new Insets(0, 0, 5, 0);
		gbc_lblHistocons.gridx = 2;
		gbc_lblHistocons.gridy = 0;
		contentPane.add(lblHistocons, gbc_lblHistocons);

		btnRecargar = new JButton("Recargar Tabla");
		btnRecargar.setIcon(new ImageIcon(PantaMuestraVacunas.class.getResource("/imagenes/iconos/twentytwo/asterisk.png")));
		btnRecargar.addActionListener(e -> LlenaTabla());
		btnRecargar.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnRecargar = new GridBagConstraints();
		gbc_btnRecargar.fill = GridBagConstraints.VERTICAL;
		gbc_btnRecargar.gridwidth = 2;
		gbc_btnRecargar.anchor = GridBagConstraints.WEST;
		gbc_btnRecargar.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecargar.gridx = 0;
		gbc_btnRecargar.gridy = 1;
		contentPane.add(btnRecargar, gbc_btnRecargar);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"BCG", "Sabin", "Hep B", "DPT", "HIB", "PRS", "DTa", "Hep A", "Otras Vacunas"
				}
				));
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		scrollPane.setViewportView(table);

		btnOtrasVacunas = new JButton("Otras Vacunas");
		btnOtrasVacunas.setEnabled(false);
		btnOtrasVacunas.addActionListener(e -> {
			pmov = new PantaMuestraOtrasVacunas(paciente);
			pmov.setVisible(true);
		});
		final GridBagConstraints gbc_btnOtrasVacunas = new GridBagConstraints();
		gbc_btnOtrasVacunas.insets = new Insets(0, 0, 0, 5);
		gbc_btnOtrasVacunas.anchor = GridBagConstraints.WEST;
		gbc_btnOtrasVacunas.gridx = 0;
		gbc_btnOtrasVacunas.gridy = 3;
		contentPane.add(btnOtrasVacunas, gbc_btnOtrasVacunas);
	}
	void LlenaTabla() {
		final DefaultTableModel df = new DefaultTableModel();
		df.setColumnIdentifiers(columnNames);
		final Object[] fila = new Object[df.getColumnCount()];
		for (int i = 0; i < vacunas.size(); i++) {
			fila[0] = vacunas.get(i).getBcg().toString();
			fila[1] = vacunas.get(i).getSabin().toString();
			fila[2] = vacunas.get(i).getHepB().toString();
			fila[3] = vacunas.get(i).getDpt().toString();
			fila[4] = vacunas.get(i).getHib().toString();
			fila[5] = vacunas.get(i).getPrs().toString();
			fila[6] = vacunas.get(i).getDta().toString();
			fila[7] = vacunas.get(i).getHepA().toString();
			if(vacunas.get(i).getOtras())
			{
				fila[8] = "SI";
				btnOtrasVacunas.setEnabled(true);
			}
			else
			{
				fila[8] = "NO";
				btnOtrasVacunas.setEnabled(false);
			}
			df.addRow(fila);
		}
		table.setModel(df);
	}


}
