package com.historiasclinicas.gestores;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.historiasclinicas.entidades.Horarios;

public class GestorHorarios {
	@SuppressWarnings({ "unchecked" })
	public static String[] ConsultarHorarios() {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		List<Horarios> horarios = new ArrayList<>();
		Transaction transaction = null;

		try {
			final Query<Horarios> horario = session.createQuery("select h.hora from Horarios h");
			horarios = horario.list();
			transaction = session.beginTransaction();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		final String[] horarios1 = horarios.toArray(new String[horarios.size()]);
		return horarios1;
	}
}
