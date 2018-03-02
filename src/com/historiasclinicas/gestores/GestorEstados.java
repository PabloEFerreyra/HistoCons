package com.historiasclinicas.gestores;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.historiasclinicas.entidades.Estados;

public class GestorEstados {

	private static Estados estado;

	public static Estados ConsultarEstado(int i) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (final HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		final Session session = factory.openSession();
		estado = new Estados();
		Transaction transaction = null;
		try {
			@SuppressWarnings("unchecked")
			final
			Query<Estados> turno = session.createQuery("from Estados e where e.id =:i");
			turno.setParameter("i", i);

			if(!turno.getSingleResult().equals(null))
				estado = turno.getSingleResult();
			else
				estado = null;
			transaction = session.beginTransaction();
		} catch (final HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return estado;
	}

}
