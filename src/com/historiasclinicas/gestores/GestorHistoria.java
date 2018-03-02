package com.historiasclinicas.gestores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.historiasclinicas.entidades.Historia;

public class GestorHistoria {

	private static Transaction transaction;

	@SuppressWarnings({ "deprecation", "unchecked", "unused" })
	public static List<Historia> ConsultarHistoria(int dni) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();

		List<Historia> listaHistoria = new ArrayList<>();

		final Transaction transaction = null;
		try {
			listaHistoria = session.createCriteria(Historia.class).add(Restrictions.eq("paciente", dni)).list();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listaHistoria;
	}

	public static boolean NuevoIngreso(int dni, Date fechaActual, String sintomas,
			String otros, String laboratorio, String evolucion, String observaciones, String diagnosticoprinc,
			String diagnosticosec, String especialista, String especialidad, Integer orden) throws IOException {
		boolean error = false;
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}
		final Session session = factory.openSession();

		transaction = null;
		try {
			final Historia historias = new Historia();
			historias.setPaciente(dni);
			historias.setFecha(fechaActual);
			historias.setAntecedentes(sintomas);
			historias.setOtros(otros);
			historias.setLaboratorio(laboratorio);
			historias.setEvolucion(observaciones);
			historias.setObservaciones(observaciones);
			historias.setDiagprinc(diagnosticoprinc);
			historias.setDiagsec(diagnosticosec);
			historias.setEspecialista(especialista);
			historias.setEspecialidad(especialidad);
			try {
				session.save(historias);
			} catch (final Exception e) {
				error = true;
				return error;
			}
		} catch (final HibernateException e) {
			error = true;
			transaction.rollback();
			e.printStackTrace();
			return error;
		} finally {
			session.close();
		}
		return error;
	}
}