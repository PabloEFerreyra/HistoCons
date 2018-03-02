package com.historiasclinicas.pantallas;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.historiasclinicas.ejecucion.CanConvert;
import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.gestores.GestorPacientes;

public class PantaPlanillaPediatrico extends JFrame {

	private static final long serialVersionUID = -130425425718401788L;
	private Integer aborto = 0;
	private Boolean accPer = false;
	private Boolean alergiaFamiliares = false;
	private Boolean alergiasPer = false;
	private JPanel AntecPer;
	private JPanel antecPers;
	private Integer apgar1 = 0;
	private Integer apgar5 = 0;
	private Boolean asmaFamiliares = false;
	private Boolean asmaPer = false;
	private JButton btnErroresCongenitos;
	private JButton btnGuardar;
	private JButton btnOtros;
	private JButton btnOtros_1;
	private JButton btnTablasCrecimiento;
	private JButton btnVacunas;
	private final Boolean cancerFamiliares = false;
	private final Boolean cardiopatFamiliares = false;
	private Integer cesarea = 0;
	private JCheckBox chckbxAlergiaFam;
	private JCheckBox chckbxAlergias;
	private JCheckBox chckbxAsma;
	private JCheckBox chckbxAsmaFam;
	private JCheckBox chckbxCancer;
	private JCheckBox chckbxCardiopatias;
	private JCheckBox chckbxColagenopatias;
	private JCheckBox chckbxDiabetes;
	private JCheckBox chckbxEpilepsia;
	private JCheckBox chckbxHematooncolog;
	private JCheckBox chckbxHta;
	private JCheckBox chckbxMigraa;
	private JCheckBox chckbxMiopia;
	private JCheckBox chckbxNeurologicos;
	private JCheckBox chckbxNeuropsiquiatria;
	private JCheckBox chckbxObesidad;
	private JCheckBox chckbxOtitis;
	private JCheckBox chckbxTabaquismo;
	private JCheckBox chkbxAccidentes;
	private JCheckBox chkbxCirugias;
	private JCheckBox chkbxDBT;
	private JCheckBox chkbxDigestivos;
	private JCheckBox chkbxInfecc;
	private JCheckBox chkbxNeumonias;
	private JCheckBox chkbxOncologicos;
	private JCheckBox chkbxPaperas;
	private JCheckBox chkbxPsicologicos;
	private JCheckBox chkbxRubeola;
	private JCheckBox chkbxSarampion;
	private JCheckBox chkbxVaricela;
	private Boolean cirugiasPer = false;
	private final Boolean colagenopFamiliares = false;
	private JPanel contentPane;
	private Boolean dbtFamiliares = false;
	private Boolean dbtPer = false;
	private Boolean digestivos = false;
	private String egest = "";
	private final Boolean epilepsiaFamiliares = false;
	private Boolean erroresCong = false;
	private Integer gesta = 0;
	private final Boolean hematOncFamiliares = false;
	private Boolean hematoPer = false;
	private Box horizontalBox;
	private final Boolean htafamiliares = false;
	private Boolean infecUrPer = false;
	private JLabel label;
	private JLabel lblApgar;
	private JLabel lblApgar2;
	private JLabel lblCm;
	private JLabel lblCm2;
	private JLabel lblEGest;
	private JLabel lblGesta;
	private JLabel lblNewLabel;
	private JLabel lblPatologiasDelRn;
	private JLabel lblPerCef;
	private JLabel lblSem;
	private JLabel lblSem_1;
	private JLabel lblTalla;
	private JPanel medicacionPermanente;
	private String medPerm = "";
	private final Boolean migranaFamiliares = false;
	private final Boolean miopiaFamiliares = false;
	private Boolean neumPer = false;
	private final Boolean neuropsiqFamiliares = false;
	private Boolean neurPer = false;
	private final Boolean obesidadFamiliares = false;
	private Boolean otitisPer  = false;
	private final String otrosFamiliares = "";
	private String otrosPersonales = "";
	private Boolean paperasPer = false;
	private Integer parto = 0;
	private final String patolDelRn = "";
	private Integer perCef = 0;
	private Integer peso = 0;
	private Boolean psicolPer = false;
	private Boolean rubeolaPer = false;
	private Boolean sarampPer = false;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private Boolean tabaqFamiliares = false;
	private Integer talal = 0;
	private JTextField txtAborto;
	private JTextField txtApgar;
	private JTextField txtApgar2;
	private JTextField txtCesarea;
	private JTextField txtEgest;
	private JTextField txtGesta;
	private JTextField txtPaciente;
	private JTextField txtParto;
	private JTextField txtPerCef;
	private JTextField txtPeso;
	private JTextArea txtrMedicacionPermanente;
	private JTextArea txtrOtrosFamiliares;
	private JTextArea txtrOtrosPersonales;
	private JTextArea txtrPatologiasRn;
	private JTextField txtTalla;
	private Boolean varicelaPer = false;
	public PantaPlanillaPediatrico(Paciente paciente) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantaPlanillaPediatrico.class.getResource("/imagenes/logotipo.png")));
		setTitle("Planilla Pediatrico");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 13, 0};
		gbl_contentPane.rowHeights = new int[]{16, 19, 0, 41, 35, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblNewLabel = new JLabel("Planilla Pediatrico");
		lblNewLabel.setIcon(new ImageIcon(PantaPlanillaPediatrico.class.getResource("/imagenes/iconos/child.png")));
		final GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.gridwidth = 9;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		label = new JLabel("");
		label.setIcon(new ImageIcon(PantaPlanillaPediatrico.class.getResource("/imagenes/logotipo.png")));
		final GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridwidth = 9;
		gbc_label.gridheight = 3;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 9;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);

		final JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabbedPane.setBackground(SystemColor.controlHighlight);
		final GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.gridheight = 7;
		gbc_tabbedPane.gridwidth = 17;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 2;
		gbc_tabbedPane.gridy = 3;
		contentPane.add(tabbedPane, gbc_tabbedPane);

		antecPers = new JPanel();
		tabbedPane.addTab("Antec. Personales", (Icon) null, antecPers, null);
		final GridBagLayout gbl_antecPers = new GridBagLayout();
		gbl_antecPers.columnWidths = new int[]{63, 23, 108, 0};
		gbl_antecPers.rowHeights = new int[]{24, 23, 23, 23, 23, 23, 23, 23, 0, 23, 0};
		gbl_antecPers.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_antecPers.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		antecPers.setLayout(gbl_antecPers);

		chckbxAsma = new JCheckBox("Asma");
		chckbxAsma.addChangeListener(e -> {
			if(chckbxAsma.isSelected()==true)
				asmaPer = true;
			else
				asmaPer = false;
		});
		chckbxAsma.setForeground(SystemColor.window);
		chckbxAsma.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxAsma = new GridBagConstraints();
		gbc_chckbxAsma.anchor = GridBagConstraints.SOUTH;
		gbc_chckbxAsma.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxAsma.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAsma.gridwidth = 2;
		gbc_chckbxAsma.gridx = 0;
		gbc_chckbxAsma.gridy = 0;
		antecPers.add(chckbxAsma, gbc_chckbxAsma);

		chkbxRubeola = new JCheckBox("Rubeola");
		chkbxRubeola.addChangeListener(e -> {
			if(chkbxRubeola.isSelected() == true)
				rubeolaPer = true;
			else
				rubeolaPer = false;
		});
		chkbxRubeola.setForeground(Color.WHITE);
		chkbxRubeola.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxRubeola = new GridBagConstraints();
		gbc_chkbxRubeola.anchor = GridBagConstraints.NORTH;
		gbc_chkbxRubeola.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxRubeola.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxRubeola.gridx = 2;
		gbc_chkbxRubeola.gridy = 0;
		antecPers.add(chkbxRubeola, gbc_chkbxRubeola);

		chckbxAlergias = new JCheckBox("Alergias");
		chckbxAlergias.addChangeListener(e -> {
			if (chckbxAlergias.isSelected()==true)
				alergiasPer = true;
			else
				alergiasPer = false;
		});
		chckbxAlergias.setBackground(SystemColor.windowBorder);
		chckbxAlergias.setForeground(SystemColor.window);
		final GridBagConstraints gbc_chckbxAlergias = new GridBagConstraints();
		gbc_chckbxAlergias.anchor = GridBagConstraints.NORTH;
		gbc_chckbxAlergias.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxAlergias.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAlergias.gridwidth = 2;
		gbc_chckbxAlergias.gridx = 0;
		gbc_chckbxAlergias.gridy = 1;
		antecPers.add(chckbxAlergias, gbc_chckbxAlergias);

		chckbxOtitis = new JCheckBox("Otitis");
		chckbxOtitis.addChangeListener(e -> {
			if(chckbxOtitis.isSelected() == true)
				otitisPer = true;
			else
				otitisPer = false;
		});
		chckbxOtitis.setForeground(Color.WHITE);
		chckbxOtitis.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxOtitis = new GridBagConstraints();
		gbc_chckbxOtitis.anchor = GridBagConstraints.NORTH;
		gbc_chckbxOtitis.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxOtitis.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxOtitis.gridx = 2;
		gbc_chckbxOtitis.gridy = 1;
		antecPers.add(chckbxOtitis, gbc_chckbxOtitis);

		chckbxNeurologicos = new JCheckBox("Neurologicos");
		chckbxNeurologicos.addChangeListener(e -> {
			if (chckbxNeurologicos.isSelected()==true)
				neurPer = true;
			else
				neurPer = false;
		});
		chckbxNeurologicos.setForeground(Color.WHITE);
		chckbxNeurologicos.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxNeurologicos = new GridBagConstraints();
		gbc_chckbxNeurologicos.anchor = GridBagConstraints.NORTH;
		gbc_chckbxNeurologicos.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxNeurologicos.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNeurologicos.gridwidth = 2;
		gbc_chckbxNeurologicos.gridx = 0;
		gbc_chckbxNeurologicos.gridy = 2;
		antecPers.add(chckbxNeurologicos, gbc_chckbxNeurologicos);

		chkbxSarampion = new JCheckBox("Sarampion");
		chkbxSarampion.addChangeListener(e -> {
			if(chkbxSarampion.isSelected() == true)
				sarampPer = true;
			else
				sarampPer = false;
		});
		chkbxSarampion.setForeground(Color.WHITE);
		chkbxSarampion.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxSarampion = new GridBagConstraints();
		gbc_chkbxSarampion.anchor = GridBagConstraints.NORTH;
		gbc_chkbxSarampion.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxSarampion.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxSarampion.gridx = 2;
		gbc_chkbxSarampion.gridy = 2;
		antecPers.add(chkbxSarampion, gbc_chkbxSarampion);

		chkbxNeumonias = new JCheckBox("Neumonias");
		chkbxNeumonias.addChangeListener(e -> {
			if (chkbxNeumonias.isSelected()==true)
				neumPer = true;
			else
				neumPer = false;
		});
		chkbxNeumonias.setForeground(Color.WHITE);
		chkbxNeumonias.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxNeumonias = new GridBagConstraints();
		gbc_chkbxNeumonias.anchor = GridBagConstraints.NORTH;
		gbc_chkbxNeumonias.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxNeumonias.insets = new Insets(0, 0, 5, 5);
		gbc_chkbxNeumonias.gridwidth = 2;
		gbc_chkbxNeumonias.gridx = 0;
		gbc_chkbxNeumonias.gridy = 3;
		antecPers.add(chkbxNeumonias, gbc_chkbxNeumonias);

		chkbxVaricela = new JCheckBox("Varicela");
		chkbxVaricela.addChangeListener(e -> {
			if (chkbxVaricela.isSelected() == true)
				varicelaPer = true;
			else
				varicelaPer = false;
		});
		chkbxVaricela.setForeground(Color.WHITE);
		chkbxVaricela.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxVaricela = new GridBagConstraints();
		gbc_chkbxVaricela.anchor = GridBagConstraints.NORTH;
		gbc_chkbxVaricela.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxVaricela.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxVaricela.gridx = 2;
		gbc_chkbxVaricela.gridy = 3;
		antecPers.add(chkbxVaricela, gbc_chkbxVaricela);

		chkbxPaperas = new JCheckBox("Paperas");
		chkbxPaperas.addChangeListener(e -> {
			if (chkbxPaperas.isSelected()==true)
				paperasPer = true;
			else
				paperasPer = false;
		});
		chkbxPaperas.setForeground(Color.WHITE);
		chkbxPaperas.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxPaperas = new GridBagConstraints();
		gbc_chkbxPaperas.anchor = GridBagConstraints.NORTH;
		gbc_chkbxPaperas.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxPaperas.insets = new Insets(0, 0, 5, 5);
		gbc_chkbxPaperas.gridwidth = 2;
		gbc_chkbxPaperas.gridx = 0;
		gbc_chkbxPaperas.gridy = 4;
		antecPers.add(chkbxPaperas, gbc_chkbxPaperas);

		chkbxInfecc = new JCheckBox("Infec. Urinarias");
		chkbxInfecc.addChangeListener(e -> {
			if(chkbxInfecc.isSelected() == true)
				infecUrPer = true;
			else
				infecUrPer = false;
		});
		chkbxInfecc.setForeground(Color.WHITE);
		chkbxInfecc.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxInfecc = new GridBagConstraints();
		gbc_chkbxInfecc.anchor = GridBagConstraints.NORTH;
		gbc_chkbxInfecc.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxInfecc.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxInfecc.gridx = 2;
		gbc_chkbxInfecc.gridy = 4;
		antecPers.add(chkbxInfecc, gbc_chkbxInfecc);

		chkbxPsicologicos = new JCheckBox("Psicologicos");
		chkbxPsicologicos.addChangeListener(e -> {
			if(chkbxPsicologicos.isSelected() == true)
				psicolPer = true;
			else
				psicolPer = false;
		});
		chkbxPsicologicos.setForeground(Color.WHITE);
		chkbxPsicologicos.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxPsicologicos = new GridBagConstraints();
		gbc_chkbxPsicologicos.anchor = GridBagConstraints.NORTH;
		gbc_chkbxPsicologicos.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxPsicologicos.insets = new Insets(0, 0, 5, 5);
		gbc_chkbxPsicologicos.gridwidth = 2;
		gbc_chkbxPsicologicos.gridx = 0;
		gbc_chkbxPsicologicos.gridy = 5;
		antecPers.add(chkbxPsicologicos, gbc_chkbxPsicologicos);

		chkbxCirugias = new JCheckBox("Cirugias");
		chkbxCirugias.addChangeListener(e -> {
			if(chkbxCirugias.isSelected() == true)
				cirugiasPer = true;
			else
				cirugiasPer = false;
		});
		chkbxCirugias.setForeground(Color.WHITE);
		chkbxCirugias.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxCirugias = new GridBagConstraints();
		gbc_chkbxCirugias.anchor = GridBagConstraints.NORTH;
		gbc_chkbxCirugias.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxCirugias.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxCirugias.gridx = 2;
		gbc_chkbxCirugias.gridy = 5;
		antecPers.add(chkbxCirugias, gbc_chkbxCirugias);

		chkbxAccidentes = new JCheckBox("Accidentes");
		chkbxAccidentes.addChangeListener(e -> {
			if(chkbxAccidentes.isSelected() == true)
				accPer = true;
			else
				accPer = false;
		});
		chkbxAccidentes.setForeground(Color.WHITE);
		chkbxAccidentes.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxAccidentes = new GridBagConstraints();
		gbc_chkbxAccidentes.fill = GridBagConstraints.BOTH;
		gbc_chkbxAccidentes.insets = new Insets(0, 0, 5, 5);
		gbc_chkbxAccidentes.gridwidth = 2;
		gbc_chkbxAccidentes.gridx = 0;
		gbc_chkbxAccidentes.gridy = 6;
		antecPers.add(chkbxAccidentes, gbc_chkbxAccidentes);

		chkbxDBT = new JCheckBox("DBT");
		chkbxDBT.addChangeListener(e -> {
			if (chkbxDBT.isSelected() == true)
				dbtPer = true;
			else
				dbtPer = false;
		});
		chkbxDBT.setForeground(Color.WHITE);
		chkbxDBT.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxDBT = new GridBagConstraints();
		gbc_chkbxDBT.fill = GridBagConstraints.BOTH;
		gbc_chkbxDBT.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxDBT.gridx = 2;
		gbc_chkbxDBT.gridy = 6;
		antecPers.add(chkbxDBT, gbc_chkbxDBT);

		chkbxOncologicos = new JCheckBox("Hematonocolog.");
		chkbxOncologicos.addChangeListener(e -> {
			if(chkbxOncologicos.isSelected() == true)
				hematoPer = true;
			else
				hematoPer = false;
		});
		chkbxOncologicos.setForeground(Color.WHITE);
		chkbxOncologicos.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxOncologicos = new GridBagConstraints();
		gbc_chkbxOncologicos.anchor = GridBagConstraints.NORTH;
		gbc_chkbxOncologicos.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxOncologicos.insets = new Insets(0, 0, 5, 5);
		gbc_chkbxOncologicos.gridwidth = 2;
		gbc_chkbxOncologicos.gridx = 0;
		gbc_chkbxOncologicos.gridy = 7;
		antecPers.add(chkbxOncologicos, gbc_chkbxOncologicos);

		chkbxDigestivos = new JCheckBox("Digestivos");
		chkbxDigestivos.addChangeListener(e -> {
			if(chkbxDigestivos.isSelected() == true)
				digestivos = true;
			else
				digestivos = false;
		});
		chkbxDigestivos.setForeground(Color.WHITE);
		chkbxDigestivos.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chkbxDigestivos = new GridBagConstraints();
		gbc_chkbxDigestivos.anchor = GridBagConstraints.NORTH;
		gbc_chkbxDigestivos.fill = GridBagConstraints.HORIZONTAL;
		gbc_chkbxDigestivos.insets = new Insets(0, 0, 5, 0);
		gbc_chkbxDigestivos.gridx = 2;
		gbc_chkbxDigestivos.gridy = 7;
		antecPers.add(chkbxDigestivos, gbc_chkbxDigestivos);

		btnOtros = new JButton("Otros");
		btnOtros.setEnabled(false);

		btnOtros.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnOtros = new GridBagConstraints();
		gbc_btnOtros.fill = GridBagConstraints.BOTH;
		gbc_btnOtros.insets = new Insets(0, 0, 5, 5);
		gbc_btnOtros.gridx = 0;
		gbc_btnOtros.gridy = 8;
		antecPers.add(btnOtros, gbc_btnOtros);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 8;
		antecPers.add(scrollPane, gbc_scrollPane);

		txtrOtrosPersonales = new JTextArea();
		txtrOtrosPersonales.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				otrosPersonales = txtrOtrosPersonales.getText();
			}
		});
		scrollPane.setViewportView(txtrOtrosPersonales);

		AntecPer = new JPanel();
		tabbedPane.addTab("Antec. Perinatales", null, AntecPer, null);
		final GridBagLayout gbl_AntecPer = new GridBagLayout();
		gbl_AntecPer.columnWidths = new int[]{0, 0, 56, 25, 53, 97, 0, 0};
		gbl_AntecPer.rowHeights = new int[]{23, 20, 24, 20, 20, 20, 26, 0, 0};
		gbl_AntecPer.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_AntecPer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		AntecPer.setLayout(gbl_AntecPer);

		lblGesta = new JLabel("Gesta");
		lblGesta.setHorizontalAlignment(SwingConstants.LEFT);
		lblGesta.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_lblGesta = new GridBagConstraints();
		gbc_lblGesta.fill = GridBagConstraints.BOTH;
		gbc_lblGesta.insets = new Insets(0, 0, 5, 5);
		gbc_lblGesta.gridx = 0;
		gbc_lblGesta.gridy = 0;
		AntecPer.add(lblGesta, gbc_lblGesta);

		txtGesta = new JTextField();
		txtGesta.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGesta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!CanConvert.Convert(txtGesta.getText().toString()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					gesta = Integer.parseInt(txtGesta.getText());
			}
		});
		lblGesta.setLabelFor(txtGesta);
		final GridBagConstraints gbc_txtGesta = new GridBagConstraints();
		gbc_txtGesta.fill = GridBagConstraints.BOTH;
		gbc_txtGesta.insets = new Insets(0, 0, 5, 5);
		gbc_txtGesta.gridx = 1;
		gbc_txtGesta.gridy = 0;
		AntecPer.add(txtGesta, gbc_txtGesta);
		txtGesta.setColumns(10);

		lblSem = new JLabel("Sem.");
		lblSem.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_lblSem = new GridBagConstraints();
		gbc_lblSem.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSem.insets = new Insets(0, 0, 5, 5);
		gbc_lblSem.gridx = 2;
		gbc_lblSem.gridy = 0;
		AntecPer.add(lblSem, gbc_lblSem);

		final JLabel lblCesarea = new JLabel("Cesarea");
		lblCesarea.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_lblCesarea = new GridBagConstraints();
		gbc_lblCesarea.fill = GridBagConstraints.BOTH;
		gbc_lblCesarea.insets = new Insets(0, 0, 5, 5);
		gbc_lblCesarea.gridx = 4;
		gbc_lblCesarea.gridy = 0;
		AntecPer.add(lblCesarea, gbc_lblCesarea);

		txtCesarea = new JTextField();
		txtCesarea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!CanConvert.Convert(txtCesarea.getText()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					cesarea = Integer.parseInt(txtCesarea.getText());
			}
		});
		final GridBagConstraints gbc_txtCesarea = new GridBagConstraints();
		gbc_txtCesarea.fill = GridBagConstraints.BOTH;
		gbc_txtCesarea.insets = new Insets(0, 0, 5, 5);
		gbc_txtCesarea.gridx = 5;
		gbc_txtCesarea.gridy = 0;
		AntecPer.add(txtCesarea, gbc_txtCesarea);
		txtCesarea.setColumns(10);

		btnErroresCongenitos = new JButton("Errores Congenitos");
		btnErroresCongenitos.addActionListener(e -> {
			erroresCong = true;
			final PantaErroresCongenitos pec = new PantaErroresCongenitos(paciente);
			pec.setVisible(true);
		});
		btnErroresCongenitos.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnErroresCongenitos = new GridBagConstraints();
		gbc_btnErroresCongenitos.insets = new Insets(0, 0, 5, 0);
		gbc_btnErroresCongenitos.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnErroresCongenitos.gridx = 6;
		gbc_btnErroresCongenitos.gridy = 0;
		AntecPer.add(btnErroresCongenitos, gbc_btnErroresCongenitos);

		final JLabel lblParto = new JLabel("Parto");
		lblParto.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_lblParto = new GridBagConstraints();
		gbc_lblParto.fill = GridBagConstraints.BOTH;
		gbc_lblParto.insets = new Insets(0, 0, 5, 5);
		gbc_lblParto.gridx = 0;
		gbc_lblParto.gridy = 1;
		AntecPer.add(lblParto, gbc_lblParto);

		txtParto = new JTextField();
		txtParto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!CanConvert.Convert(txtParto.getText()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					parto = Integer.parseInt(txtParto.getText());
			}
		});
		txtParto.setHorizontalAlignment(SwingConstants.RIGHT);
		final GridBagConstraints gbc_txtParto = new GridBagConstraints();
		gbc_txtParto.fill = GridBagConstraints.BOTH;
		gbc_txtParto.insets = new Insets(0, 0, 5, 5);
		gbc_txtParto.gridx = 1;
		gbc_txtParto.gridy = 1;
		AntecPer.add(txtParto, gbc_txtParto);
		txtParto.setColumns(10);

		lblSem_1 = new JLabel("Sem.");
		lblSem_1.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_lblSem_1 = new GridBagConstraints();
		gbc_lblSem_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSem_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSem_1.gridx = 2;
		gbc_lblSem_1.gridy = 1;
		AntecPer.add(lblSem_1, gbc_lblSem_1);

		final JLabel lblAborto = new JLabel("Aborto");
		lblAborto.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_lblAborto = new GridBagConstraints();
		gbc_lblAborto.fill = GridBagConstraints.VERTICAL;
		gbc_lblAborto.anchor = GridBagConstraints.WEST;
		gbc_lblAborto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAborto.gridx = 4;
		gbc_lblAborto.gridy = 1;
		AntecPer.add(lblAborto, gbc_lblAborto);

		txtAborto = new JTextField();
		txtAborto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!CanConvert.Convert(txtAborto.getText()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					aborto = Integer.parseInt(txtAborto.getText());
			}
		});
		final GridBagConstraints gbc_txtAborto = new GridBagConstraints();
		gbc_txtAborto.fill = GridBagConstraints.BOTH;
		gbc_txtAborto.insets = new Insets(0, 0, 5, 5);
		gbc_txtAborto.gridx = 5;
		gbc_txtAborto.gridy = 1;
		AntecPer.add(txtAborto, gbc_txtAborto);
		txtAborto.setColumns(10);

		horizontalBox = Box.createHorizontalBox();
		horizontalBox.setForeground(Color.DARK_GRAY);
		horizontalBox.setBackground(Color.DARK_GRAY);
		horizontalBox.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		final GridBagConstraints gbc_horizontalBox = new GridBagConstraints();
		gbc_horizontalBox.fill = GridBagConstraints.BOTH;
		gbc_horizontalBox.gridwidth = 6;
		gbc_horizontalBox.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalBox.gridx = 0;
		gbc_horizontalBox.gridy = 2;
		AntecPer.add(horizontalBox, gbc_horizontalBox);

		final JLabel lblPeso = new JLabel("Peso");
		lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_lblPeso = new GridBagConstraints();
		gbc_lblPeso.fill = GridBagConstraints.BOTH;
		gbc_lblPeso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeso.gridx = 0;
		gbc_lblPeso.gridy = 3;
		AntecPer.add(lblPeso, gbc_lblPeso);

		txtPeso = new JTextField();
		txtPeso.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!CanConvert.Convert(txtPeso.getText()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					peso = Integer.parseInt(txtPeso.getText());
			}
		});
		txtPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		final GridBagConstraints gbc_txtPeso = new GridBagConstraints();
		gbc_txtPeso.fill = GridBagConstraints.BOTH;
		gbc_txtPeso.insets = new Insets(0, 0, 5, 5);
		gbc_txtPeso.gridx = 1;
		gbc_txtPeso.gridy = 3;
		AntecPer.add(txtPeso, gbc_txtPeso);
		txtPeso.setColumns(10);

		final JLabel lblGrs = new JLabel("grs.");
		lblGrs.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_lblGrs = new GridBagConstraints();
		gbc_lblGrs.fill = GridBagConstraints.BOTH;
		gbc_lblGrs.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrs.gridx = 2;
		gbc_lblGrs.gridy = 3;
		AntecPer.add(lblGrs, gbc_lblGrs);

		lblApgar = new JLabel("Apgar 1'");
		final GridBagConstraints gbc_lblApgar = new GridBagConstraints();
		gbc_lblApgar.fill = GridBagConstraints.BOTH;
		gbc_lblApgar.insets = new Insets(0, 0, 5, 5);
		gbc_lblApgar.gridx = 4;
		gbc_lblApgar.gridy = 3;
		AntecPer.add(lblApgar, gbc_lblApgar);

		txtApgar = new JTextField();
		txtApgar.setHorizontalAlignment(SwingConstants.RIGHT);
		txtApgar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!CanConvert.Convert(txtApgar.getText()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					apgar1 = Integer.parseInt(txtApgar.getText());
			}
		});
		final GridBagConstraints gbc_txtApgar = new GridBagConstraints();
		gbc_txtApgar.fill = GridBagConstraints.BOTH;
		gbc_txtApgar.insets = new Insets(0, 0, 5, 5);
		gbc_txtApgar.gridx = 5;
		gbc_txtApgar.gridy = 3;
		AntecPer.add(txtApgar, gbc_txtApgar);
		txtApgar.setColumns(10);

		lblTalla = new JLabel("Talla");
		final GridBagConstraints gbc_lblTalla = new GridBagConstraints();
		gbc_lblTalla.fill = GridBagConstraints.BOTH;
		gbc_lblTalla.insets = new Insets(0, 0, 5, 5);
		gbc_lblTalla.gridx = 0;
		gbc_lblTalla.gridy = 4;
		AntecPer.add(lblTalla, gbc_lblTalla);

		txtTalla = new JTextField();
		txtTalla.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!CanConvert.Convert(txtTalla.getText()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					talal = Integer.parseInt(txtTalla.getText());
			}
		});
		txtTalla.setHorizontalAlignment(SwingConstants.RIGHT);
		final GridBagConstraints gbc_txtTalla = new GridBagConstraints();
		gbc_txtTalla.fill = GridBagConstraints.BOTH;
		gbc_txtTalla.insets = new Insets(0, 0, 5, 5);
		gbc_txtTalla.gridx = 1;
		gbc_txtTalla.gridy = 4;
		AntecPer.add(txtTalla, gbc_txtTalla);
		txtTalla.setColumns(10);

		lblCm = new JLabel("cm.");
		final GridBagConstraints gbc_lblCm = new GridBagConstraints();
		gbc_lblCm.fill = GridBagConstraints.BOTH;
		gbc_lblCm.insets = new Insets(0, 0, 5, 5);
		gbc_lblCm.gridx = 2;
		gbc_lblCm.gridy = 4;
		AntecPer.add(lblCm, gbc_lblCm);

		lblApgar2 = new JLabel("Apgar 5'");
		final GridBagConstraints gbc_lblApgar2 = new GridBagConstraints();
		gbc_lblApgar2.fill = GridBagConstraints.BOTH;
		gbc_lblApgar2.insets = new Insets(0, 0, 5, 5);
		gbc_lblApgar2.gridx = 4;
		gbc_lblApgar2.gridy = 4;
		AntecPer.add(lblApgar2, gbc_lblApgar2);

		txtApgar2 = new JTextField();
		txtApgar2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!CanConvert.Convert(txtApgar2.getText()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					apgar5 = Integer.parseInt(txtApgar2.getText());
			}
		});
		txtApgar2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtApgar2.setColumns(10);
		final GridBagConstraints gbc_txtApgar2 = new GridBagConstraints();
		gbc_txtApgar2.fill = GridBagConstraints.BOTH;
		gbc_txtApgar2.insets = new Insets(0, 0, 5, 5);
		gbc_txtApgar2.gridx = 5;
		gbc_txtApgar2.gridy = 4;
		AntecPer.add(txtApgar2, gbc_txtApgar2);

		lblPerCef = new JLabel("Per. Cef");
		final GridBagConstraints gbc_lblPerCef = new GridBagConstraints();
		gbc_lblPerCef.fill = GridBagConstraints.BOTH;
		gbc_lblPerCef.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerCef.gridx = 0;
		gbc_lblPerCef.gridy = 5;
		AntecPer.add(lblPerCef, gbc_lblPerCef);

		txtPerCef = new JTextField();
		txtPerCef.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!CanConvert.Convert(txtPerCef.getText()))
					JOptionPane.showMessageDialog(new JDialog(), Errores.ErrorCampos(), "Error", JOptionPane.ERROR_MESSAGE);
				else
					perCef = Integer.parseInt(txtPerCef.getText());
			}
		});
		txtPerCef.setHorizontalAlignment(SwingConstants.RIGHT);
		final GridBagConstraints gbc_txtPerCef = new GridBagConstraints();
		gbc_txtPerCef.fill = GridBagConstraints.BOTH;
		gbc_txtPerCef.insets = new Insets(0, 0, 5, 5);
		gbc_txtPerCef.gridx = 1;
		gbc_txtPerCef.gridy = 5;
		AntecPer.add(txtPerCef, gbc_txtPerCef);
		txtPerCef.setColumns(10);

		lblCm2 = new JLabel("cm.");
		final GridBagConstraints gbc_lblCm2 = new GridBagConstraints();
		gbc_lblCm2.fill = GridBagConstraints.BOTH;
		gbc_lblCm2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCm2.gridx = 2;
		gbc_lblCm2.gridy = 5;
		AntecPer.add(lblCm2, gbc_lblCm2);

		lblEGest = new JLabel("E. Gest.");
		final GridBagConstraints gbc_lblEGest = new GridBagConstraints();
		gbc_lblEGest.fill = GridBagConstraints.BOTH;
		gbc_lblEGest.insets = new Insets(0, 0, 5, 5);
		gbc_lblEGest.gridx = 4;
		gbc_lblEGest.gridy = 5;
		AntecPer.add(lblEGest, gbc_lblEGest);

		txtEgest = new JTextField();
		txtEgest.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				egest = txtEgest.getText();
			}
		});
		txtEgest.setHorizontalAlignment(SwingConstants.RIGHT);
		final GridBagConstraints gbc_txtEgest = new GridBagConstraints();
		gbc_txtEgest.insets = new Insets(0, 0, 5, 5);
		gbc_txtEgest.fill = GridBagConstraints.BOTH;
		gbc_txtEgest.gridx = 5;
		gbc_txtEgest.gridy = 5;
		AntecPer.add(txtEgest, gbc_txtEgest);
		txtEgest.setColumns(10);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 2;
		gbc_scrollPane_2.gridwidth = 7;
		gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 6;
		AntecPer.add(scrollPane_2, gbc_scrollPane_2);

		txtrPatologiasRn = new JTextArea();
		scrollPane_2.setViewportView(txtrPatologiasRn);

		lblPatologiasDelRn = new JLabel("Patologias del RN");
		lblPatologiasDelRn.setBackground(Color.GRAY);
		scrollPane_2.setColumnHeaderView(lblPatologiasDelRn);

		final JPanel AntecFam = new JPanel();
		tabbedPane.addTab("Antec. Familiares", null, AntecFam, null);
		final GridBagLayout gbl_AntecFam = new GridBagLayout();
		gbl_AntecFam.columnWidths = new int[]{63, 89, 167, 0};
		gbl_AntecFam.rowHeights = new int[]{31, 31, 31, 31, 31, 31, 31, 31, 0, 0};
		gbl_AntecFam.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_AntecFam.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		AntecFam.setLayout(gbl_AntecFam);

		chckbxDiabetes = new JCheckBox("DBT");
		chckbxDiabetes.addChangeListener(e -> {
			if(chckbxDiabetes.isSelected() == true)
				dbtFamiliares = true;
			else
				dbtFamiliares = false;
		});
		chckbxDiabetes.setForeground(SystemColor.textHighlightText);
		chckbxDiabetes.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxDiabetes = new GridBagConstraints();
		gbc_chckbxDiabetes.gridwidth = 2;
		gbc_chckbxDiabetes.fill = GridBagConstraints.BOTH;
		gbc_chckbxDiabetes.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDiabetes.gridx = 0;
		gbc_chckbxDiabetes.gridy = 0;
		AntecFam.add(chckbxDiabetes, gbc_chckbxDiabetes);

		chckbxEpilepsia = new JCheckBox("Epilepsia");
		chckbxEpilepsia.setBackground(SystemColor.windowBorder);
		chckbxEpilepsia.setForeground(SystemColor.text);
		final GridBagConstraints gbc_chckbxEpilepsia = new GridBagConstraints();
		gbc_chckbxEpilepsia.fill = GridBagConstraints.BOTH;
		gbc_chckbxEpilepsia.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxEpilepsia.gridx = 2;
		gbc_chckbxEpilepsia.gridy = 0;
		AntecFam.add(chckbxEpilepsia, gbc_chckbxEpilepsia);

		chckbxAsmaFam = new JCheckBox("Asma");
		chckbxAsmaFam.addChangeListener(e -> {
			if(chckbxAsmaFam.isSelected() == true)
				asmaFamiliares = true;
			else
				asmaFamiliares = false;
		});
		chckbxAsmaFam.setBackground(SystemColor.windowBorder);
		chckbxAsmaFam.setForeground(SystemColor.textHighlightText);
		final GridBagConstraints gbc_chckbxAsmaFam = new GridBagConstraints();
		gbc_chckbxAsmaFam.gridwidth = 2;
		gbc_chckbxAsmaFam.fill = GridBagConstraints.BOTH;
		gbc_chckbxAsmaFam.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAsmaFam.gridx = 0;
		gbc_chckbxAsmaFam.gridy = 1;
		AntecFam.add(chckbxAsmaFam, gbc_chckbxAsmaFam);

		chckbxObesidad = new JCheckBox("Obesidad");
		chckbxObesidad.setForeground(SystemColor.text);
		chckbxObesidad.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxObesidad = new GridBagConstraints();
		gbc_chckbxObesidad.fill = GridBagConstraints.BOTH;
		gbc_chckbxObesidad.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxObesidad.gridx = 2;
		gbc_chckbxObesidad.gridy = 1;
		AntecFam.add(chckbxObesidad, gbc_chckbxObesidad);

		chckbxAlergiaFam = new JCheckBox("Alergia");
		chckbxAlergiaFam.addChangeListener(e -> {
			if(chckbxAlergiaFam.isSelected()==true)
				alergiaFamiliares = true;
			else
				alergiaFamiliares = false;
		});
		chckbxAlergiaFam.setForeground(SystemColor.text);
		chckbxAlergiaFam.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxAlergiaFam = new GridBagConstraints();
		gbc_chckbxAlergiaFam.gridwidth = 2;
		gbc_chckbxAlergiaFam.fill = GridBagConstraints.BOTH;
		gbc_chckbxAlergiaFam.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAlergiaFam.gridx = 0;
		gbc_chckbxAlergiaFam.gridy = 2;
		AntecFam.add(chckbxAlergiaFam, gbc_chckbxAlergiaFam);

		chckbxMigraa = new JCheckBox("Migra\u00F1a");
		chckbxMigraa.setForeground(SystemColor.text);
		chckbxMigraa.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxMigraa = new GridBagConstraints();
		gbc_chckbxMigraa.fill = GridBagConstraints.BOTH;
		gbc_chckbxMigraa.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxMigraa.gridx = 2;
		gbc_chckbxMigraa.gridy = 2;
		AntecFam.add(chckbxMigraa, gbc_chckbxMigraa);

		chckbxTabaquismo = new JCheckBox("Tabaquismo");
		chckbxTabaquismo.addChangeListener(e -> {
			if(chckbxTabaquismo.isSelected() == true)
				tabaqFamiliares = true;
			else
				tabaqFamiliares = false;
		});
		chckbxTabaquismo.setForeground(SystemColor.text);
		chckbxTabaquismo.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxTabaquismo = new GridBagConstraints();
		gbc_chckbxTabaquismo.gridwidth = 2;
		gbc_chckbxTabaquismo.fill = GridBagConstraints.BOTH;
		gbc_chckbxTabaquismo.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTabaquismo.gridx = 0;
		gbc_chckbxTabaquismo.gridy = 3;
		AntecFam.add(chckbxTabaquismo, gbc_chckbxTabaquismo);

		chckbxCancer = new JCheckBox("Cancer");
		chckbxCancer.setForeground(SystemColor.text);
		chckbxCancer.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxCancer = new GridBagConstraints();
		gbc_chckbxCancer.fill = GridBagConstraints.BOTH;
		gbc_chckbxCancer.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxCancer.gridx = 2;
		gbc_chckbxCancer.gridy = 3;
		AntecFam.add(chckbxCancer, gbc_chckbxCancer);

		chckbxHta = new JCheckBox("HTA");
		chckbxHta.setForeground(SystemColor.text);
		chckbxHta.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxHta = new GridBagConstraints();
		gbc_chckbxHta.gridwidth = 2;
		gbc_chckbxHta.fill = GridBagConstraints.BOTH;
		gbc_chckbxHta.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHta.gridx = 0;
		gbc_chckbxHta.gridy = 4;
		AntecFam.add(chckbxHta, gbc_chckbxHta);

		chckbxMiopia = new JCheckBox("Miopia");
		chckbxMiopia.setForeground(SystemColor.text);
		chckbxMiopia.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxMiopia = new GridBagConstraints();
		gbc_chckbxMiopia.fill = GridBagConstraints.BOTH;
		gbc_chckbxMiopia.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxMiopia.gridx = 2;
		gbc_chckbxMiopia.gridy = 4;
		AntecFam.add(chckbxMiopia, gbc_chckbxMiopia);

		chckbxCardiopatias = new JCheckBox("Cardiopatias");
		chckbxCardiopatias.setBackground(SystemColor.windowBorder);
		chckbxCardiopatias.setForeground(SystemColor.text);
		final GridBagConstraints gbc_chckbxCardiopatias = new GridBagConstraints();
		gbc_chckbxCardiopatias.gridwidth = 2;
		gbc_chckbxCardiopatias.fill = GridBagConstraints.BOTH;
		gbc_chckbxCardiopatias.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCardiopatias.gridx = 0;
		gbc_chckbxCardiopatias.gridy = 5;
		AntecFam.add(chckbxCardiopatias, gbc_chckbxCardiopatias);

		chckbxNeuropsiquiatria = new JCheckBox("Neuropsiquiatr.");
		chckbxNeuropsiquiatria.setForeground(SystemColor.text);
		chckbxNeuropsiquiatria.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxNeuropsiquiatria = new GridBagConstraints();
		gbc_chckbxNeuropsiquiatria.fill = GridBagConstraints.BOTH;
		gbc_chckbxNeuropsiquiatria.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNeuropsiquiatria.gridx = 2;
		gbc_chckbxNeuropsiquiatria.gridy = 5;
		AntecFam.add(chckbxNeuropsiquiatria, gbc_chckbxNeuropsiquiatria);

		chckbxColagenopatias = new JCheckBox("Colagenopatias");
		chckbxColagenopatias.setForeground(SystemColor.text);
		chckbxColagenopatias.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxColagenopatias = new GridBagConstraints();
		gbc_chckbxColagenopatias.gridwidth = 2;
		gbc_chckbxColagenopatias.fill = GridBagConstraints.BOTH;
		gbc_chckbxColagenopatias.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxColagenopatias.gridx = 0;
		gbc_chckbxColagenopatias.gridy = 6;
		AntecFam.add(chckbxColagenopatias, gbc_chckbxColagenopatias);

		chckbxHematooncolog = new JCheckBox("HematoOncolog.");
		chckbxHematooncolog.setForeground(SystemColor.text);
		chckbxHematooncolog.setBackground(SystemColor.windowBorder);
		final GridBagConstraints gbc_chckbxHematooncolog = new GridBagConstraints();
		gbc_chckbxHematooncolog.fill = GridBagConstraints.BOTH;
		gbc_chckbxHematooncolog.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxHematooncolog.gridx = 2;
		gbc_chckbxHematooncolog.gridy = 6;
		AntecFam.add(chckbxHematooncolog, gbc_chckbxHematooncolog);

		btnOtros_1 = new JButton("Otros");

		btnOtros_1.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnOtros_1 = new GridBagConstraints();
		gbc_btnOtros_1.fill = GridBagConstraints.BOTH;
		gbc_btnOtros_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnOtros_1.gridx = 0;
		gbc_btnOtros_1.gridy = 7;
		AntecFam.add(btnOtros_1, gbc_btnOtros_1);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 7;
		AntecFam.add(scrollPane_1, gbc_scrollPane_1);

		txtrOtrosFamiliares = new JTextArea();
		scrollPane_1.setViewportView(txtrOtrosFamiliares);

		medicacionPermanente = new JPanel();
		tabbedPane.addTab("Med. Permanente", null, medicacionPermanente, null);
		final GridBagLayout gbl_medicacionPermanente = new GridBagLayout();
		gbl_medicacionPermanente.columnWidths = new int[]{0, 0};
		gbl_medicacionPermanente.rowHeights = new int[]{0, 0};
		gbl_medicacionPermanente.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_medicacionPermanente.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		medicacionPermanente.setLayout(gbl_medicacionPermanente);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		final GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 0;
		medicacionPermanente.add(scrollPane_3, gbc_scrollPane_3);

		txtrMedicacionPermanente = new JTextArea();
		txtrMedicacionPermanente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtrMedicacionPermanente.getText().length() == 0)
					medPerm = "N/A";
				else
					medPerm = txtrMedicacionPermanente.getText();
			}
		});
		scrollPane_3.setViewportView(txtrMedicacionPermanente);

		btnVacunas = new JButton("Vacunas");
		btnVacunas.addActionListener(e -> {
			@SuppressWarnings("rawtypes")
			final
			SwingWorker worker = new SwingWorker(){
				@Override
				protected Object doInBackground() throws Exception {
					MuestraPantallaNuevasVacunas(paciente);
					return null;
				}
			};
			worker.execute();
		});
		btnVacunas.setIcon(new ImageIcon(PantaPlanillaPediatrico.class.getResource("/imagenes/iconos/twentytwo/eyedropper.png")));
		btnVacunas.setHorizontalAlignment(SwingConstants.LEFT);
		final GridBagConstraints gbc_btnVacunas = new GridBagConstraints();
		gbc_btnVacunas.gridwidth = 2;
		gbc_btnVacunas.fill = GridBagConstraints.BOTH;
		gbc_btnVacunas.insets = new Insets(0, 0, 5, 5);
		gbc_btnVacunas.gridx = 0;
		gbc_btnVacunas.gridy = 4;
		contentPane.add(btnVacunas, gbc_btnVacunas);

		btnTablasCrecimiento = new JButton("Tablas Crecimiento");
		btnTablasCrecimiento.addActionListener(e -> {
			final PantaCrecimiento pc = new PantaCrecimiento(paciente);
			pc.setVisible(true);
		});
		btnTablasCrecimiento.setHorizontalAlignment(SwingConstants.LEFT);
		btnTablasCrecimiento.setIcon(new ImageIcon(PantaPlanillaPediatrico.class.getResource("/imagenes/iconos/twentytwo/bar-chart.png")));
		final GridBagConstraints gbc_btnTablasCrecimiento = new GridBagConstraints();
		gbc_btnTablasCrecimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTablasCrecimiento.gridwidth = 2;
		gbc_btnTablasCrecimiento.insets = new Insets(0, 0, 5, 5);
		gbc_btnTablasCrecimiento.gridx = 0;
		gbc_btnTablasCrecimiento.gridy = 5;
		contentPane.add(btnTablasCrecimiento, gbc_btnTablasCrecimiento);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(e -> {
			@SuppressWarnings("rawtypes")
			final
			SwingWorker worker = new SwingWorker(){
				@Override
				protected Object doInBackground() throws Exception {

					final boolean resultado = GestorPacientes.IngresaPlanillaPediatrica(gesta, parto, cesarea, aborto, peso, talal, perCef, apgar1, apgar5, egest, patolDelRn,
							erroresCong, asmaPer, alergiasPer, neurPer, neumPer, paperasPer, psicolPer, accPer, hematoPer, rubeolaPer, otitisPer, sarampPer,
							varicelaPer, infecUrPer, cirugiasPer, dbtPer, digestivos, dbtFamiliares, asmaFamiliares, alergiaFamiliares, tabaqFamiliares, htafamiliares,
							cardiopatFamiliares, colagenopFamiliares, epilepsiaFamiliares, obesidadFamiliares, migranaFamiliares, cancerFamiliares, miopiaFamiliares,
							neuropsiqFamiliares, hematOncFamiliares, otrosPersonales, otrosFamiliares, medPerm, paciente.getDni());
					if (resultado)
					{
						JOptionPane.showMessageDialog(new JDialog(), "Ingresado Correctamente Resumen Antecedentes", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(new JDialog(), "Ocurrio un error, consulte a sistemas", "Error", JOptionPane.ERROR_MESSAGE);
					return null;
				}
			};
			worker.execute();
		});
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setIcon(new ImageIcon(PantaPlanillaPediatrico.class.getResource("/imagenes/iconos/twentytwo/save.png")));
		final GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.fill = GridBagConstraints.BOTH;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 8;
		contentPane.add(btnGuardar, gbc_btnGuardar);

		txtPaciente = new JTextField();
		txtPaciente.setEditable(false);
		txtPaciente.setText(paciente.getNombre() +" "+ paciente.getApellido());
		final GridBagConstraints gbc_txtPaciente = new GridBagConstraints();
		gbc_txtPaciente.gridwidth = 19;
		gbc_txtPaciente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPaciente.gridx = 0;
		gbc_txtPaciente.gridy = 10;
		contentPane.add(txtPaciente, gbc_txtPaciente);
		txtPaciente.setColumns(10);
	}
	private void MuestraPantallaNuevasVacunas(Paciente paciente) {
		PantaControlVacunas pvc;
		try {
			pvc = new PantaControlVacunas(paciente);
			pvc.setVisible(true);
		} catch (final ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
