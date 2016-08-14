package com.histocons.gestores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/*-Hibernate Imports-*/
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*-End Hibernate Imports-*/

import com.histocons.ejecucion.Errores;
import com.histocons.entidades.Usuarios;


public class GestorUsuarios {

	@SuppressWarnings({ "unchecked", "unused" })
	public static List<Usuarios> TraeUsuarios()
	{
		SessionFactory factory;
		try 
		{ 
			factory = new Configuration().configure().buildSessionFactory();
		}
		catch (HibernateException he) 
		{ 
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
			throw new ExceptionInInitializerError(he); 
		} 
		
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		Transaction transaction = null;
		try
		{
			usuarios = session.createCriteria(Usuarios.class).list();
		}
		catch (HibernateException e) {
	        if (transaction != null)
	            transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		return usuarios; 
	}
	
	public static int NuevoUsuario (String usuario, String passwrd, String activo, String perfil) {
		SessionFactory factory;
		int hecho = 0;
        try 
	    { 
        	factory = new Configuration().configure().buildSessionFactory();
	    } catch (HibernateException he) 
	    { 
	        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
	        throw new ExceptionInInitializerError(he); 
	    } 
        Session session = factory.openSession();
        
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			Usuarios usuario1 = new Usuarios();
			usuario1.setUsername(usuario);
			usuario1.setPassword(passwrd);
			usuario1.setIsactive(activo);
			usuario1.setPerfil(perfil);
			
			try{
				session.save(usuario1);
				hecho = 1;
				return hecho;
			}
			catch(Exception e)
			{
				hecho = 0;
				return hecho;
			}
		}
		catch (HibernateException e) {
			if (transaction != null)
				hecho = 0;
				transaction.rollback();
			e.printStackTrace();
			} finally {
				session.close();
			}
		return hecho;
	}
	public static int ActualizaUsuario(Usuarios usuarios) throws IOException
	{
		int resultado = 0;
		SessionFactory factory;
        try 
	    { 
        	factory = new Configuration().configure().buildSessionFactory();
	    } catch (HibernateException he) 
	    { 
	        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
	        throw new ExceptionInInitializerError(he); 
	    } 
        Session session = factory.openSession();
        
        Query query = session.createQuery("update Usuarios u set u.password =:clave, u.perfil =:perf, u.isactive =:activo where u.username =:usuario");
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			query.setParameter("usuario", usuarios.getUsername());
			query.setParameter("clave", usuarios.getPassword());
			query.setParameter("perf", usuarios.getPerfil());
			query.setParameter("activo", usuarios.getIsactive());
			try{
				resultado =query.executeUpdate();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, Errores.UsuarioPassIncorrecto());
				com.histocons.log.Log.crearLog("Error login " + e);
			}
			transaction.commit();
		}
		catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
			} finally {
				session.close();
			}
		return resultado;
	}
}
