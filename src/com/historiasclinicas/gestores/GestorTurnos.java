package com.historiasclinicas.gestores;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.historiasclinicas.ejecucion.Errores;
import com.historiasclinicas.entidades.Estados;
import com.historiasclinicas.entidades.Paciente;
import com.historiasclinicas.entidades.Turnos;
import com.historiasclinicas.log.Log;
import com.historiasclinicas.pantallas.PantaLogin;

public class GestorTurnos {
	private static String perfil = PantaLogin.perfil.get(0).getPerfil();
	public static int ActualizaEstado (int i) throws IOException{
		int resultado = 0;
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();
		Query<?> query = null;
		if (perfil.equals("Secretaria"))
			query = session.createQuery("update Turnos t set t.estados.id = 2 where t.paciente =:paciente");
		else
			query = session.createQuery("update Turnos t set t.estados.id = 3 where t.paciente =:paciente");
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			query.setParameter("paciente", i);
			try {
				resultado = query.executeUpdate();
			} catch (final Exception e) {
				JOptionPane.showMessageDialog(null, Errores.UsuarioPassIncorrecto());
				Log.crearLog("Error login " + e);
			}
			transaction.commit();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	public static int CierraTurnos (int i) throws IOException{
		int resultado = 0;
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();
		Query<?> query = null;
		query = session.createQuery("update Turnos t set t.estados.id = 3 where t.paciente =:paciente");
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			query.setParameter("paciente", i);
			try {
				resultado = query.executeUpdate();
			} catch (final Exception e) {
				JOptionPane.showMessageDialog(null, Errores.UsuarioPassIncorrecto());
				Log.crearLog("Error login " + e);
			}
			transaction.commit();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings({ "unchecked" })
	public static List<Turnos> ConsultarTurno(String especialista, Date fechaTurno) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Turnos> turnos = new ArrayList<>();
		Transaction transaction = null;
		if (perfil.equals("Secretaria"))
		{
			try {
				final Query<Turnos> turno = session.createQuery("from Turnos as t where t.fechaTurno =:fecha");
				turno.setParameter("fecha", fechaTurno);
				turnos = turno.list();
				transaction = session.beginTransaction();
			} catch (final HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return turnos;
		}
		else
		{
			try {
				final Query<Turnos> turno = session.createQuery("from Turnos as t where t.especialista =:especialista and t.fechaTurno =:fecha");
				turno.setParameter("especialista", especialista);
				turno.setParameter("fecha", fechaTurno);
				turnos = turno.list();
				transaction = session.beginTransaction();
			} catch (final HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return turnos;
		}
	}

	public static boolean ConsultarTurnosPasados(Integer dni) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Turnos> turnos = new ArrayList<>();
		Transaction transaction = null;
		boolean estado = false;
		try {
			@SuppressWarnings("unchecked")
			final
			Query<Turnos> turno = session.createQuery("from Turnos t where t.paciente =:dni and t.estados.id = 1 or t.estados.id = 2");
			turno.setParameter("dni", dni);
			turnos = turno.list();
			if(!turnos.isEmpty())
			{
				Log.CreaLog("Hay turnos");
				estado = false;
			}
			else
			{
				Log.CreaLog("No hay turnos");
				estado = true;
			}
			transaction = session.beginTransaction();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return estado;
	}

	public static int NuevoTurno(Integer dni, Date fecha, String especialista, String horario) throws IOException {
		SessionFactory factory;
		int hecho = 0;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			Log.CreaLog(he.getMessage());
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			final Turnos turno = new Turnos();
			final List<Paciente> paciente = GestorPacientes.ConsultaInexistencia(dni);
			final Estados estado = GestorEstados.ConsultarEstado(1);
			turno.setPaciente(paciente.get(0).getDni());
			turno.setFechaTurno(fecha);
			turno.setEspecialista(especialista);
			turno.setEstados(estado);
			turno.setHoraTurno(horario);
			turno.setPacienteApellido(paciente.get(0).getApellido());
			turno.setPacienteNombre(paciente.get(0).getNombre());

			try {
				session.save(turno);
				hecho = 1;
				Log.CreaLog("Turno Ingresado con Exito");
				return hecho;
			} catch (final Exception e) {
				Log.CreaLog(e.getMessage().toString());
				hecho = 0;
				return hecho;
			}
		} catch (final HibernateException e) {
			if (transaction != null)
				hecho = 0;
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return hecho;
	}
}
