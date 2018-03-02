package com.historiasclinicas.gestores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Crecimiento;
import com.historiasclinicas.entidades.Errorescongenitos;
import com.historiasclinicas.entidades.Otrasvacunas;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.entidades.Planillapediatrica;
import com.historiasclinicas.entidades.Vacunas;
import com.historiasclinicas.log.Log;

@SuppressWarnings("deprecation")
public class GestorPacientes {

	private static SessionFactory factory;
	private static Transaction transaction;
	private static final String UNUSED = "unused";
	public static int ActuaPaciente(Paciente pacientes) throws IOException {
		int resultado = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		final Query<?> query = session
				.createQuery("update Paciente p set p.nombre =:nombre, p.apellido =:apellido, p.sexo =:sexo,"
						+ "p.fechaNacimiento=:fechanac, p.obraSocial=:obrasocial, p.nroAfiliado =:numeroafiliado, p.planOs=:planobra, "
						+ "p.provincia =:provincia, p.ciudad =:ciudad, p.domicilio =:domicilio, p.telefono =:telefono,"
						+ "p.telefonoCelular=:celular, p.correo =:mail where p.dni =:dni");
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			query.setParameter("dni", pacientes.getDni());
			query.setParameter("apellido", pacientes.getApellido());
			query.setParameter("nombre", pacientes.getNombre());
			query.setParameter("sexo", pacientes.getSexo());
			query.setParameter("fechanac", pacientes.getFechaNacimiento());
			query.setParameter("obrasocial", pacientes.getObraSocial());
			query.setParameter("numeroafiliado", pacientes.getNroAfiliado());
			query.setParameter("planobra", pacientes.getPlanOs());
			query.setParameter("provincia", pacientes.getProvincia());
			query.setParameter("ciudad", pacientes.getCiudad());
			query.setParameter("domicilio", pacientes.getDomicilio());
			query.setParameter("telefono", pacientes.getTelefono());
			query.setParameter("celular", pacientes.getTelefonoCelular());
			query.setParameter("mail", pacientes.getCorreo());
			try {
				resultado = query.executeUpdate();
			} catch (final Exception e) {
				JOptionPane.showMessageDialog(null, Errores.UsuarioPassIncorrecto());
				Log.CreaLog("Error login " + e);
			}
			transaction.commit();
		} catch (final HibernateException e) {
			Log.CreaLog(e.toString());
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings({ })
	public static Paciente ConsultaExistencia (int DNI) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		Paciente pacientes = new Paciente();
		Transaction transaction = null;
		final Query<?> paciente = session.createQuery("select p.dni, p.nombre, p.apellido from Paciente p where p.dni =:dni").setMaxResults(1);
		transaction = null;
		try {
			paciente.setParameter("dni", DNI);
			transaction = session.beginTransaction();

			if (!paciente.list().isEmpty())
				return pacientes;
			else
				Errores.dnipacienteexistente();
			pacientes = null;
			return pacientes;
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		return pacientes;
	}

	@SuppressWarnings("unchecked")
	public static List<Paciente> ConsultaInexistencia (int DNI) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Paciente> pacientes = new ArrayList<>();
		Transaction transaction = null;
		pacientes = session.createCriteria(Paciente.class).add(Restrictions.eq("dni", DNI)).list();
		transaction = null;
		try {
			transaction = session.beginTransaction();

			if (pacientes.isEmpty())
			{
				Errores.dnipacientenoexistente();
				pacientes = null;
				return pacientes;
			}
			else{
				return pacientes;
			}
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		return pacientes;
	}

	public static int ConsultarDni(int dni) throws IOException {
		int resultado = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		final Query<?> paciente = session.createQuery("select p.dni from Paciente p where p.dni =:dni").setMaxResults(1);
		transaction = null;
		try {
			paciente.setParameter("dni", dni);
			transaction = session.beginTransaction();

			if (!paciente.list().isEmpty())
				resultado = 1;
			else
				resultado = 0;
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			Log.CreaLog(e.toString());
			resultado = 0;
		} finally {
			transaction.commit();
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings({ "unchecked", UNUSED })
	public static List<Paciente> ConsultarPaciente(String apellido) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		List<Paciente> pacientes = new ArrayList<>();
		final Transaction transaction = null;
		try {
			pacientes = session.createCriteria(Paciente.class).add(Restrictions.like("apellido", apellido + "%")).list();
			if(pacientes.isEmpty())
			{
				pacientes = session.createCriteria(Paciente.class).add(Restrictions.like("nombre", apellido + "%")).list();
				if(pacientes.isEmpty())
					pacientes = session.createCriteria(Paciente.class).add(Restrictions.like("dni", Integer.parseInt(apellido))).list();
			}

		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pacientes;

	}

	@SuppressWarnings("unchecked")
	public static List<Vacunas> ConsultaVacunas (Integer DNI) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Vacunas> vacunas = new ArrayList<>();
		Transaction transaction = null;
		vacunas = session.createCriteria(Vacunas.class).add(Restrictions.eq("paciente", DNI)).list();
		transaction = null;
		try {
			transaction = session.beginTransaction();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		return vacunas;
	}

	public static Long CuentaCreciemiento(Integer paciente) {
		long count = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		Transaction transaction = null;
		final Query<?> query = session.createQuery("select count(*) from Crecimiento c where c.paciente =:paciente ");
		try {
			transaction = session.beginTransaction();
			query.setParameter("paciente", paciente);
			count = (long) query.uniqueResult();

		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	public static long CuentaErrorescongenitos(Integer dniPaciente) {
		long count = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		Transaction transaction = null;
		final Query<?> query = session.createQuery("select count(*) from Errorescongenitos ec where ec.paciente =:paciente ");
		try {
			transaction = session.beginTransaction();
			query.setParameter("paciente", dniPaciente);
			count = (long) query.uniqueResult();

		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	public static long cuentaPediatrico(int paciente) {
		long count = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		Transaction transaction = null;
		final Query<?> query = session.createQuery("select count(*) from Planillapediatrica pp where pp.paciente =:paciente ");
		try {
			transaction = session.beginTransaction();
			query.setParameter("paciente", paciente);
			count = (long) query.uniqueResult();

		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	public static long CuentaVacunas(int paciente) {
		long count = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		Transaction transaction = null;
		final Query<?> query = session.createQuery("select count(*) from Vacunas v where v.paciente =:paciente ");
		try {
			transaction = session.beginTransaction();
			query.setParameter("paciente", paciente);
			count = (long) query.uniqueResult();

		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}

	public static boolean GuardaCrecimiento(Integer paciente, Integer edad, String tiempo, Float peso, Integer percPeso,
			Float talla, Integer percTalla, Float perCef, Integer percPerCef, String imc) {
		boolean resultado = false;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		transaction = null;
		try {
			final Crecimiento c = new Crecimiento();
			c.setPaciente(paciente);
			c.setEdad(edad);
			c.setTiempo(tiempo);
			c.setPeso(peso);
			c.setPercPeso(percPeso);
			c.setTalla(talla);
			c.setPerTalla(percTalla);
			c.setPerCef(perCef);
			c.setPerPerCef(percPerCef);
			c.setImc(imc);
			try {
				session.save(c);
				resultado = true;
				return resultado;
			} catch (final Exception e) {
				resultado = false;
				return resultado;
			}
		} catch (final HibernateException e) {
			if (transaction != null)
				resultado = false;
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings({ UNUSED, "null" })
	public static boolean GuardaErrorescongenitos(Boolean hipotCong, Integer hipotNorm, Boolean fenilcetonuria,
			Integer fenilcetNorm, Boolean fqp, Integer fqpNorm, Boolean biotidinasa, Integer biotNorm,
			Boolean galactosemia, Integer galacNom, Boolean hidroxiprogres, Integer hidroNorm, String otrosErrores, int paciente) {
		boolean resultado = false;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		final Transaction transaction = null;
		try {
			final Errorescongenitos ec = new Errorescongenitos();
			ec.setBiotidinasa(biotidinasa);
			ec.setBiotNorm(biotNorm);
			ec.setFenilcetNorm(fenilcetNorm);
			ec.setFenilcetonuria(fenilcetonuria);
			ec.setFqp(fqp);
			ec.setFqpNorm(fqpNorm);
			ec.setGalacNom(galacNom);
			ec.setGalactosemia(galactosemia);
			ec.setHidroNorm(hidroNorm);
			ec.setHidroxiprogres(hidroxiprogres);
			ec.setHipotCong(hipotCong);
			ec.setHipotNorm(hipotNorm);
			ec.setOtrosErrores(otrosErrores);
			ec.setPaciente(paciente);
			try {
				session.save(ec);
				resultado = true;
				return resultado;
			} catch (final Exception e) {
				resultado = false;
				return resultado;
			}
		} catch (final HibernateException e) {
			if (transaction != null)
				resultado = false;
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	public static boolean GuardaOtrasvacunas(String nombreVacuna, String fechaVacuna, Integer pac) {
		boolean resultado = false;

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		transaction = null;
		try {
			final Otrasvacunas ov = new Otrasvacunas();
			ov.setFechaVacuna(fechaVacuna);
			ov.setNombreVacuna(nombreVacuna);
			ov.setPaciente(pac);
			try {
				session.save(ov);
				resultado = true;
				return resultado;
			} catch (final Exception e) {
				resultado = false;
				return resultado;
			}
		} catch (final HibernateException e) {
			if (transaction != null)
				resultado = false;
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	public static boolean GuardaVacunas(String bcg, String sabin, String hepB, String dpt, String hib, String prs,
			String dta, String hepA, Boolean otros, Integer pacient) {
		boolean resultado = false;

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		transaction = null;
		try {
			final Vacunas v = new Vacunas();
			v.setPaciente(pacient);
			v.setBcg(bcg);
			v.setSabin(sabin);
			v.setHepB(hepB);
			v.setDpt(dpt);
			v.setHib(hib);
			v.setPrs(prs);
			v.setDta(dta);
			v.setHepA(hepA);
			v.setOtras(otros);
			try {
				session.save(v);
				resultado = true;
				return resultado;
			} catch (final Exception e) {
				resultado = false;
				return resultado;
			}
		} catch (final HibernateException e) {
			if (transaction != null)
				resultado = false;
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings({ UNUSED, "null" })
	public static boolean IngresaPlanillaPediatrica(Integer gesta, Integer parto, Integer cesarea, Integer aborto,
			Integer peso, Integer talal, Integer perCef, Integer apgar1, Integer apgar5, String egest,
			String patolDelRn, Boolean erroresCong, Boolean asmaPer, Boolean alergiasPer, Boolean neurPer,
			Boolean neumPer, Boolean paperasPer, Boolean psicolPer, Boolean accPer, Boolean hematoPer,
			Boolean rubeolaPer, Boolean otitisPer, Boolean sarampPer, Boolean varicelaPer, Boolean infecUrPer,
			Boolean cirugiasPer, Boolean dbtPer, Boolean digestivos, Boolean dbtFamiliares, Boolean asmaFamiliares,
			Boolean alergiaFamiliares, Boolean tabaqFamiliares, Boolean htafamiliares, Boolean cardiopatFamiliares,
			Boolean colagenopFamiliares, Boolean epilepsiaFamiliares, Boolean obesidadFamiliares,
			Boolean migranaFamiliares, Boolean cancerFamiliares, Boolean miopiaFamiliares, Boolean neuropsiqFamiliares,
			Boolean hematOncFamiliares, String otrosPersonales, String otrosFamiliares, String medPerm, Integer paciente) {
		boolean resultado = false;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		final Transaction transaction = null;
		try {
			final Planillapediatrica planillapediatrico = new Planillapediatrica();
			planillapediatrico.setPaciente(paciente);
			planillapediatrico.setGesta(gesta);
			planillapediatrico.setParto(parto);
			planillapediatrico.setCesarea(cesarea);
			planillapediatrico.setAborto(aborto);
			planillapediatrico.setPeso(peso);
			planillapediatrico.setTalal(talal);
			planillapediatrico.setPerCef(perCef);
			planillapediatrico.setApgar1(apgar1);
			planillapediatrico.setApgar5(apgar5);
			planillapediatrico.setEgest(egest);
			planillapediatrico.setPatolDelRn(patolDelRn);
			planillapediatrico.setErroresCong(erroresCong);
			planillapediatrico.setAsmaPer(asmaPer);
			planillapediatrico.setAlergiasPer(alergiasPer);
			planillapediatrico.setNeurPer(neurPer);
			planillapediatrico.setNeumPer(neumPer);
			planillapediatrico.setPaperasPer(paperasPer);
			planillapediatrico.setPsicolPer(psicolPer);
			planillapediatrico.setAccPer(accPer);
			planillapediatrico.setHematoPer(hematoPer);
			planillapediatrico.setRubeolaPer(rubeolaPer);
			planillapediatrico.setOtitisPer(otitisPer);
			planillapediatrico.setSarampPer(sarampPer);
			planillapediatrico.setVaricelaPer(varicelaPer);
			planillapediatrico.setInfecUrPer(infecUrPer);
			planillapediatrico.setCirugiasPer(cirugiasPer);
			planillapediatrico.setDbtPer(dbtPer);
			planillapediatrico.setDigestivos(digestivos);
			planillapediatrico.setDbtFamiliares(dbtFamiliares);
			planillapediatrico.setAsmaFamiliares(asmaFamiliares);
			planillapediatrico.setAlergiaFamiliares(alergiaFamiliares);
			planillapediatrico.setTabaqFamiliares(tabaqFamiliares);
			planillapediatrico.setHtafamiliares(htafamiliares);
			planillapediatrico.setCardiopatFamiliares(cardiopatFamiliares);
			planillapediatrico.setMigranaFamiliares(migranaFamiliares);
			planillapediatrico.setColagenopFamiliares(colagenopFamiliares);
			planillapediatrico.setEpilepsiaFamiliares(epilepsiaFamiliares);
			planillapediatrico.setObesidadFamiliares(obesidadFamiliares);
			planillapediatrico.setMigranaFamiliares(migranaFamiliares);
			planillapediatrico.setCancerFamiliares(cancerFamiliares);
			planillapediatrico.setMiopiaFamiliares(miopiaFamiliares);
			planillapediatrico.setNeuropsiqFamiliares(neuropsiqFamiliares);
			planillapediatrico.setHematOncFamiliares(hematOncFamiliares);
			planillapediatrico.setOtrosPersonales(otrosPersonales);
			planillapediatrico.setOtrosFamiliares(otrosFamiliares);
			planillapediatrico.setMedPerm(medPerm);
			try {
				session.save(planillapediatrico);
				resultado = true;
				return resultado;
			} catch (final Exception e) {
				resultado = false;
				return resultado;
			}
		} catch (final HibernateException e) {
			if (transaction != null)
				resultado = false;
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings({ UNUSED, "null" })
	public static int IngresarPaciente(int dni, String nombre, String apellido, Integer sexo, Date fechanac,
			Integer obrasocial, String numeroafiliado, String planobra, Integer provincia, Integer ciudad, String domicilio,
			Long telefono, Long celular, String gs, String mail) throws IOException {
		int resultado = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			Log.CreaLog(he.toString());
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		final Transaction transaction = null;
		try {
			final Paciente pacientes = new Paciente();
			pacientes.setDni(dni);
			pacientes.setNombre(nombre);
			pacientes.setApellido(apellido);
			pacientes.setSexo(sexo);
			pacientes.setFechaNacimiento(fechanac);
			pacientes.setObraSocial(obrasocial);
			pacientes.setNroAfiliado(numeroafiliado);
			pacientes.setPlanOs(planobra);
			pacientes.setProvincia(provincia);
			pacientes.setCiudad(ciudad);
			pacientes.setDomicilio(domicilio);
			pacientes.setTelefono(telefono);
			pacientes.setTelefonoCelular(celular);
			pacientes.setCorreo(mail);
			pacientes.setGruposanguineo(gs);

			try {
				session.save(pacientes);
				Log.crearLog("Ingreso de paciente Correcto");
				resultado = 1;
				return resultado;
			} catch (final Exception e) {
				Log.CreaLog(e.toString());
				resultado = 0;
				return resultado;
			}
		} catch (final HibernateException e) {
			Log.CreaLog(e.toString());
			if (transaction != null)
				resultado = 0;
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	public static List<Otrasvacunas> ObtieneOtrasvacunas(Integer paciente) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Otrasvacunas> vacunas = new ArrayList<>();
		Transaction transaction = null;
		vacunas = session.createCriteria(Otrasvacunas.class).add(Restrictions.eq("paciente", paciente)).list();
		transaction = null;
		try {
			transaction = session.beginTransaction();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		return vacunas;
	}

	@SuppressWarnings("unchecked")
	public static List<Crecimiento> TraeCrecimiento(Integer paciente) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Crecimiento> crecimiento = new ArrayList<>();
		Transaction transaction = null;
		crecimiento = session.createCriteria(Crecimiento.class).add(Restrictions.eq("paciente", paciente)).list();
		transaction = null;
		try {
			transaction = session.beginTransaction();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally{
			session.close();
		}
		return crecimiento;
	}

	@SuppressWarnings(UNUSED)
	public static Errorescongenitos TraeErrorescongenitos(Integer dniPaciente) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		Errorescongenitos ec = new Errorescongenitos();
		final Transaction transaction = null;
		try {
			ec = (Errorescongenitos) session.createCriteria(Errorescongenitos.class).add(Restrictions.like("Paciente", dniPaciente)).uniqueResult();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ec;
	}

	@SuppressWarnings(UNUSED)
	public static Planillapediatrica TraePediatrico(Paciente pacientes) throws IOException {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			Log.CreaLog(he.toString());
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		Planillapediatrica planillaPediatrica = new Planillapediatrica();
		final Transaction transaction = null;
		try {
			planillaPediatrica = (Planillapediatrica) session.createCriteria(Planillapediatrica.class)
					.add(Restrictions.like("paciente", pacientes.getDni())).uniqueResult();
		} catch (final HibernateException e) {
			Log.CreaLog(e.toString());
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return planillaPediatrica;
	}
}
